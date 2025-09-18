package gallerygate;

import javax.swing.*;
import java.awt.*;
import java.util.logging.*;
import gallerygate.pages.*;
import gallerygate.utils.NavigationUtil;
import login.Login;

public class GalleryGate {
    private static final Logger LOGGER = Logger.getLogger(GalleryGate.class.getName());
    private static GalleryGate instance;
    private JFrame currentPage;
    private final NavigationUtil navigationUtil;
    private String currentUser;

    private GalleryGate() {
        this.navigationUtil = new NavigationUtil();
        setupLogger();
    }

    private void setupLogger() {
        try {
            Handler fileHandler = new FileHandler("gallerygate.log", true);
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GalleryGate getInstance() {
        if (instance == null) {
            instance = new GalleryGate();
        }
        return instance;
    }

    public void setCurrentUser(String username) {
        this.currentUser = username;
        LOGGER.info("User logged in: " + username);
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        LOGGER.info("User logged out: " + currentUser);
        currentUser = null;
        showPage("login");
    }

    public void showPage(String pageName) {
        if (currentPage != null) {
            currentPage.dispose();
        }

        try {
            // If not on login page and no user is logged in, force login
            if (!"login".equalsIgnoreCase(pageName) && currentUser == null) {
                LOGGER.warning("Attempted to access " + pageName + " without login");
                pageName = "login";
            }

            switch (pageName.toLowerCase()) {
                case "home":
                    currentPage = new HomePage(this);
                    break;
                case "profile":
                    currentPage = new ProfilePage(this);
                    break;
                case "uploads":
                    currentPage = new UploadsPage(this);
                    break;
                case "people":
                    currentPage = new PeoplePage(this);
                    break;
                case "sculptures":
                    currentPage = new SculpturesPage(this);
                    break;
                case "vehicles":
                    currentPage = new VehiclesPage(this);
                    break;
                case "animals":
                    currentPage = new AnimalsPage(this);
                    break;
                case "abstract":
                    currentPage = new AbstractPage(this);
                    break;
                case "login":
                    currentPage = new Login();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown page: " + pageName);
            }
            
            if (currentPage != null) {
                currentPage.setVisible(true);
                LOGGER.info("Navigated to page: " + pageName);
            }
        } catch (Exception e) {
            LOGGER.severe("Error loading page " + pageName + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null,
                "Error loading page: " + e.getMessage(),
                "Navigation Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public NavigationUtil getNavigationUtil() {
        return navigationUtil;
    }

    public void showError(String message) {
        LOGGER.warning(message);
        JOptionPane.showMessageDialog(null,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Start the application
            SwingUtilities.invokeLater(() -> {
                try {
                    LOGGER.info("Starting GalleryGate application");
                    GalleryGate app = GalleryGate.getInstance();
                    app.showPage("login");
                } catch (Exception e) {
                    LOGGER.severe("Error starting application: " + e.getMessage());
                    JOptionPane.showMessageDialog(null,
                        "Error starting application: " + e.getMessage(),
                        "Startup Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            });
        } catch (Exception e) {
            LOGGER.severe("Error initializing application: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error initializing application: " + e.getMessage(),
                "Startup Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
        }
    }
}