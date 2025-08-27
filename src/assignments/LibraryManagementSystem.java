package assignments;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LibraryManagementSystem extends JFrame {
    private Connection connection;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    // Database connection string for SQLite
    private static final String DB_URL = "jdbc:ucanaccess://C:\\Users\\cedrick joseph\\Documents\\Books.accdb";
    public LibraryManagementSystem() {
        initializeDatabase();
        initializeGUI();
    }

    private void initializeDatabase() {
        try {
            // Load SQLite JDBC driver (included in modern Java)
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void initializeGUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create menu bar
        createMenuBar();

        // Create main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add different panels
        mainPanel.add(createWelcomePanel(), "WELCOME");
        mainPanel.add(createNewBookPanel(), "NEW_BOOK");
        mainPanel.add(createBorrowPanel(), "BORROW");
        mainPanel.add(createReturnPanel(), "RETURN");

        add(mainPanel);

        // Show welcome panel initially
        cardLayout.show(mainPanel, "WELCOME");
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem newBookItem = new JMenuItem("New Book");
        newBookItem.setMnemonic('N');
        newBookItem.addActionListener(e -> cardLayout.show(mainPanel, "NEW_BOOK"));

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('E');
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newBookItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Transaction Menu
        JMenu transactionMenu = new JMenu("Transaction");
        transactionMenu.setMnemonic('T');

        JMenuItem borrowItem = new JMenuItem("Borrow");
        borrowItem.setMnemonic('B');
        borrowItem.addActionListener(e -> cardLayout.show(mainPanel, "BORROW"));

        JMenuItem returnItem = new JMenuItem("Return");
        returnItem.setMnemonic('R');
        returnItem.addActionListener(e -> cardLayout.show(mainPanel, "RETURN"));

        transactionMenu.add(borrowItem);
        transactionMenu.add(returnItem);

        menuBar.add(fileMenu);
        menuBar.add(transactionMenu);

        setJMenuBar(menuBar);
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Library Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(welcomeLabel, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createNewBookPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title
        JLabel titleLabel = new JLabel("New Book", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        panel.add(titleLabel, gbc);

        // Book Info section
        gbc.gridwidth = 1;
        gbc.gridy = 1;

        // Book ID
        gbc.gridx = 0;
        panel.add(new JLabel("Book ID:"), gbc);
        JTextField bookIdField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(bookIdField, gbc);
        JButton searchButton = new JButton("Search");
        gbc.gridx = 2;
        panel.add(searchButton, gbc);

        // Book Title
        gbc.gridy = 2; gbc.gridx = 0;
        panel.add(new JLabel("Book Title:"), gbc);
        JTextField bookTitleField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(bookTitleField, gbc);

        // Author
        gbc.gridy = 3; gbc.gridx = 0;
        panel.add(new JLabel("Author:"), gbc);
        JTextField authorField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(authorField, gbc);

        // Number of Copies
        gbc.gridy = 4; gbc.gridx = 0;
        panel.add(new JLabel("Number of Copies:"), gbc);
        JTextField copiesField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(copiesField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("ADD");
        JButton editButton = new JButton("EDIT");
        JButton deleteButton = new JButton("DELETE");
        JButton viewButton = new JButton("VIEW");
        JButton closeButton = new JButton("CLOSE");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(closeButton);

        gbc.gridy = 5; gbc.gridx = 0; gbc.gridwidth = 3;
        panel.add(buttonPanel, gbc);

        // Text area for displaying book info
        JTextArea infoArea = new JTextArea(10, 40);
        infoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoArea);
        gbc.gridy = 6;
        panel.add(scrollPane, gbc);

        // Button actions
        addButton.addActionListener(e -> addBook(bookIdField.getText(), bookTitleField.getText(), authorField.getText(),
                copiesField.getText(), infoArea));

        searchButton.addActionListener(e -> searchBook(bookIdField.getText(), bookTitleField,
                authorField, copiesField, infoArea));

        editButton.addActionListener(e -> editBook(bookIdField.getText(), bookTitleField.getText(),
                authorField.getText(), copiesField.getText(), infoArea));

        deleteButton.addActionListener(e -> deleteBook(bookIdField.getText(), infoArea));

        viewButton.addActionListener(e -> viewAllBooks(infoArea));

        closeButton.addActionListener(e -> cardLayout.show(mainPanel, "WELCOME"));

        return panel;
    }

    private JPanel createBorrowPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title
        JLabel titleLabel = new JLabel("Borrow", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        // Book ID
        gbc.gridy = 1; gbc.gridx = 0;
        panel.add(new JLabel("Book ID:"), gbc);
        JTextField bookIdField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(bookIdField, gbc);
        JButton searchButton = new JButton("Search");
        gbc.gridx = 2;
        panel.add(searchButton, gbc);

        // Borrower Name
        gbc.gridy = 2; gbc.gridx = 0;
        panel.add(new JLabel("Borrower Name:"), gbc);
        JTextField borrowerNameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(borrowerNameField, gbc);

        // Books Borrowed list
        gbc.gridy = 3; gbc.gridx = 0;
        panel.add(new JLabel("Books Borrowed:"), gbc);
        JList<String> booksList = new JList<>();
        JScrollPane booksScrollPane = new JScrollPane(booksList);
        booksScrollPane.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 1; gbc.gridwidth = 2;
        panel.add(booksScrollPane, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton borrowButton = new JButton("BORROW");
        JButton closeButton = new JButton("CLOSE");

        buttonPanel.add(borrowButton);
        buttonPanel.add(closeButton);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 3;
        panel.add(buttonPanel, gbc);

        // Button actions
        searchButton.addActionListener(e -> searchBookForBorrow(bookIdField.getText(), booksList));

        borrowButton.addActionListener(e -> borrowBook(bookIdField.getText(),
                borrowerNameField.getText(), booksList));

        closeButton.addActionListener(e -> cardLayout.show(mainPanel, "WELCOME"));

        return panel;
    }

    private JPanel createReturnPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title
        JLabel titleLabel = new JLabel("Return", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        // Book ID
        gbc.gridy = 1; gbc.gridx = 0;
        panel.add(new JLabel("Book ID:"), gbc);
        JTextField bookIdField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(bookIdField, gbc);
        JButton searchButton = new JButton("Search");
        gbc.gridx = 2;
        panel.add(searchButton, gbc);

        // Lists
        gbc.gridy = 2; gbc.gridx = 0;
        panel.add(new JLabel("List of Borrowers:"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("List of Books Borrowed:"), gbc);

        JList<String> borrowersList = new JList<>();
        JScrollPane borrowersScrollPane = new JScrollPane(borrowersList);
        borrowersScrollPane.setPreferredSize(new Dimension(150, 100));
        gbc.gridy = 3; gbc.gridx = 0;
        panel.add(borrowersScrollPane, gbc);

        JList<String> booksList = new JList<>();
        JScrollPane booksScrollPane = new JScrollPane(booksList);
        booksScrollPane.setPreferredSize(new Dimension(150, 100));
        gbc.gridx = 2;
        panel.add(booksScrollPane, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton returnButton = new JButton("RETURN");
        JButton closeButton = new JButton("CLOSE");

        buttonPanel.add(okButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(closeButton);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 3;
        panel.add(buttonPanel, gbc);

        // Button actions
        searchButton.addActionListener(e -> searchBookForReturn(bookIdField.getText(),
                borrowersList, booksList));

        okButton.addActionListener(e -> showBorrowerBooks(borrowersList.getSelectedValue(), booksList));

        returnButton.addActionListener(e -> returnBook(bookIdField.getText(),
                borrowersList.getSelectedValue(), booksList));

        closeButton.addActionListener(e -> cardLayout.show(mainPanel, "WELCOME"));

        return panel;
    }

    // Database operations
    private void addBook(String ID, String title, String author, String copies, JTextArea infoArea) {
        if (title.isEmpty() || author.isEmpty() || copies.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            int numCopies = Integer.parseInt(copies);
            int bookID = Integer.parseInt(ID);
            String sql = "INSERT INTO Books (bookID, bookTitle, author, noCopy) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, bookID);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setInt(4, numCopies);

            pstmt.executeUpdate();
            infoArea.setText("Book added successfully!");

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error adding book: " + e.getMessage());
        }
    }

    private void searchBook(String bookId, JTextField titleField, JTextField authorField,
                            JTextField copiesField, JTextArea infoArea) {
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Book ID");
            return;
        }

        try {
            String sql = "SELECT * FROM Books WHERE BookID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bookId));

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                titleField.setText(rs.getString("BookTitle"));
                authorField.setText(rs.getString("Author"));
                copiesField.setText(String.valueOf(rs.getInt("noCopy")));

                infoArea.setText("Book found:\n" +
                        "ID: " + rs.getInt("BookID") + "\n" +
                        "Title: " + rs.getString("BookTitle") + "\n" +
                        "Author: " + rs.getString("Author") + "\n" +
                        "Total Copies: " + rs.getInt("noCopy") );
            } else {
                infoArea.setText("Book not found!");
            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error searching book: " + e.getMessage());
        }
    }

    private void editBook(String bookId, String title, String author, String copies, JTextArea infoArea) {
        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || copies.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            String sql = "UPDATE Books SET BookTitle = ?, Author = ?, noCopy = ? WHERE BookID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, Integer.parseInt(copies));
            pstmt.setInt(4, Integer.parseInt(bookId));

            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                infoArea.setText("Book updated successfully!");
            } else {
                infoArea.setText("Book not found!");
            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error updating book: " + e.getMessage());
        }
    }

    private void deleteBook(String bookId, JTextArea infoArea) {
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Book ID");
            return;
        }

        try {
            String sql = "DELETE FROM Books WHERE BookID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bookId));

            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                infoArea.setText("Book deleted successfully!");
            } else {
                infoArea.setText("Book not found!");
            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error deleting book: " + e.getMessage());
        }
    }

    private void viewAllBooks(JTextArea infoArea) {
        try {
            String sql = "SELECT * FROM Books";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            StringBuilder sb = new StringBuilder("All Books:\n\n");
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("BookID"))
                        .append(", Title: ").append(rs.getString("BookTitle"))
                        .append(", Author: ").append(rs.getString("Author"))
                        .append(", Copies: ").append(rs.getInt("noCopy"))
                        .append("\n");
            }

            infoArea.setText(sb.toString());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error viewing books: " + e.getMessage());
        }
    }

    private void searchBookForBorrow(String bookId, JList<String> booksList) {
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Book ID");
            return;
        }

        try {
            String sql = "SELECT * FROM Books WHERE BookID = ? AND noCopy > 0";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bookId));

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                DefaultListModel<String> model = new DefaultListModel<>();
                model.addElement(rs.getString("BookTitle") + " (Available: " + rs.getInt("noCopy") + ")");
                booksList.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "Book not available for borrowing!");
            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error searching book: " + e.getMessage());
        }
    }

    private void borrowBook(String bookId, String borrowerName, JList<String> booksList) {
        if (bookId.isEmpty() || borrowerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            // Check if book is available
            String checkSql = "SELECT noCopy FROM Books WHERE BookID = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setInt(1, Integer.parseInt(bookId));
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt("noCopy") > 0) {
                // Insert or get borrower
                int borrowerId = getOrCreateBorrower(borrowerName);

                // Add to borrowed books
                String borrowSql = "INSERT INTO BorrowedBooks (BookID, BorrowerID) VALUES (?, ?)";
                PreparedStatement borrowStmt = connection.prepareStatement(borrowSql);
                borrowStmt.setInt(1, Integer.parseInt(bookId));
                borrowStmt.setInt(2, borrowerId);
                borrowStmt.executeUpdate();

                // Update available copies
                String updateSql = "UPDATE Books SET noCopy = noCopy - 1 WHERE BookID = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                updateStmt.setInt(1, Integer.parseInt(bookId));
                updateStmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Book borrowed successfully!");

                // Clear the list
                booksList.setModel(new DefaultListModel<>());

            } else {
                JOptionPane.showMessageDialog(this, "Book not available!");
            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error borrowing book: " + e.getMessage());
        }
    }

    private int getOrCreateBorrower(String borrowerName) throws SQLException {
        // Check if borrower exists
        String checkSql = "SELECT BorrowerID FROM Borrowers WHERE BorrowerName = ?";
        PreparedStatement checkStmt = connection.prepareStatement(checkSql);
        checkStmt.setString(1, borrowerName);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("BorrowerID");
        } else {
            // Create new borrower
            String insertSql = "INSERT INTO Borrowers (BorrowerName) VALUES (?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, borrowerName);
            insertStmt.executeUpdate();

            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }

        throw new SQLException("Failed to create borrower");
    }

    private void searchBookForReturn(String bookId, JList<String> borrowersList, JList<String> booksList) {
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Book ID");
            return;
        }

        try {
            String sql = """
                SELECT DISTINCT b.BorrowerName
                FROM BorrowedBooks bb
                JOIN Borrowers b ON bb.BorrowerID = b.BorrowerID
                WHERE bb.BookID = ?
                """;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bookId));

            ResultSet rs = pstmt.executeQuery();
            DefaultListModel<String> model = new DefaultListModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("BorrowerName"));
            }

            borrowersList.setModel(model);
            booksList.setModel(new DefaultListModel<>());

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error searching: " + e.getMessage());
        }
    }

    private void showBorrowerBooks(String borrowerName, JList<String> booksList) {
        if (borrowerName == null) {
            JOptionPane.showMessageDialog(this, "Please select a borrower");
            return;
        }

        try {
            String sql = """
                SELECT bk.BookTitle
                FROM BorrowedBooks bb
                JOIN Books bk ON bb.BookID = bk.BookID
                JOIN Borrowers b ON bb.BorrowerID = b.BorrowerID
                WHERE b.BorrowerName = ?
                """;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, borrowerName);

            ResultSet rs = pstmt.executeQuery();
            DefaultListModel<String> model = new DefaultListModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("BookTitle"));
            }

            booksList.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }
    }

    private void returnBook(String bookId, String borrowerName, JList<String> booksList) {
        if (bookId.isEmpty() || borrowerName == null) {
            JOptionPane.showMessageDialog(this, "Please enter Book ID and select borrower");
            return;
        }

        try {
            // Get borrower ID
            String getBorrowerSql = "SELECT BorrowerID FROM Borrowers WHERE BorrowerName = ?";
            PreparedStatement getBorrowerStmt = connection.prepareStatement(getBorrowerSql);
            getBorrowerStmt.setString(1, borrowerName);
            ResultSet rs = getBorrowerStmt.executeQuery();

            if (rs.next()) {
                int borrowerId = rs.getInt("BorrowerID");

                // Delete from borrowed books
                String deleteSql = "DELETE FROM BorrowedBooks WHERE BookID = ? AND BorrowerID = ?";
                PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
                deleteStmt.setInt(1, Integer.parseInt(bookId));
                deleteStmt.setInt(2, borrowerId);

                int deleted = deleteStmt.executeUpdate();
                if (deleted > 0) {
                    // Update available copies
                    String updateSql = "UPDATE Books SET noCopy = noCopy + 1 WHERE BookID = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                    updateStmt.setInt(1, Integer.parseInt(bookId));
                    updateStmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Book returned successfully!");

                    // Refresh the books list
                    showBorrowerBooks(borrowerName, booksList);
                } else {
                    JOptionPane.showMessageDialog(this, "No such borrowed book found!");
                }
            }

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error returning book: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new LibraryManagementSystem().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}