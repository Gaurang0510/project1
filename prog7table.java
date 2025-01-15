import java.awt.*;
import javax.swing.*;

public class prog7table extends JFrame {
    public prog7table() {
        // Frame settings
        setTitle("Student Information Table");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Data for the JTable
        String[][] studentData = {
            {"1", "Amit", "Computer Science", "1st Year"},
            {"2", "Ravi", "Information Technology", "2nd Year"},
            {"3", "Sneha", "Mechanical Engineering", "3rd Year"},
            {"4", "Priya", "Chemical Engineering", "2nd Year"},
            {"5", "Rahul", "Civil Engineering", "1st Year"},
            {"6", "Kavya", "Electrical Engineering", "3rd Year"}
        };

        // Column names
        String[] columnNames = {"Roll Number", "Name", "Branch", "Year"};

        // Creating the JTable
        JTable studentTable = new JTable(studentData, columnNames);

        // Adding table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        {
            prog7table tableExample = new prog7table();
            tableExample.setVisible(true);
        };
    }
}
