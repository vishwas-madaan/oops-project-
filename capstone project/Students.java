package library.managmentsystem;


import java.util.ArrayList;
import java.util.HashMap;

import library.managmentsystem.Books;

public class Students {
    private String name;
    private String sapId;
    private ArrayList<Books> borrowedBooks = new ArrayList<>();
    private HashMap<Books, String> reservedBooks = new HashMap<>();

    public Students(String name, String sapId) {
        this.name = name;
        this.sapId = sapId;
    }

    public void borrowBook(Books book) {
        borrowedBooks.add(book);
        book.borrow();
    }

    public void returnBook(Books book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    public void reserveBook(Books book) {
        reservedBooks.put(book, "Reserved");
        book.reserve();
    }
    public String getName() {
        return this.name;
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append("\n");
        sb.append("SAP ID: ").append(sapId).append("\n");

        sb.append("Borrowed Books:\n");
        for (Books book : borrowedBooks) {
            sb.append("  - ").append(book.getTitle())
              .append(" | Deadline: ").append(book.getIssueDate().plusDays(15)).append("\n");
        }

        sb.append("Reserved Books:\n");
        for (Books book : reservedBooks.keySet()) {
            sb.append("  - ").append(book.getTitle())
              .append(" | Reserve Deadline: ").append(book.getReserveDate().plusDays(2)).append("\n");
        }

        return sb.toString();
    }
}
