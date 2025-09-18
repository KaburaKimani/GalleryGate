package login;

import gallerygate.GalleryGate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup extends JPanel {
    private GalleryGate parent;
    private final Color BABY_BLUE = new Color(173, 216, 230);
    private final Color BABY_PINK = new Color(255, 209, 220);
    private final Color DARK_BLUE = new Color(70, 130, 180);
    private final Color LIGHT_GRAY = new Color(240, 240, 240);

    public Signup(GalleryGate parent) {
        this.parent = parent;
        setLayout(new BorderLayout());
        setBackground(BABY_BLUE);

        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BABY_BLUE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        // Header with Login/Signup tabs
        JPanel headerPanel = new JPanel(new GridLayout(1, 2));
        headerPanel.setPreferredSize(new Dimension(400, 50));
        headerPanel.setBackground(BABY_PINK);
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JLabel loginTab = new JLabel("LOGIN", SwingConstants.CENTER);
        loginTab.setFont(new Font("SansSerif", Font.PLAIN, 16));
        loginTab.setOpaque(true);
        loginTab.setBackground(Color.WHITE);
        loginTab.setForeground(BABY_PINK);
        loginTab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginTab.setBorder(BorderFactory.createLineBorder(BABY_PINK, 1));
        loginTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.showPage("Login");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                loginTab.setBackground(BABY_PINK);
                loginTab.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                loginTab.setBackground(Color.WHITE);
                loginTab.setForeground(BABY_PINK);
            }
        });

        JLabel signupTab = new JLabel("SIGNUP", SwingConstants.CENTER);
        signupTab.setFont(new Font("SansSerif", Font.BOLD, 16));
        signupTab.setOpaque(true);
        signupTab.setBackground(BABY_PINK);
        signupTab.setForeground(Color.WHITE);
        signupTab.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        headerPanel.add(loginTab);
        headerPanel.add(signupTab);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BABY_PINK);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 3),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 10, 8, 10);

        // Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setForeground(DARK_BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        nameField.setPreferredSize(new Dimension(250, 40));
        nameField.setBackground(Color.WHITE);
        nameField.setBorder(BorderFactory.createLineBorder(BABY_BLUE, 2));
        gbc.gridy = 1;
        formPanel.add(nameField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        emailLabel.setForeground(DARK_BLUE);
        gbc.gridy = 2;
        formPanel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        emailField.setPreferredSize(new Dimension(250, 40));
        emailField.setBackground(Color.WHITE);
        emailField.setBorder(BorderFactory.createLineBorder(BABY_BLUE, 2));
        gbc.gridy = 3;
        formPanel.add(emailField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        passwordLabel.setForeground(DARK_BLUE);
        gbc.gridy = 4;
        formPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(250, 40));
        passwordField.setBackground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(BABY_BLUE, 2));
        gbc.gridy = 5;
        formPanel.add(passwordField, gbc);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        phoneLabel.setForeground(DARK_BLUE);
        gbc.gridy = 6;
        formPanel.add(phoneLabel, gbc);

        JTextField phoneField = new JTextField(20);
        phoneField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        phoneField.setPreferredSize(new Dimension(250, 40));
        phoneField.setBackground(Color.WHITE);
        phoneField.setBorder(BorderFactory.createLineBorder(BABY_BLUE, 2));
        gbc.gridy = 7;
        formPanel.add(phoneField, gbc);

        // Signup button - WIREFRAME STYLE
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JButton signupButton = new JButton("Signup");
        signupButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(BABY_PINK);
        signupButton.setPreferredSize(new Dimension(120, 40));
        signupButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2),
            BorderFactory.createEmptyBorder(5, 20, 5, 20)
        ));
        signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signupButton.addActionListener(e -> parent.showPage("Login"));
        
        // Hover effects
        signupButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signupButton.setBackground(BABY_PINK);
                signupButton.setForeground(Color.WHITE);
                signupButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2),
                    BorderFactory.createEmptyBorder(5, 20, 5, 20)
                ));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                signupButton.setBackground(Color.WHITE);
                signupButton.setForeground(BABY_PINK);
                signupButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 2),
                    BorderFactory.createEmptyBorder(5, 20, 5, 20)
                ));
            }
        });
        
        buttonPanel.add(signupButton);
        gbc.gridy = 8;
        formPanel.add(buttonPanel, gbc);

        // Login link
        JLabel loginLink = new JLabel("Already have an account? Login");
        loginLink.setFont(new Font("SansSerif", Font.BOLD, 12));
        loginLink.setForeground(DARK_BLUE);
        loginLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.showPage("Login");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                loginLink.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                loginLink.setForeground(DARK_BLUE);
            }
        });
        gbc.gridy = 9;
        formPanel.add(loginLink, gbc);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }
}