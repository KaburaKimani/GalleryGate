package gallerygate.pages;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import gallerygate.GalleryGate;

public class HomePage extends BasePage {
    private final Color BABY_BLUE = new Color(173, 216, 230);
    private final Color BABY_PINK = new Color(255, 209, 220);
    private final Color DARK_BLUE = new Color(70, 130, 180);
    
    private JLabel welcomeLabel;
    private JPanel mainContent;

    public HomePage(GalleryGate parent) {
        super(parent, "Home");
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(BABY_PINK);
        
        // Create main split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(250);
        splitPane.setDividerSize(2);
        splitPane.setEnabled(false);
        
        // Create sidebar
        JPanel sidebar = createSidebar();
        splitPane.setLeftComponent(sidebar);
        
        // Create main content area
        mainContent = createMainContent();
        splitPane.setRightComponent(mainContent);
        
        add(splitPane, BorderLayout.CENTER);
    }
    
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BorderLayout());
        sidebar.setBackground(BABY_BLUE);
        sidebar.setBorder(new CompoundBorder(
            new LineBorder(Color.WHITE, 2),
            new EmptyBorder(20, 15, 20, 15)
        ));
        
        // User section at top
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setBackground(BABY_BLUE);
        userPanel.setBorder(new EmptyBorder(0, 0, 30, 0));
        
        welcomeLabel = new JLabel("Welcome, " + parent.getCurrentUser() + "!");
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton userButton = new JButton("Profile");
        userButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        userButton.setBackground(BABY_PINK);
        userButton.setForeground(DARK_BLUE);
        userButton.setMaximumSize(new Dimension(150, 40));
        userButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        userButton.setBorder(new CompoundBorder(
            new LineBorder(Color.WHITE, 2),
            new EmptyBorder(5, 15, 5, 15)
        ));
        userButton.addActionListener(e -> parent.showPage("profile"));
        
        userPanel.add(welcomeLabel);
        userPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        userPanel.add(userButton);
        
        // Navigation menu
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBackground(BABY_BLUE);
        
        String[] menuItems = {"Home", "My uploads", "People", "Sculptures", "Vehicles", "Abstract", "Animals", "Logout"};
        
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            styleMenuButton(menuButton);
            
            menuButton.addActionListener(e -> {
                if (item.equals("Logout")) {
                    confirmLogout();
                } else {
                    parent.showPage(item.toLowerCase());
                }
            });
            
            navPanel.add(menuButton);
            navPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }
        
        // Add components to sidebar
        sidebar.add(userPanel, BorderLayout.NORTH);
        sidebar.add(new JScrollPane(navPanel), BorderLayout.CENTER);
        
        return sidebar;
    }
    
    private void styleMenuButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(BABY_BLUE);
        button.setMaximumSize(new Dimension(200, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(new CompoundBorder(
            new LineBorder(Color.WHITE, 1),
            new EmptyBorder(8, 20, 8, 20)
        ));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(BABY_PINK);
                button.setForeground(DARK_BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BABY_BLUE);
                button.setForeground(Color.WHITE);
            }
        });
    }
    
    private JPanel createMainContent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JLabel welcomeTitle = new JLabel("Welcome to GalleryGate", SwingConstants.CENTER);
        welcomeTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        welcomeTitle.setForeground(DARK_BLUE);
        welcomeTitle.setBorder(new EmptyBorder(50, 0, 30, 0));
        
        JPanel categoriesPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        categoriesPanel.setBackground(Color.WHITE);
        categoriesPanel.setBorder(new EmptyBorder(20, 50, 50, 50));
        
        String[] mainCategories = {"People", "Sculptures", "Vehicles", "Abstract", "Animals"};
        
        for (String category : mainCategories) {
            JButton categoryButton = createCategoryButton(category);
            categoriesPanel.add(categoryButton);
        }
        
        panel.add(welcomeTitle, BorderLayout.NORTH);
        panel.add(categoriesPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JButton createCategoryButton(String category) {
        JButton button = new JButton(category);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setBackground(BABY_BLUE);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(150, 100));
        button.setBorder(new CompoundBorder(
            new LineBorder(DARK_BLUE, 3),
            new EmptyBorder(20, 20, 20, 20)
        ));
        button.addActionListener(e -> parent.showPage(category.toLowerCase()));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(BABY_PINK);
                button.setForeground(DARK_BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(BABY_BLUE);
                button.setForeground(Color.WHITE);
            }
        });
        
        return button;
    }
    
    private void confirmLogout() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to logout?", "Logout",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            parent.logout();
        }
    }
import gallerygate.utils.NavigationUtil;

public class HomePage extends JFrame {
    private final GalleryGate parent;
    private final NavigationUtil navigationUtil;

    public HomePage(GalleryGate parent) {
        this.parent = parent;
        this.navigationUtil = parent.getNavigationUtil();
        
        setTitle("GalleryGate - Home");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
    }

    private void initComponents() {
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
        userLabel.setForeground(Color.BLUE);
        userLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(userLabel);
        
        // Categories panel
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
            button.addActionListener(e -> parent.showPage(category));
            categoriesPanel.add(button);
        }
        
        // Navigation panel
        JPanel navPanel = navigationUtil.createNavigationPanel();
        JButton homeButton = navigationUtil.createNavButton("Home");
        JButton uploadsButton = navigationUtil.createNavButton("My Uploads");
        JButton logoutButton = navigationUtil.createNavButton("Logout");
        
        homeButton.setEnabled(false); // Currently on home page
        uploadsButton.addActionListener(e -> parent.showPage("uploads"));
        logoutButton.addActionListener(e -> parent.showPage("login"));
        
        navPanel.add(homeButton);
        navPanel.add(uploadsButton);
        navPanel.add(logoutButton);
        
        // Add mouse listener to user label
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                parent.showPage("profile");
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                userLabel.setForeground(new Color(0, 0, 200));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                userLabel.setForeground(Color.BLUE);
            }
        });
        
        // Add components to main panel
        mainPanel.add(welcomePanel, BorderLayout.NORTH);
        mainPanel.add(categoriesPanel, BorderLayout.CENTER);
        mainPanel.add(navPanel, BorderLayout.WEST);
        
        add(mainPanel);
    }
}