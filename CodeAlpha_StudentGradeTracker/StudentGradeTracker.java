import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class StudentGradeTracker {
    // Lists to store data
    private final ArrayList<String> names = new ArrayList<>();
    private final ArrayList<Double> grades = new ArrayList<>();

    // GUI Components
    private JTextField nameField, gradeField;
    private JTextArea reportArea;
    private JLabel avgLabel, highLabel, lowLabel;

public StudentGradeTracker() {
        // Create the main window
        JFrame frame = new JFrame("Student Grade Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(new BorderLayout(10, 10));

        // --- Input Panel (Top) ---
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Grade:"));
        gradeField = new JTextField();
        inputPanel.add(gradeField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        // --- Report Area (Center) ---
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        frame.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // --- Stats Panel (Bottom) ---
        JPanel statsPanel = new JPanel(new GridLayout(3, 1));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        avgLabel = new JLabel("Average Score: 0.0");
        highLabel = new JLabel("Highest Score: 0.0");
        lowLabel = new JLabel("Lowest Score: 0.0");
        statsPanel.add(avgLabel);
        statsPanel.add(highLabel);
        statsPanel.add(lowLabel);
        frame.add(statsPanel, BorderLayout.SOUTH);

        // --- Button Logic ---
        addButton.addActionListener(e -> addStudentData());

        // Display the window
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addStudentData() {
        try {
            String name = nameField.getText().trim();
            String gradeText = gradeField.getText().trim();

            if (name.isEmpty() || gradeText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in both fields.");
                return;
            }

            double grade = Double.parseDouble(gradeText);

            // Add to lists
            names.add(name);
            grades.add(grade);

            // Clear inputs for next entry
            nameField.setText("");
            gradeField.setText("");

            // Refresh UI
            updateReportAndStats();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for the grade.");
        }
    }

    private void updateReportAndStats() {
        // Update text report
        StringBuilder report = new StringBuilder("--- Student List ---\n");
        double total = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        for (int i = 0; i < names.size(); i++) {
            double currentGrade = grades.get(i);
            report.append(names.get(i)).append(": ").append(currentGrade).append("\n");
            
            total += currentGrade;
            if (currentGrade > highest) highest = currentGrade;
            if (currentGrade < lowest) lowest = currentGrade;
        }

        double average = total / grades.size();

        // Update display fields
        reportArea.setText(report.toString());
        avgLabel.setText(String.format("Average Score: %.2f", average));
        highLabel.setText("Highest Score: " + highest);
        lowLabel.setText("Lowest Score: " + lowest);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(StudentGradeTracker::new);
    }
}