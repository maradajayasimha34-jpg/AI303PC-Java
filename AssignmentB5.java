
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AssignmentB5 extends JFrame {

    JTextField roll = new JTextField(12);
    JTextField name = new JTextField(18);

    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup gender = new ButtonGroup();

    JCheckBox java = new JCheckBox("Java");
    JCheckBox python = new JCheckBox("Python");
    JCheckBox dbms = new JCheckBox("DBMS");

    JComboBox<String> branch = new JComboBox<>(
        new String[]{"CSE", "AI & ML", "ECE", "EEE"}
    );

    JList<String> city = new JList<>(
        new String[]{"Hyderabad", "Vijayawada", "Chennai"}
    );

    JTextArea address = new JTextArea(3, 20);
    JTextArea output = new JTextArea(8, 35);

    AssignmentB5() {
        super("Student Registration Form");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 5, 3, 5);
        c.anchor = GridBagConstraints.WEST;

        int r = 0;

        addRow(form, c, r++, "Roll No", roll);
        addRow(form, c, r++, "Name", name);

        gender.add(male);
        gender.add(female);

        JPanel gp = new JPanel();
        gp.add(male);
        gp.add(female);
        addRow(form, c, r++, "Gender", gp);

        JPanel subs = new JPanel();
        subs.add(java);
        subs.add(python);
        subs.add(dbms);
        addRow(form, c, r++, "Subjects", subs);

        addRow(form, c, r++, "Branch", branch);

        city.setVisibleRowCount(3);
        addRow(form, c, r++, "City", new JScrollPane(city));

        addRow(form, c, r++, "Address",
            new JScrollPane(address));

        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        addRow(form, c, r++, "Logo", logo);

        JButton submit = new JButton("Submit");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");

        JPanel buttons = new JPanel();
        buttons.add(submit);
        buttons.add(reset);
        buttons.add(exit);

        addRow(form, c, r, "", buttons);

        output.setEditable(false);

        JTable table = new JTable(
            new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Roll", "Name", "Gender", "Subjects",
                    "Branch", "City", "Address"
                }
            )
        );

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Registration", new JScrollPane(form));
        tabs.addTab("Submitted Records", new JScrollPane(table));

        add(tabs, BorderLayout.CENTER);
        add(new JScrollPane(output), BorderLayout.SOUTH);

        submit.addActionListener(e -> submitForm(table));
        reset.addActionListener(e -> resetForm());
        exit.addActionListener(e -> System.exit(0));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addRow(JPanel p, GridBagConstraints c,
                int row, String label, Component comp) {
        c.gridy = row;
        c.gridx = 0;
        p.add(new JLabel(label), c);

        c.gridx = 1;
        p.add(comp, c);
    }

    void submitForm(JTable table) {

        String rollNo = roll.getText().trim();
        String studentName = name.getText().trim();
        String studentAddress = address.getText().trim();

        if (rollNo.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter Roll Number");
            return;
        }

        if (!rollNo.matches("\\d+")) {
            JOptionPane.showMessageDialog(
                this, "Roll number must be numeric");
            return;
        }

        if (studentName.isEmpty()
                || studentAddress.isEmpty()
                || city.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(
                this, "Complete all fields");
            return;
        }

        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(
                this, "Select gender");
            return;
        }

        StringBuilder subjects = new StringBuilder();

        if (java.isSelected()) subjects.append("Java ");
        if (python.isSelected()) subjects.append("Python ");
        if (dbms.isSelected()) subjects.append("DBMS ");

        String s = subjects.toString().trim();

        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Select at least one subject");
            return;
        }

        String g = male.isSelected() ? "Male" : "Female";

        String[] data = {
            rollNo,
            studentName,
            g,
            s,
            (String) branch.getSelectedItem(),
            city.getSelectedValue(),
            studentAddress
        };

        output.setText(
            "ROLL NO: " + data[0]
            + "\nNAME: " + data[1]
            + "\nGENDER: " + data[2]
            + "\nSUBJECTS: " + data[3]
            + "\nBRANCH: " + data[4]
            + "\nCITY: " + data[5]
            + "\nADDRESS: " + data[6]
        );

        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            table.getModel();

        model.addRow(data);

        JOptionPane.showMessageDialog(
            this, "Registration submitted successfully");
    }

    void resetForm() {
        roll.setText("");
        name.setText("");

        gender.clearSelection();

        java.setSelected(false);
        python.setSelected(false);
        dbms.setSelected(false);

        branch.setSelectedIndex(0);
        city.clearSelection();
        address.setText("");
        output.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AssignmentB5::new);
    }
}

//Sample output: 
Empty submit -> Please enter Roll Number; valid submit -> ROLL NO: 101, NAME: Asha, GENDER: Female, SUBJECTS:
Java DBMS, BRANCH: AI & ML