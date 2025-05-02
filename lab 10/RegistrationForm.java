package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame implements ActionListener {

    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton;
    private JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel, messageLabel;

    public RegistrationForm() {
        // Set the title of the JFrame
        super("Registration Form");

        // Use GridBagLayout for a more structured layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding around components

        // Initialize the labels
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        messageLabel = new JLabel(""); // Label for displaying messages (success or errors)

        // Initialize the text fields
        nameField = new JTextField(20); // Set the column width
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        // Initialize the register button
        registerButton = new JButton("Register");
        registerButton.addActionListener(this); // Register the ActionListener

        // Add components to the JFrame using GridBagConstraints
        // GridBagConstraints allows you to specify how components are placed
        // within the grid layout.
        gbc.gridx = 0; // Grid column
        gbc.gridy = 0; // Grid row
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(confirmPasswordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(confirmPasswordField, gbc);

        gbc.gridx = 1; // Span two columns
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Span two columns
        add(messageLabel, gbc);

        // Set frame properties
        setSize(400, 250); // Adjusted size to better fit the components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true); // Make the JFrame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            handleRegistration();
        }
    }

    private void handleRegistration() {
        // Get the text from the input fields
        String name = nameField.getText().trim(); // Remove leading/trailing spaces
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword()); // Get password as char[]
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // 1. Check for empty fields
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            messageLabel.setText("All fields are required.");
            messageLabel.setForeground(Color.RED);
            return; // Stop processing if any field is empty
        }

        // 2. Validate email format (using a simple regex)
        if (!isValidEmail(email)) {
            messageLabel.setText("Invalid email format.");
            messageLabel.setForeground(Color.RED);
            return;
        }

        // 3. Check if passwords match
        if (!password.equals(confirmPassword)) {
            messageLabel.setText("Passwords do not match.");
            messageLabel.setForeground(Color.RED);
            return;
        }

        // If all validations pass, display a success message
        messageLabel.setText("Registration successful!");
        messageLabel.setForeground(Color.GREEN);

        // Clear the input fields after successful registration
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    // Helper method to validate email format using regular expression
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety for GUI updates
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }
}

