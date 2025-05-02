package vishu;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book() {
        this.title = "Untitled";
        this.author = "Unknown Author";
        this.publicationYear = 0;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.publicationYear = 0;
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void displayDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        if (this.publicationYear != 0) {
            System.out.println("Publication Year: " + this.publicationYear);
        } else {
            System.out.println("Publication Year: Not Available");
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book3 = new Book("1984", "George Orwell", 1949);

        System.out.println("Book 1 Details:");
        book1.displayDetails();
        System.out.println("\nBook 2 Details:");
        book2.displayDetails();
        System.out.println("\nBook 3 Details:");
        book3.displayDetails();
    }
}