package login;

import gallerygate.Home;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame {
    public Signup() {
        setTitle("GalleryGate - Signup");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
        
        // Tabs
        JPanel tabPanel = new JPanel();
        tabPanel.setBackground(new Color(240, 240, 240));
        tabPanel.setLayout(new GridLayout(1, 2, 10, 0));
        
        JLabel loginTab = new JLabel("Login", SwingConstants.CENTER);
        loginTab.setFont(new Font("Arial", Font.PLAIN, 18));
        loginTab.setForeground(Color.GRAY);
        loginTab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel signupTab = new JLabel("Signup", SwingConstants.CENTER);
        signupTab.setFont(new Font("Arial", Font.BOLD, 18));
        signupTab.setForeground(new Color(70, 130, 180));
        
        tabPanel.add(loginTab);
        tabPanel.add(signupTab);
        
        // Form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(240, 240, 240));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        addFormField(formPanel, "Name");
        addFormField(formPanel, "Email");
        addFormField(formPanel, "Password");
        addFormField(formPanel, "Phone Number");
        
        // Signup button
        JButton signupButton = new JButton("Signup");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.setPreferredSize(new Dimension(100, 35));
        signupButton.setBackground(new Color(70, 130, 180));
        signupButton.setForeground(Color.WHITE);
        signupButton.setFont(new Font("Arial", Font.BOLD, 14));
        signupButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
        // Add components to panel
        panel.add(tabPanel);
        panel.add(formPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(signupButton);
        
        // Add action listeners
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home homePage = new Home();
                homePage.setVisible(true);
                dispose();
            }
        });
        
        loginTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login loginPage = new Login();
                loginPage.setVisible(true);
                dispose();
            }
        });
        
        add(panel);
    }
    
    private void addFormField(JPanel panel, String labelText) {
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.setBackground(new Color(240, 240, 240));
        fieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setPreferredSize(new Dimension(100, 30));
        
        JTextField textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(200, 30));
        
        fieldPanel.add(label);
        fieldPanel.add(textField);
        
        panel.add(fieldPanel);
        panel.add(Box.createVerticalStrut(15));
    }
}