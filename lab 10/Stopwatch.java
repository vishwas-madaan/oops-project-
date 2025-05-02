package lab10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Stopwatch extends JFrame implements ActionListener {

    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int seconds = 0;
    private boolean isRunning = false;

    public Stopwatch() {
        // Set the title of the JFrame
        super("Stopwatch");

        // Use FlowLayout for a simple layout
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Add some gaps

        // Initialize the timeLabel
        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Make it bigger and bold
        timeLabel.setPreferredSize(new Dimension(200, 50));  //set the size of the label

        // Initialize the buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        // Add action listeners to the buttons
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Timer to update the timeLabel every second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                updateTimeLabel();
            }
        });

        // Add components to the JFrame
        add(timeLabel);
        add(startButton);
        add(stopButton);
        add(resetButton);

        // Set frame properties
        setSize(300, 180); // Adjusted size for better fit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setResizable(false); // Prevent resizing for a cleaner look
        setVisible(true); // Make the JFrame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startStopwatch();
        } else if (e.getSource() == stopButton) {
            stopStopwatch();
        } else if (e.getSource() == resetButton) {
            resetStopwatch();
        }
    }

    // Method to start the stopwatch
    private void startStopwatch() {
        if (!isRunning) {
            timer.start();
            isRunning = true;
            startButton.setText("Pause"); // Change button text to "Pause"
        } else {
            stopStopwatch(); //if it is running, stop it.
        }
    }

    // Method to stop the stopwatch
    private void stopStopwatch() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
            startButton.setText("Continue"); // Change button text to "Continue"
        }
    }

    // Method to reset the stopwatch
    private void resetStopwatch() {
        stopStopwatch(); // Stop the timer first
        seconds = 0;
        updateTimeLabel();
        startButton.setText("Start"); // Reset start button text
    }

    // Method to update the timeLabel
    private void updateTimeLabel() {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        String timeString = String.format("%02d:%02d", minutes, remainingSeconds);
        timeLabel.setText(timeString);
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety for GUI updates
        SwingUtilities.invokeLater(() -> new Stopwatch());
    }
}

