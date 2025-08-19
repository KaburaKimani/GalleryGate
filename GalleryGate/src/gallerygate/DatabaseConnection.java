package gallerygate.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gallerygate";
    private static final String USERNAME = "root"; // Change to your MySQL username
    private static final String PASSWORD = "yourpassword"; // Change to your MySQL password
    
    private static Connection connection;
    
    // Private constructor to prevent instantiation
    private DatabaseConnection() {}
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
            return connection;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, 
                "MySQL JDBC Driver not found!", "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Database connection failed!\nError: " + e.getMessage(), 
                "Connection Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Test method to check connection
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}