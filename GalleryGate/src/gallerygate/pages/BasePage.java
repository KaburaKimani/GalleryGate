package gallerygate.pages;

import javax.swing.*;
import java.awt.*;
import gallerygate.GalleryGate;

public class BasePage extends JFrame {
    protected final GalleryGate parent;
    
    public BasePage(GalleryGate parent, String title) {
        this.parent = parent;
        
        setTitle("GalleryGate - " + title);
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create the base layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);
    }
    
    protected JPanel createHeader(String title) {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(230, 230, 250));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(70, 70, 70));
        
        headerPanel.add(titleLabel);
        return headerPanel;
    }
    
    protected JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navPanel.setBackground(new Color(230, 230, 250));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return navPanel;
    }
    
    protected JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(230, 230, 250));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        return button;
    }

    protected void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    protected void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}