package assignments;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class TryBD extends JFrame {

    public static JTextField productIdField;
    public static JTextField productNameField;
    public static JTextField quantityField;
    public static JTextField priceField;
    public static JTextArea textArea;
    static JButton newButton = new JButton("New");
    static JButton saveButton = new JButton("Save");
    static JButton showButton = new JButton("Show");
    static JButton exitButton = new JButton("Exit");

    public TryBD() {
        setTitle("Product Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

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

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 30, 10));

        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        mainPanel.add(buttonPanel, gbc);

        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Text Area"));

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(scrollPane, gbc);

        add(mainPanel, BorderLayout.CENTER);

        newButton.addActionListener(_ -> {
            clearFields();
            enableTextFields();
        });
        saveButton.addActionListener(_ -> {
            try {
                handleSaveButton();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        showButton.addActionListener(_ -> {
            try {
                showAllProducts();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        searchButton.addActionListener(_ -> {
            try {
                searchProductNumber(productIdField.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        exitButton.addActionListener(_ -> System.exit(0));

        productNameField.setEditable(false);
        quantityField.setEditable(false);
        priceField.setEditable(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void enableTextFields() {
        productNameField.setEnabled(true);
        productIdField.setEditable(true);
        productNameField.setEditable(true);
        quantityField.setEditable(true);
        priceField.setEditable(true);
    }

    public static void clearFields() {
        productIdField.setText("");
        productNameField.setText("");
        quantityField.setText("");
        priceField.setText("");
        textArea.setText("");
    }

    public static void handleSaveButton() throws SQLException, ClassNotFoundException {

        if (Objects.equals(productIdField.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Product ID must not be empty!");
            return;
        }
        if (Objects.equals(productNameField.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Product Name must not be empty!");
            return;
        }
        if (Objects.equals(quantityField.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Quantity must not be empty!");
            return;
        }
        if (Integer.parseInt(quantityField.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Quantity must not be negative!");
            return;
        }
        if (Objects.equals(priceField.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Price must not be empty!");
            return;
        }
        if (Double.parseDouble(priceField.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Price must not be negative!");
            return;
        }
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Downloads\\DatabaseAccess.accdb\\");

        String query = "SELECT prod_ID FROM Table_tbl WHERE prod_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, Integer.parseInt(productIdField.getText()));
        boolean isExisting = false;
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            isExisting = true;
        }

        if (isExisting) {
            String updateQuery = "UPDATE Table_tbl SET prod_Name = ?, qty = ?, price = ? WHERE prod_ID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, productNameField.getText());
            updateStmt.setInt(2, Integer.parseInt(quantityField.getText()));
            updateStmt.setDouble(3, Double.parseDouble(priceField.getText()));
            updateStmt.setInt(4, Integer.parseInt(productIdField.getText()));
            updateStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Information Updated Successfully!");
            productNameField.setEnabled(true);
            clearFields();
        }
        else {
            String insertQuery = "INSERT INTO Table_tbl (prod_ID, prod_Name, qty, price) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, Integer.parseInt(productIdField.getText()));
            insertStmt.setString(2, productNameField.getText());
            insertStmt.setInt(3, Integer.parseInt(quantityField.getText()));
            insertStmt.setDouble(4, Double.parseDouble(priceField.getText()));
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Information Saved Successfully!");
            clearFields();
        }
    }

    public static void showAllProducts() throws SQLException, ClassNotFoundException {
        clearFields();
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Downloads\\DatabaseAccess.accdb\\");
        String sql = "SELECT * FROM Table_tbl ORDER BY prod_id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        StringBuilder sb = new StringBuilder();
        sb.append("All Products:\n");
        sb.append("ID\tName\t\tQty\tPrice\n");
        sb.append("------------------------------------------------------------------------------------------------\n");
        while (rs.next()) {
            sb.append(rs.getInt("prod_id")).append("\t");
            sb.append(rs.getString("prod_name")).append("\t\t");
            sb.append(rs.getInt("qty")).append("\t");
            sb.append(rs.getDouble("price")).append("\n");
        }

        textArea.append(String.valueOf(sb));
    }

    public static void searchProductNumber(String text) throws SQLException, ClassNotFoundException {
        if (Objects.equals(text, ""))
            JOptionPane.showMessageDialog(null, "Product ID must not be empty!");
        else {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Downloads\\DatabaseAccess.accdb\\");
            String query = "SELECT * FROM Table_tbl WHERE prod_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(productIdField.getText()));
            ResultSet rs = stmt.executeQuery();
            boolean isFound = false;
            StringBuilder sb = new StringBuilder();
            sb.append("Product Information:\n");
            sb.append("ID\tName\t\tQty\tPrice\n");
            sb.append("------------------------------------------------------------------------------------------------\n");
            while (rs.next()) {
                isFound = true;
                productIdField.setText(rs.getString("prod_id"));
                productNameField.setText(rs.getString("prod_name"));
                quantityField.setText(rs.getString("qty"));
                priceField.setText(rs.getString("price"));
                sb.append(rs.getInt("prod_id")).append("\t");
                sb.append(rs.getString("prod_name")).append("\t\t");
                sb.append(rs.getInt("qty")).append("\t");
                sb.append(rs.getDouble("price")).append("\n");
            }
            if (isFound) {
                textArea.setText(String.valueOf(sb));
                alterProductInformation();
            } else
                JOptionPane.showMessageDialog(null, "Product ID not Found!");
        }
    }

    public static void alterProductInformation() throws ClassNotFoundException {
        String getAnswer = JOptionPane.showInputDialog("What do you want to do?\nEdit/Delete/Sell/Purchase");
        if (getAnswer == null) {
            return;
        }
        switch (getAnswer) {
            case "Edit" -> editProduct();
            case "Delete" -> deleteProduct();
            case "Sell" -> sellProduct();
            case "Purchase" -> purchaseProduct();
            default -> JOptionPane.showMessageDialog(null, "Invalid Input!");
        }
    }

    public static void editProduct() {
        enableTextFields();
        productNameField.setEnabled(true);
        quantityField.setEnabled(true);
        priceField.setEnabled(true);
        productNameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void deleteProduct() throws ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Downloads\\DatabaseAccess.accdb\\");
            String query = "DELETE FROM Table_tbl WHERE prod_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(productIdField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Deleted Successfully!");
            clearFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Failed to delete product. " + e.getMessage());
        }
    }

    public static void sellProduct() throws ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Downloads\\DatabaseAccess.accdb\\");
            String query = "UPDATE Table_tbl SET qty = qty - ? WHERE prod_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(quantityField, "Quantity to be Sold: ")));
            stmt.setInt(2, Integer.parseInt(productIdField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Sold Successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Failed to sell product. " + e.getMessage());
        }
    }

    public static void purchaseProduct() throws ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Downloads\\DatabaseAccess.accdb\\");
            String query = "UPDATE Table_tbl SET qty = qty + ? WHERE prod_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(JOptionPane.showInputDialog(quantityField, "Quantity to be Purchased: ")));
            stmt.setInt(2, Integer.parseInt(productIdField.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Purchased Successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Failed to purchase product. " + e.getMessage());
        }
    }

    public static void main (String[]args) throws ClassNotFoundException, SQLException {
        new TryBD();
        }
}
