package gallerygate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.util.Properties;

public class DatabaseConnection {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
    private static final Properties props = new Properties();
    private static Connection connection = null;
    
    static {
        try {
            // Load database configuration from properties file
            String configPath = System.getProperty("user.dir") + "/config/database.properties";
            props.load(new FileInputStream(configPath));
        } catch (Exception e) {
            // If properties file not found, use default values
            props.setProperty("db.url", "jdbc:mysql://localhost:3306/gallerygate");
            props.setProperty("db.user", "root");
            props.setProperty("db.password", "");
            LOGGER.warning("Using default database configuration. Consider creating a config/database.properties file.");
        }
    }

    public static Connection connect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Get connection properties
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            
            // Establish connection
            connection = DriverManager.getConnection(url, user, password);
            LOGGER.info("Database connection established successfully");
            return connection;
        } catch (ClassNotFoundException e) {
            LOGGER.severe("MySQL Driver not found. Add Connector/J to your project.");
            throw new SQLException("Database driver not found", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database connection failed", e);
            throw e;
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                LOGGER.info("Database connection closed successfully");
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Error closing database connection", e);
            } finally {
                connection = null;
            }
        }
    }

    // Test connection
    public static void main(String[] args) {
        try {
            connect();
            // Test the connection here
            closeConnection();
        } catch (SQLException e) {
            LOGGER.severe("Connection test failed: " + e.getMessage());
        }
    }
}
