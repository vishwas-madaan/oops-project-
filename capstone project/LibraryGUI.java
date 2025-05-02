package library.managmentsystem;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI {
    private JFrame frame;
    private Librarys library;

    public LibraryGUI() {
        library = new Librarys();
        LibraryManagementSystem.addSampleBooks(library); // if static

        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        showUserTypeSelection();
    }

    private void showUserTypeSelection() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JTextField nameField = new JTextField();
        JTextField sapField = new JTextField();

        JButton studentBtn = new JButton("Login as Student");
        JButton adminBtn = new JButton("Login as Admin");

        panel.add(new JLabel("Enter Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Enter SAP ID:"));
        panel.add(sapField);

        JPanel buttons = new JPanel();
        buttons.add(studentBtn);
        buttons.add(adminBtn);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();

        studentBtn.addActionListener(e -> {
            Students student = new Students(nameField.getText(), sapField.getText());
            library.addStudent(student);
            showStudentMenu(student);
        });

        adminBtn.addActionListener(e -> showAdminMenu());
    }

    private void showStudentMenu(Students student) {
        String[] options = {
            "Borrow Book", "Return Book", "Reserve Book",
            "Display Catalog", "View My Details", "Back"
        };

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Student Menu - Welcome " + student.getName());
        panel.add(label, BorderLayout.NORTH);

        JList<String> menuList = new JList<>(options);
        panel.add(new JScrollPane(menuList), BorderLayout.CENTER);

        JButton selectBtn = new JButton("Select");
        panel.add(selectBtn, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();

        selectBtn.addActionListener(e -> {
            int selected = menuList.getSelectedIndex();
            switch (selected) {
                case 0 -> borrowBook(student);
                case 1 -> returnBook(student);
                case 2 -> reserveBook(student);
                case 3 -> displayCatalog();
                case 4 -> showStudentDetails(student);
                case 5 -> showUserTypeSelection();
            }
        });
    }

    private void showAdminMenu() {
        String[] options = {
            "Add Book", "Display Catalog", "Display All Students", "Back"
        };

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Admin Menu");
        panel.add(label, BorderLayout.NORTH);

        JList<String> menuList = new JList<>(options);
        panel.add(new JScrollPane(menuList), BorderLayout.CENTER);

        JButton selectBtn = new JButton("Select");
        panel.add(selectBtn, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();

        selectBtn.addActionListener(e -> {
            int selected = menuList.getSelectedIndex();
            switch (selected) {
                case 0 -> addBook();
                case 1 -> displayCatalog();
                case 2 -> displayAllStudents();
                case 3 -> showUserTypeSelection();
            }
        });
    }

    private void addBook() {
        JTextField title = new JTextField();
        JTextField author = new JTextField();
        JTextField id = new JTextField();
        JTextField genre = new JTextField();
        JTextField qty = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Title:")); panel.add(title);
        panel.add(new JLabel("Author:")); panel.add(author);
        panel.add(new JLabel("ID:")); panel.add(id);
        panel.add(new JLabel("Genre:")); panel.add(genre);
        panel.add(new JLabel("Quantity:")); panel.add(qty);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add New Book",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Books book = new Books(
                    title.getText(),
                    author.getText(),
                    Integer.parseInt(id.getText()),
                    genre.getText(),
                    Integer.parseInt(qty.getText())
                );
                library.addItem(book);
                JOptionPane.showMessageDialog(frame, "Book Added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number format.");
            }
        }
    }

    private void borrowBook(Students student) {
        String input = JOptionPane.showInputDialog("Enter Book ID to Borrow:");
        if (input != null) {
            try {
                int bookId = Integer.parseInt(input);
                library.borrowItem(bookId, student);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
            }
        }
    }

    private void returnBook(Students student) {
        String input = JOptionPane.showInputDialog("Enter Book ID to Return:");
        if (input != null) {
            try {
                int bookId = Integer.parseInt(input);
                library.returnItem(bookId, student);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
            }
        }
    }

    private void reserveBook(Students student) {
        String input = JOptionPane.showInputDialog("Enter Book ID to Reserve:");
        if (input != null) {
            try {
                int bookId = Integer.parseInt(input);
                library.reserveItem(bookId, student);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
            }
        }
    }

    private void displayCatalog() {
        StringBuilder sb = new StringBuilder("Book Catalog:\n");
        for (Books book : library.getItems()) {
            sb.append(book).append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
    }

    private void displayAllStudents() {
        StringBuilder sb = new StringBuilder("All Students:\n");
        for (Students s : library.getStudents()) {
            sb.append(s.getDetails()).append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
    }

    private void showStudentDetails(Students student) {
        JOptionPane.showMessageDialog(frame, student.getDetails());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryGUI().frame.setVisible(true));
    }
}
