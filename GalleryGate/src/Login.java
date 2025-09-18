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
        setLayout(new BorderLayout());

        // Main panel with proper spacing
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(240, 240, 240));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        // Header panel with Login and Signup options
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        headerPanel.setBackground(new Color(240, 240, 240));
        
        // Login header (active)
        JLabel loginHeader = new JLabel("Login");
        loginHeader.setFont(new Font("Arial", Font.BOLD, 22));
        loginHeader.setForeground(new Color(70, 70, 70));
        
        // Signup header (inactive)
        JLabel signupHeader = new JLabel("Signup");
        signupHeader.setFont(new Font("Arial", Font.PLAIN, 22));
        signupHeader.setForeground(new Color(150, 150, 150));
        signupHeader.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        headerPanel.add(loginHeader);
        headerPanel.add(signupHeader);
        
        // Form container with white background
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        
        // Login Form title
        JLabel formLabel = new JLabel("Login Form");
        formLabel.setFont(new Font("Arial", Font.BOLD, 20));
        formLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formLabel.setForeground(new Color(70, 70, 70));
        formLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        // Email field
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
        emailPanel.setBackground(Color.WHITE);
        emailPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setForeground(new Color(70, 70, 70));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
        
        JTextField emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        emailPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Password field
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setBackground(Color.WHITE);
        passwordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(70, 70, 70));
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
        
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(Short.MAX_VALUE, 35));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // Forgot password
        JLabel forgotPassword = new JLabel("Forgot password?");
        forgotPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        forgotPassword.setAlignmentX(Component.RIGHT_ALIGNMENT);
        forgotPassword.setForeground(new Color(0, 100, 200));
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPassword.setBorder(BorderFactory.createEmptyBorder(8, 0, 25, 0));

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBorder(BorderFactory.createEmptyBorder(12, 30, 12, 30));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Signup now text at bottom
        JLabel signupNow = new JLabel("Not a member? Signup now");
        signupNow.setFont(new Font("Arial", Font.PLAIN, 14));
        signupNow.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupNow.setForeground(new Color(0, 100, 200));
        signupNow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signupNow.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // Add components to form panel
        formPanel.add(formLabel);
        formPanel.add(emailPanel);
        formPanel.add(passwordPanel);
        formPanel.add(forgotPassword);
        formPanel.add(loginButton);
        formPanel.add(signupNow);

        // Add components to main panel
        mainPanel.add(headerPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(formPanel);

        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);

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

        signupHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Signup signupPage = new Signup();
                signupPage.setVisible(true);
                dispose();
            }
        });

        forgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(Login.this, 
                    "Password reset functionality would be implemented here");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michy
 */
public class DbConnection {
    
}
