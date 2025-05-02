package library.managmentsystem;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import  library.managmentsystem.Books;

public class Librarys {
    private ArrayList<Books> catalog = new ArrayList<>();
    private ArrayList<Students> studentsList = new ArrayList<>();

    public void addItem(Books book) {
        catalog.add(book);
        System.out.println("Book added: " + book);
    }

    public void addStudent(Students student) {
        studentsList.add(student);
    }

    public Books findBookById(int id) {
        for (Books book : catalog) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    public void displayItems() {
        System.out.println("\nLibrary Catalog:");
        for (Books book : catalog) {
            System.out.println(book);
        }
    }

    public void borrowItem(int id, Students student) {
        Books book = findBookById(id);
        if (book != null && book.isAvailable()) {
            student.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not available or not found.");
        }
    }

    public void returnItem(int id, Students student) {
        Books book = findBookById(id);
        if (book != null) {
            long daysBetween = ChronoUnit.DAYS.between(book.getIssueDate(), LocalDate.now());
            if (daysBetween > 15) {
                long fine = (daysBetween - 15) * 10;
                System.out.println("Late return. Fine: ₹" + fine);
            } else {
                System.out.println("Book returned on time. No fine.");
            }
            student.returnBook(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void reserveItem(int id, Students student) {
        Books book = findBookById(id);
        if (book != null && book.isReservable()) {
            student.reserveBook(book);
            System.out.println("Book reserved successfully. Please borrow within 2 days.");
        } else {
            System.out.println("Book cannot be reserved or not found.");
        }
    }
    public ArrayList<Books> getItems() {
    	 return catalog;
    }
    private ArrayList<Students> studentsList1 = new ArrayList<>();
    public ArrayList<Students> getStudents() {
        return studentsList;
    }

    public void displayStudentDetails() {
        for (Students student : studentsList) {
            System.out.println("\n" + student.getDetails());
        }
    }
}
