package gallerygate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {
    public Home() {
        setTitle("GalleryGate - Home");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Welcome panel (north)
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        welcomePanel.setBackground(new Color(230, 230, 250));
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(70, 70, 70));
        
        JLabel userLabel = new JLabel("User");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        userLabel.setForeground(Color.BLUE); // Make it look clickable
        userLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
        
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(userLabel);
        
        // Sidebar panel (west)
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(220, 220, 220));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 30));
        sidebarPanel.setPreferredSize(new Dimension(200, 0));
        
        String[] sidebarItems = { "Home", "My uploads", "Logout"};
        
        for (String item : sidebarItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.setBackground(new Color(220, 220, 220));
            button.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
            button.setFocusPainted(false);
            
            if (item.equals("Home")) {
                button.setBackground(new Color(200, 200, 200));
            }
            
            sidebarPanel.add(button);
            sidebarPanel.add(Box.createVerticalStrut(5));
        }
        
        // Categories panel (center)
        JPanel categoriesPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        categoriesPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        categoriesPanel.setBackground(Color.WHITE);
        
        String[] categories = {"Abstracts", "Animals", "Landscapes", "Portraits"};
        
        for (String category : categories) {
            JButton button = new JButton(category);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBackground(Color.WHITE);
            button.setForeground(new Color(70, 70, 70));
            button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
            button.setPreferredSize(new Dimension(150, 150));
            categoriesPanel.add(button);
        }
        
        // Add panels to main panel
        mainPanel.add(welcomePanel, BorderLayout.NORTH);
        mainPanel.add(sidebarPanel, BorderLayout.WEST);
        mainPanel.add(categoriesPanel, BorderLayout.CENTER);
        
        // Add action listeners
        JButton logoutButton = (JButton) sidebarPanel.getComponent(sidebarItems.length * 2 - 2);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.Login loginPage = new login.Login();
                loginPage.setVisible(true);
                dispose();
            }
        });
        
        JButton uploadsButton = (JButton) sidebarPanel.getComponent(2); // My uploads button (index changed)
        uploadsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uploads uploadsPage = new Uploads();
                uploadsPage.setVisible(true);
                dispose();
            }
        });
        
        // Add mouse listener to the User label
        userLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Profile profilePage = new Profile();
                profilePage.setVisible(true);
                dispose();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                userLabel.setForeground(new Color(0, 0, 200)); // Darker blue on hover
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                userLabel.setForeground(Color.BLUE); // Original blue when not hovering
            }
        });
        
        // Add action listener for Home button in sidebar
        JButton homeButton = (JButton) sidebarPanel.getComponent(0);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Already on home page, no action needed
            }
        });
        
        add(mainPanel);
    }
}