package gallerygate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame {
    public Profile() {
        setTitle("GalleryGate - Profile");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Navigation panel
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navPanel.setBackground(new Color(230, 230, 250));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JButton homeButton = createNavButton("Home");
        JButton uploadsButton = createNavButton("My uploads");
        
        navPanel.add(homeButton);
        navPanel.add(uploadsButton);
        
        // Profile info panel
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        profilePanel.setBackground(Color.WHITE);
        
        addProfileInfo(profilePanel, "Name:", "Mary Anne Smith");
        addProfileInfo(profilePanel, "Email:", "mannesmith22@gmail.com");
        addProfileInfo(profilePanel, "Phone:", "+254720536781");
        
        JPanel bioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bioPanel.setBackground(Color.WHITE);
        JLabel bioLabel = new JLabel("Bio:");
        bioLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bioLabel.setPreferredSize(new Dimension(80, 20));
        JLabel bioValue = new JLabel("Art Enthusiast!!");
        bioValue.setFont(new Font("Arial", Font.PLAIN, 14));
        bioPanel.add(bioLabel);
        bioPanel.add(bioValue);
        profilePanel.add(bioPanel);
        profilePanel.add(Box.createVerticalStrut(30));
        
        // Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setPreferredSize(new Dimension(100, 35));
        logoutButton.setBackground(new Color(70, 130, 180));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        logoutButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
        // Add components to main panel
        mainPanel.add(navPanel, BorderLayout.NORTH);
        mainPanel.add(profilePanel, BorderLayout.CENTER);
        mainPanel.add(logoutButton, BorderLayout.SOUTH);
        
        // Add action listeners
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home homePage = new Home();
                homePage.setVisible(true);
                dispose();
            }
        });
        
        uploadsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uploads uploadsPage = new Uploads();
                uploadsPage.setVisible(true);
                dispose();
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.Login loginPage = new login.Login();
                loginPage.setVisible(true);
                dispose();
            }
        });
        
        add(mainPanel);
    }
    
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(230, 230, 250));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        return button;
    }
    
    private void addProfileInfo(JPanel panel, String label, String value) {
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(Color.WHITE);
        
        JLabel infoLabel = new JLabel(label);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        infoLabel.setPreferredSize(new Dimension(80, 20));
        
        JLabel infoValue = new JLabel(value);
        infoValue.setFont(new Font("Arial", Font.PLAIN, 14));
        
        infoPanel.add(infoLabel);
        infoPanel.add(infoValue);
        
        panel.add(infoPanel);
        panel.add(Box.createVerticalStrut(15));
    }
}