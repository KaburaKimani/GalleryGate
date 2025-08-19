package gallerygate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uploads extends JFrame {
    public Uploads() {
        setTitle("GalleryGate - My Uploads");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Title panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(new Color(230, 230, 250));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel paintbrushLabel = new JLabel("# Paintbrush");
        paintbrushLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel streetlightsLabel = new JLabel("Streetlights");
        streetlightsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        streetlightsLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        
        titlePanel.add(paintbrushLabel);
        titlePanel.add(streetlightsLabel);
        
        // Navigation panel
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navPanel.setBackground(new Color(240, 240, 240));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JButton homeButton = createNavButton("Home");
        JButton uploadsButton = createNavButton("My uploads");
        uploadsButton.setBackground(new Color(200, 200, 200));
        
        navPanel.add(homeButton);
        navPanel.add(uploadsButton);
        
        // Uploads panel
        JPanel uploadsPanel = new JPanel();
        uploadsPanel.setLayout(new BoxLayout(uploadsPanel, BoxLayout.Y_AXIS));
        uploadsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        uploadsPanel.setBackground(Color.WHITE);
        
        String[] uploads = {"Solitude", "Love", "The brain", "Slavery"};
        
        for (String upload : uploads) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.setBackground(Color.WHITE);
            itemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            
            JLabel itemLabel = new JLabel(upload);
            itemLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            
            itemPanel.add(itemLabel);
            uploadsPanel.add(itemPanel);
            uploadsPanel.add(Box.createVerticalStrut(10));
        }
        
        // Add components to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(navPanel, BorderLayout.CENTER);
        mainPanel.add(uploadsPanel, BorderLayout.SOUTH);
        
        // Add action listeners
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home homePage = new Home();
                homePage.setVisible(true);
                dispose();
            }
        });
        
        add(mainPanel);
    }
    
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(240, 240, 240));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        return button;
    }
}