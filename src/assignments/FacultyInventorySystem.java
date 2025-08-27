package assignments;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyInventorySystem extends JFrame {
    static String empStatus;
    static String department;
    static List<String> subjects = new ArrayList<>();
    static JRadioButton permButton = new JRadioButton("Permanent");
    static JRadioButton tempButton = new JRadioButton("Temporary");
    static JRadioButton partButton = new JRadioButton("Part-Time");
    static JComboBox<String> departmentComboBox = new JComboBox<>(new String[]{"Computer Science", "Information Science", "Information Technology"});
    static JCheckBox[] checkboxes;
    static JTextField facultyNumber = new JTextField(25);
    static JTextField facultyName = new JTextField(25);
    static JTextArea facultyArea = new JTextArea(10, 0);
    static String columnHeaders = "%-40s %-30s %-30s %-60s %s\n".formatted("Employee Number", "Employee Name", "Status", "Department", "Subjects");

    public FacultyInventorySystem() {
        setTitle("Faculty Inventory Form");
        setSize(700, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridLayout(4, 1));
        mainPanel.add(requirementNumber1());
        mainPanel.add(requirementNumber2());
        mainPanel.add(requirementNumber3());
        mainPanel.add(requirementNumber4());

        add(mainPanel, BorderLayout.CENTER);

        JPanel createFacultyArea = requirementNumber5();
        createFacultyArea.setPreferredSize(new Dimension(700, 280));
        add(createFacultyArea, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JPanel requirementNumber1() {
        Dimension labelSize = new Dimension(125, 25);

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        panel1.setBorder(new EmptyBorder(10, 0, 0, 0));
        JPanel firstRow = new JPanel();
        JLabel facultyLabel1 = new JLabel("Faculty Number:");
        facultyLabel1.setPreferredSize(labelSize);
        firstRow.add(facultyLabel1);
        firstRow.add(facultyNumber);

        JPanel secondRow = new JPanel();
        JLabel facultyLabel2 = new JLabel("Faculty Name:");
        facultyLabel2.setPreferredSize(labelSize);
        secondRow.add(facultyLabel2);
        secondRow.add(facultyName);

        panel1.add(firstRow);
        panel1.add(secondRow);

        return panel1;
    }

    public JPanel requirementNumber2() {
        JPanel panel2 = new JPanel(new GridLayout(3, 4, 10, 20));
        EmptyBorder border = new EmptyBorder(0, 15, 0, 0);
        JLabel facultyLabel3 = new JLabel("Employment Status:");
        facultyLabel3.setBorder(border);

        permButton.addItemListener(new RadioButtonListener());
        tempButton.addItemListener(new RadioButtonListener());
        partButton.addItemListener(new RadioButtonListener());

        ButtonGroup empStatusButtons = new ButtonGroup();
        empStatusButtons.add(permButton);
        empStatusButtons.add(tempButton);
        empStatusButtons.add(partButton);

        JLabel facultyLabel4 = new JLabel("Department:");
        facultyLabel4.setBorder(border);
        departmentComboBox.setSize(100, 25);
        departmentComboBox.addItemListener(new ComboBoxListener());

        JLabel facultyLabel5 = new JLabel("Subjects Taught:");
        facultyLabel5.setBorder(border);

        panel2.add(facultyLabel3);
        panel2.add(permButton);
        panel2.add(tempButton);
        panel2.add(partButton);

        panel2.add(facultyLabel4);
        panel2.add(departmentComboBox);
        panel2.add(new JLabel());
        panel2.add(new JLabel());

        panel2.add(facultyLabel5);
        panel2.add(new JLabel());
        panel2.add(new JLabel());
        panel2.add(new JLabel());

        return panel2;
    }

    public JPanel requirementNumber3() {
        JPanel panel3 = new JPanel(new GridLayout(3, 3, 0, -10));
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
        checkboxes = new JCheckBox[]{
                new JCheckBox("Programming"),
                new JCheckBox("Networking"),
                new JCheckBox("Capstone Project"),
                new JCheckBox("Database"),
                new JCheckBox("Research"),
                new JCheckBox("Elective"),
                new JCheckBox("Discrete Structure"),
                new JCheckBox("Thesis"),
                new JCheckBox("Modelling and Simulation")
        };

        for (JCheckBox checkbox : checkboxes) {
            checkbox.addItemListener(new CheckBoxListener());
            panel3.add(checkbox);
        }
        containerPanel.add(panel3);

        return containerPanel;
    }

    public JPanel requirementNumber4() {
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));

        Dimension buttonSize = new Dimension(100, 25);

        JButton save = new JButton("SAVE");
        JButton show = new JButton("SHOW");
        JButton clear = new JButton("CLEAR");
        JButton exit = new JButton("EXIT");

        save.setPreferredSize(buttonSize);
        show.setPreferredSize(buttonSize);
        clear.setPreferredSize(buttonSize);
        exit.setPreferredSize(buttonSize);

        save.setMnemonic(KeyEvent.VK_S);
        clear.setMnemonic(KeyEvent.VK_C);
        show.setMnemonic(KeyEvent.VK_O);
        exit.setMnemonic(KeyEvent.VK_E);

        save.addActionListener(new saveButtonListener());
        clear.addActionListener(new clearButtonListener());
        show.addActionListener(new showButtonListener());
        exit.addActionListener(_ -> System.exit(0));

        panel4.add(save);
        panel4.add(clear);
        panel4.add(Box.createRigidArea(new Dimension(700, 0)));
        panel4.add(show);
        panel4.add(exit);

        return panel4;
    }

    public JPanel requirementNumber5() {
        JPanel panel5 = new JPanel(new BorderLayout());
        facultyArea.setEditable(false);
        facultyArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        facultyArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(facultyArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        facultyArea.setText(columnHeaders);
        panel5.add(scrollPane, BorderLayout.CENTER);

        return panel5;
    }

    public static class RadioButtonListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JRadioButton source = (JRadioButton) e.getSource();
            if (source.isSelected()) {
                empStatus = source.getText();
            }
        }
    }

    public static class ComboBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox<?> source = (JComboBox<?>) e.getSource();
            department = (String) source.getSelectedItem();
            for (JCheckBox checkbox : checkboxes) {
                switch (department) {
                    case "Computer Science":
                        checkbox.setEnabled(checkbox.getText().equals("Programming") || checkbox.getText().equals("Database")
                                || checkbox.getText().equals("Elective") || checkbox.getText().equals("Thesis"));
                        break;
                    case "Information Science":
                        checkbox.setEnabled(checkbox.getText().equals("Programming") || checkbox.getText().equals("Database")
                                || checkbox.getText().equals("Discrete Structure") || checkbox.getText().equals("Modelling and Simulation")
                                || checkbox.getText().equals("Elective") || checkbox.getText().equals("Capstone Project"));
                        break;
                    case "Information Technology":
                        checkbox.setEnabled(checkbox.getText().equals("Programming") || checkbox.getText().equals("Database")
                                || checkbox.getText().equals("Discrete Structure") || checkbox.getText().equals("Networking")
                                || checkbox.getText().equals("Elective") || checkbox.getText().equals("Research"));
                        break;
                    case null:
                        break;
                    default:
                        checkbox.setEnabled(true);
                        break;
                }
            }
        }
    }

    public static class CheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox source = (JCheckBox) e.getItemSelectable();
            String subject = source.getText();

            if (source.isSelected()) {
                if (!subjects.contains(subject)) subjects.add(subject);
            } else subjects.remove(subject);
        }
    }

    public static class saveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String formatSubjects = String.join(", ", subjects);
            String formatInfo = "%s;%s;%s;%s;%s\n".formatted(facultyNumber.getText(), facultyName.getText(), empStatus, department, formatSubjects);
            try (BufferedWriter appendInformation = new BufferedWriter(new FileWriter("Subjects.txt", true))) {
                appendInformation.write(formatInfo);
            } catch (IOException ex) {
                System.out.println("Failed to save information. Please try again.");
            }

        }
    }

    public static class showButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File file = new File("Subjects.txt");
            try (BufferedReader readInformation = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = readInformation.readLine()) != null) {
                    String[] parts = line.split(";");
                    String showInfo = "%-40s %-30s %-25s %-40s %s\n".formatted(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    facultyArea.append(showInfo);
                }
            } catch (IOException ex) {
                System.out.println("Failed to read information. Please try again.");
            }
        }
    }

    public static class clearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            facultyArea.setText(columnHeaders);
            facultyNumber.setText("");
            facultyName.setText("");
            departmentComboBox.setSelectedIndex(2);
            permButton.setSelected(true);
            for (JCheckBox checkbox : checkboxes) {
                checkbox.setSelected(false);
            }
        }
    }

    public static void main(String[] args) {
        new FacultyInventorySystem();
    }
}