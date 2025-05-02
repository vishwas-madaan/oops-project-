package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TodoListApp extends JFrame implements ActionListener {

    private JTextField taskInput;
    private JButton addButton;
    private JButton removeButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel; // Use DefaultListModel
    private JLabel titleLabel;

    public TodoListApp() {
        // Set up the JFrame
        super("To-Do List Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10)); // Add some gaps

        // Create the title label
        titleLabel = new JLabel("My To-Do List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Create the task input text field
        taskInput = new JTextField(20);
        add(taskInput, BorderLayout.CENTER);

        // Create the buttons
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        // Create a JPanel to hold the buttons, using FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Create the JList to display the tasks
        listModel = new DefaultListModel<>(); // Use DefaultListModel
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selections

        // Add the JList to a JScrollPane for better usability
        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.WEST);

        // Make the JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addTask();
        } else if (e.getSource() == removeButton) {
            removeTasks();
        }
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task); // Use addElement for DefaultListModel
            taskInput.setText(""); // Clear the input field
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTasks() {
         int[] selectedIndices = taskList.getSelectedIndices();
        if (selectedIndices.length > 0) {
            // Iterate in reverse to avoid index out of bounds
            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                listModel.removeElementAt(selectedIndices[i]); // Use removeElementAt
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to remove!", "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater for thread safety
        SwingUtilities.invokeLater(() -> new TodoListApp());
    }
}

