package cleancode;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Member member;
    private List<Book> books;
    private double finalTotal;
    private String status;

    public Order(Member member) {
        this.member = member;
        this.books = new ArrayList<>();
        this.status = "PENDING";
    }

    public void addBook(Book book) { books.add(book); }
    public Member getMember() { return member; }
    public List<Book> getBooks() { return books; }
    public double getFinalTotal() { return finalTotal; }
    public void setFinalTotal(double finalTotal) { this.finalTotal = finalTotal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
