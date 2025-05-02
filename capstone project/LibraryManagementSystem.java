package library.managmentsystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Creating a Library instance
        Librarys myLibrary = new Librarys();
        Scanner scanner = new Scanner(System.in);

        // Sample books to initialize the library
        addSampleBooks(myLibrary);

        System.out.print("Are you an Admin or Student? (admin/student): ");
        String userType = scanner.nextLine().toLowerCase();

        System.out.print("Enter your Name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your SAP ID: ");
        String sapId = scanner.nextLine();

        Students currentStudent = null;
        if (userType.equals("student")) {
            currentStudent = new Students(userName, sapId);
            myLibrary.addStudent(currentStudent);
            studentMenu(myLibrary, scanner, currentStudent);
        } else if (userType.equals("admin")) {
            adminMenu(myLibrary, scanner);
        } else {
            System.out.println("Invalid user type.");
        }

        scanner.close();
    }

    public static void adminMenu(Librarys library, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Catalog");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();
                    library.addItem(new Books(title, author, id, genre, qty));
                    break;
                case 2:
                    library.displayItems();
                    break;
                case 3:
                    library.displayStudentDetails();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void studentMenu(Librarys library, Scanner scanner, Students student) {
        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Reserve Book");
            System.out.println("4. Display Catalog");
            System.out.println("5. View My Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID to Borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowItem(borrowId, student);
                    break;
                case 2:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = scanner.nextInt();
                    library.returnItem(returnId, student);
                    break;
                case 3:
                    System.out.print("Enter Book ID to Reserve: ");
                    int reserveId = scanner.nextInt();
                    library.reserveItem(reserveId, student);
                    break;
                case 4:
                    library.displayItems();
                    break;
                case 5:
                    System.out.println(student.getDetails());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void addSampleBooks(Librarys library) {
        library.addItem(new Books("Maths", "R.D. Sharma", 1, "Education", 15));
        library.addItem(new Books("OOPS", "Bjarne Stroustrup", 2, "Programming", 15));
        library.addItem(new Books("English", "Wren & Martin", 3, "Language", 15));
        library.addItem(new Books("Hindi", "NCERT", 4, "Language", 15));
        library.addItem(new Books("C Programming", "Dennis Ritchie", 5, "Programming", 15));
        library.addItem(new Books("Python", "Guido van Rossum", 6, "Programming", 15));
        library.addItem(new Books("Software Engineering", "Ian Sommerville", 7, "Tech", 15));
        library.addItem(new Books("DCN", "Andrew S. Tanenbaum", 8, "Networking", 15));
    }
}

