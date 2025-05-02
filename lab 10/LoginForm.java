package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel messageLabel;

    public LoginForm() {
        // Set the title of the JFrame
        super("Login Form");

        // Set the layout manager to FlowLayout for simplicity
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create the labels
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        messageLabel = new JLabel(""); // To display validation messages

        // Create the text fields
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        // Create the login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this); // Register the ActionListener

        // Add the components to the JFrame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(messageLabel);

        // Set the size of the JFrame
        setSize(300, 180);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            // Validate the username and password
            if (username.equals("admin") && password.equals("password")) {
                messageLabel.setText("Login Successful!");
                messageLabel.setForeground(Color.GREEN);
            } else {
                messageLabel.setText("Login Failed. Invalid username or password.");
                messageLabel.setForeground(Color.RED);
            }

            // Clear the password field after attempting login for security
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        // Use EventQueue.invokeLater to ensure thread safety for Swing GUI updates
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}