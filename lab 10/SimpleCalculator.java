package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] digitButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton;
    private JPanel buttonPanel;

    private double num1 = 0;
    private String operator = "";

    public SimpleCalculator() {
        super("Simple Calculator");

        // Set layout for the main frame
        setLayout(new BorderLayout());

        // Create the display text field
        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Create button panel with GridLayout
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Create digit buttons
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
        }

        // Create operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        // Add ActionListener to operator buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to the button panel in the desired order
        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(divButton);

        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(mulButton);

        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(subButton);

        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(addButton);

        // Add the button panel to the main frame
        add(buttonPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            display.setText(display.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            }
        } else if (command.equals("=")) {
            if (!display.getText().isEmpty()) {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("Error: Division by zero");
                            return;
                        }
                        break;
                }
                display.setText(String.valueOf(result));
                num1 = result; // Store result for potential further calculations
                operator = "";
            }
        } else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}