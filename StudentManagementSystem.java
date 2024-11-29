import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class StudentManagementSystem extends JFrame {

    // Table to display students
    private JTable table;
    private DefaultTableModel tableModel;

    // Text fields for student data
    private JTextField rollnoField, nameField, ageField, branchField, cgpaField;

    public StudentManagementSystem() {
        // Set up the main window
        setTitle("Student Management System");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for input fields and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3, 6, 6));

        // Input fields for student details

        panel.add(new JLabel("Rollno:"));
        rollnoField = new JTextField();
        panel.add(rollnoField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Branch:"));
        branchField = new JTextField();
        panel.add(branchField);

        panel.add(new JLabel("CGPA:"));
        cgpaField = new JTextField();
        panel.add(cgpaField);



        // Add button
        JButton addButton = new JButton("Add Student");
        panel.add(addButton);

        // Delete button
        JButton deleteButton = new JButton("Delete Student");
        panel.add(deleteButton);

        // Table to display students
        tableModel = new DefaultTableModel(new Object[]{"Rollno", "Name", "Age", "Branch", "Cgpa"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add components to the frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add button listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // Delete button listener
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
    }

    // Method to add student to the table
    private void addStudent() {
        String rollno = rollnoField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        String branch = branchField.getText();
        String cgpa = cgpaField.getText();
       

        if (rollno.isEmpty()||name.isEmpty() || age.isEmpty() || cgpa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            tableModel.addRow(new Object[]{rollno, name, age, branch, cgpa});
            clearFields();
        }
    }

    // Method to delete selected student from the table
    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear the input fields
    private void clearFields() {
        rollnoField.setText("");
        nameField.setText("");
        ageField.setText("");
        branchField.setText("");
        cgpaField.setText("");
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            StudentManagementSystem sms = new StudentManagementSystem();
            sms.setVisible(true);
        });
    }
}
