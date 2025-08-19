package gallerygate;

import javax.swing.*;
import java.awt.*;

public class Product extends JFrame {
    public Product() {
        setTitle("GalleryGate - Product Details");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panel.setBackground(Color.WHITE);
        
        addProductInfo(panel, "Name of Art:", "Eclipsed Hearts");
        addProductInfo(panel, "Name of Artist:", "Miakoangelo");
        addProductInfo(panel, "Contact:", "07223338987/ miakoangelo@gmail.com");
        addProductInfo(panel, "Price:", "Ksh 20,000");
        
        add(panel);
    }
    
    private void addProductInfo(JPanel panel, String label, String value) {
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel infoLabel = new JLabel(label);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        infoLabel.setPreferredSize(new Dimension(120, 20));
        
        JLabel infoValue = new JLabel(value);
        infoValue.setFont(new Font("Arial", Font.PLAIN, 14));
        
        infoPanel.add(infoLabel);
        infoPanel.add(infoValue);
        
        panel.add(infoPanel);
        panel.add(Box.createVerticalStrut(15));
    }
}