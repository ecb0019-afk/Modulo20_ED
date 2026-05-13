package cleancode;

public class Book {
    private String title;
    private String author;
    private double basePrice;
    private double multiplier;
    private double damagePenalty;

    public Book(String title, String author, double basePrice, double multiplier, double damagePenalty) {
        this.title = title;
        this.author = author;
        this.basePrice = basePrice;
        this.multiplier = multiplier;
        this.damagePenalty = damagePenalty;
    }

    public double calculateCurrentValue() {
        double value = (this.basePrice * this.multiplier) - this.damagePenalty;
        return Math.max(0, value);
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getBasePrice() { return basePrice; }
}
