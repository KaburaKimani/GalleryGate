package gallerygate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // JDBC URL, username, password
    private static final String URL = "jdbc:mysql://localhost:3306/gallerygate";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // default root password is empty in XAMPP

    public static Connection connect() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connection successful!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found. Add Connector/J to your project.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }

    // Test connection
    public static void main(String[] args) {
        connect();
    }
}
