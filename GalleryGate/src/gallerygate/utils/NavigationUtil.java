package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NavigationUtil {
    public static JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(230, 230, 250));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        return button;
    }
    
    public static void navigateToPage(JFrame currentFrame, String pageName) {
        try {
            // Create the appropriate page based on the name
            JFrame newPage = null;
            String basePackage = "gallerygate.";
            
            switch (pageName.toLowerCase()) {
                case "home":
                    newPage = (JFrame) Class.forName(basePackage + "Home").getDeclaredConstructor().newInstance();
                    break;
                case "uploads":
                    newPage = (JFrame) Class.forName(basePackage + "Uploads").getDeclaredConstructor().newInstance();
                    break;
                case "profile":
                    newPage = (JFrame) Class.forName(basePackage + "Profile").getDeclaredConstructor().newInstance();
                    break;
                case "login":
                    newPage = (JFrame) Class.forName("login.Login").getDeclaredConstructor().newInstance();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown page: " + pageName);
            }
            
            if (newPage != null) {
                newPage.setVisible(true);
                currentFrame.dispose();
            }
        } catch (Exception e) {
            System.err.println("Error navigating to " + pageName + ": " + e.getMessage());
            JOptionPane.showMessageDialog(currentFrame,
                "Error navigating to " + pageName,
                "Navigation Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void setupCommonNavigation(JPanel panel, JFrame currentFrame) {
        JButton homeButton = createNavButton("Home");
        JButton uploadsButton = createNavButton("My uploads");
        
        homeButton.addActionListener(e -> navigateToPage(currentFrame, "home"));
        uploadsButton.addActionListener(e -> navigateToPage(currentFrame, "uploads"));
        
        panel.add(homeButton);
        panel.add(uploadsButton);
    }
}