package assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class activity extends JFrame {

    private JTextField productIdField;
    private JTextField productNameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextArea textArea;
    private Connection connection;

    public activity() {
        initializeDatabase();
        setupGUI();
    }

    private void initializeDatabase() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // Use these exact connection parameters
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/JavaActivityDb", // Add your database name
                    "root",
                    "");

            String createTable = "CREATE TABLE IF NOT EXISTS products (" +
                    "prod_id INTEGER PRIMARY KEY, " +
                    "prod_name VARCHAR(100) NOT NULL, " + // Changed TEXT to VARCHAR
                    "qty INTEGER NOT NULL, " +
                    "price DECIMAL(10,2) NOT NULL)";

            try (Statement stmt = connection.createStatement()) {
                stmt.execute(createTable);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Connection failed. Check:\n" +
                            "1. Is MariaDB running?\n" +
                            "2. Is password correct?\n" +
                            "3. Database exists?\n\n" +
                            "Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private void setupGUI() {
        setTitle("Product Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("ACTIVITY");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Product ID:"), gbc);
        gbc.gridx = 1;
        productIdField = new JTextField(15);
        mainPanel.add(productIdField, gbc);

        gbc.gridx = 2;
        JButton searchButton = new JButton("Search");
        mainPanel.add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Product Name:"), gbc);
        gbc.gridx = 1;
        productNameField = new JTextField(15);
        mainPanel.add(productNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Available Qty:"), gbc);
        gbc.gridx = 1;
        quantityField = new JTextField(15);
        mainPanel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        priceField = new JTextField(15);
        mainPanel.add(priceField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton newButton = new JButton("New");
        JButton saveButton = new JButton("Save");
        JButton showButton = new JButton("Show");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        mainPanel.add(buttonPanel, gbc);

        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Text Area"));

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(scrollPane, gbc);

        add(mainPanel, BorderLayout.CENTER);

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchProduct();
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllProducts();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void clearFields() {
        productIdField.setText("");
        productNameField.setText("");
        quantityField.setText("");
        priceField.setText("");
        textArea.setText("");
    }

    private void saveProduct() {
        try {
            if (productIdField.getText().isEmpty() || productNameField.getText().isEmpty() ||
                    quantityField.getText().isEmpty() || priceField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
                return;
            }

            int prodId = Integer.parseInt(productIdField.getText());
            String prodName = productNameField.getText();
            int qty = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            String checkSql = "SELECT COUNT(*) FROM products WHERE prod_id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setInt(1, prodId);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                String updateSql = "UPDATE products SET prod_name = ?, qty = ?, price = ? WHERE prod_id = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                updateStmt.setString(1, prodName);
                updateStmt.setInt(2, qty);
                updateStmt.setDouble(3, price);
                updateStmt.setInt(4, prodId);
                updateStmt.executeUpdate();
                textArea.setText("Product updated successfully!");
            } else {
                String insertSql = "INSERT INTO products (prod_id, prod_name, qty, price) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertSql);
                insertStmt.setInt(1, prodId);
                insertStmt.setString(2, prodName);
                insertStmt.setInt(3, qty);
                insertStmt.setDouble(4, price);
                insertStmt.executeUpdate();
                textArea.setText("Product saved successfully!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID, Quantity, and Price");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    private void searchProduct() {
        try {
            if (productIdField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Product ID to search");
                return;
            }

            int prodId = Integer.parseInt(productIdField.getText());

            String sql = "SELECT * FROM products WHERE prod_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, prodId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                productNameField.setText(rs.getString("prod_name"));
                quantityField.setText(String.valueOf(rs.getInt("qty")));
                priceField.setText(String.valueOf(rs.getDouble("price")));
                textArea.setText("Product found and loaded!");
            } else {
                textArea.setText("Product not found!");
                productNameField.setText("");
                quantityField.setText("");
                priceField.setText("");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Product ID");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    private void showAllProducts() {
        try {
            String sql = "SELECT * FROM products ORDER BY prod_id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            StringBuilder sb = new StringBuilder();
            sb.append("All Products:\n");
            sb.append("ID\tName\t\tQty\tPrice\n");
            sb.append("----------------------------------------\n");

            while (rs.next()) {
                sb.append(rs.getInt("prod_id")).append("\t");
                sb.append(rs.getString("prod_name")).append("\t\t");
                sb.append(rs.getInt("qty")).append("\t");
                sb.append(rs.getDouble("price")).append("\n");
            }

            if (sb.length() <= 60) {
                sb.append("No products found in database.");
            }

            textArea.setText(sb.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new activity();
    }
}