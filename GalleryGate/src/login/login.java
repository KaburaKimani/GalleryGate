package login;

import gallerygate.Home;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public Login() {
        setTitle("GalleryGate - Login");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Title
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(70, 70, 70));
        
        // Signup option
        JLabel signupLabel = new JLabel("Signup");
        signupLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        signupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupLabel.setForeground(Color.BLUE);
        signupLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Login Form label
        JLabel formLabel = new JLabel("Login Form");
        formLabel.setFont(new Font("Arial", Font.BOLD, 20));
        formLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Email
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.setBackground(new Color(240, 240, 240));
        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(200, 30));
        emailPanel.add(emailLabel);
        emailPanel.add(Box.createHorizontalStrut(10));
        emailPanel.add(emailField);
        
        // Password
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.setBackground(new Color(240, 240, 240));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createHorizontalStrut(25));
        passwordPanel.add(passwordField);
        
        // Forgot password
        JLabel forgotPassword = new JLabel("Forgot password?");
        forgotPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        forgotPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        forgotPassword.setForeground(Color.BLUE);
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setPreferredSize(new Dimension(100, 35));
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
        // Signup now
        JLabel signupNow = new JLabel("Not a member? Signup now");
        signupNow.setFont(new Font("Arial", Font.PLAIN, 14));
        signupNow.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupNow.setForeground(Color.BLUE);
        signupNow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Add components to panel
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(signupLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(formLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailPanel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(forgotPassword);
        panel.add(Box.createVerticalStrut(20));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(signupNow);
        
        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home homePage = new Home();
                homePage.setVisible(true);
                dispose();
            }
        });
        
        signupNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Signup signupPage = new Signup();
                signupPage.setVisible(true);
                dispose();
            }
        });
        
        signupLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Signup signupPage = new Signup();
                signupPage.setVisible(true);
                dispose();
            }
        });
        
        add(panel);
    }
}