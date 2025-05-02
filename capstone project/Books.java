package library.managmentsystem;


import java.time.LocalDate;

public class Books {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int quantity;
    private int borrowedCount = 0;
    private int reservedCount = 0;
    private LocalDate issueDate;
    private LocalDate reserveDate;

    public Books(String title, String author, int id, String genre, int quantity) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.genre = genre;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return borrowedCount < quantity; }
    public boolean isReservable() { return (borrowedCount + reservedCount) < quantity; }

    public void borrow() {
        borrowedCount++;
        issueDate = LocalDate.now();
    }

    public void returnBook() {
        borrowedCount--;
        issueDate = null;
    }

    public void reserve() {
        reservedCount++;
        reserveDate = LocalDate.now();
    }

    public void cancelReservation() {
        reservedCount--;
        reserveDate = null;
    }

    public int getRemainingCopies() {
        return quantity - (borrowedCount + reservedCount);
    }

    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getReserveDate() { return reserveDate; }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author +
               ", Genre: " + genre + ", Available: " + getRemainingCopies();
    }
}
