package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryAppSeleniumTest {

    private static WebDriver driver;
    private static String appUrl;

    @BeforeAll
    public static void setUpClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); 
        options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
        File file = new File("webapp/index.html");
        appUrl = "file:///" + file.getAbsolutePath().replace('\\', '/');
    }

    @BeforeEach
    public void setUp() {
        driver.get(appUrl);
    }

    @AfterAll
    public static void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPageLoadsProperly() {
        assertEquals("Clean Library App", driver.getTitle());
    }

    @Test
    public void testAddToCartUpdatesCounter() {
        var buttons = driver.findElements(By.className("add-to-cart-btn"));
        
        buttons.get(0).click();
        assertEquals("1", driver.findElement(By.id("cartCount")).getText());
        
        buttons.get(1).click();
        assertEquals("2", driver.findElement(By.id("cartCount")).getText());
    }

    @Test
    public void testDiscountApplicationAtCheckout() {
        driver.findElements(By.className("add-to-cart-btn")).get(0).click();
        
        driver.findElement(By.id("nav-checkout")).click();
        
        assertEquals("30.00", driver.findElement(By.id("subTotal")).getText());
        assertEquals("30.00", driver.findElement(By.id("finalPrice")).getText());
        
        WebElement discountDropdown = driver.findElement(By.id("discountType"));
        discountDropdown.sendKeys("Student"); 
        
        driver.findElement(By.id("finalPrice")).click(); 
        
        assertEquals("27.00", driver.findElement(By.id("finalPrice")).getText());
    }

    @Test
    public void testOrderCompletionValidation() {
        driver.findElement(By.id("nav-checkout")).click();
        
        driver.findElement(By.id("completeOrderBtn")).click();
        
        assertTrue(driver.findElement(By.id("memberError")).isDisplayed(), "Member error should show");
        
        driver.findElement(By.id("memberId")).sendKeys("John Doe");
        driver.findElement(By.id("completeOrderBtn")).click();
        
        assertTrue(driver.findElement(By.id("cartError")).isDisplayed(), "Cart error should show");
    }

    @Test
    public void testReportGeneration() {
        driver.findElement(By.id("nav-reports")).click();
        
        driver.findElement(By.id("generateReportBtn")).click();
        
        assertTrue(driver.findElement(By.id("reportContainer")).isDisplayed());
        String text = driver.findElement(By.id("reportOutput")).getText();
        assertTrue(text.contains("All items checked out successfully."));
    }
}
