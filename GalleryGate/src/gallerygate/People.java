package gallerygate;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class People extends JPanel {
    private GalleryGate parent;
    private final Color BABY_BLUE = new Color(173, 216, 230);
    private final Color BABY_PINK = new Color(255, 209, 220);
    private final Color DARK_BLUE = new Color(70, 130, 180);

    public People(GalleryGate parent) {
        this.parent = parent;
        setLayout(new BorderLayout());
        setBackground(BABY_PINK);
        createPeoplePage();
    }

    private void createPeoplePage() {
        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(BABY_BLUE);
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel title = new JLabel("People Gallery", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        
        JButton backButton = new JButton("← Back");
        backButton.addActionListener(e -> parent.showPage("Home"));
        styleButton(backButton);
        
        headerPanel.add(backButton, BorderLayout.WEST);
        headerPanel.add(title, BorderLayout.CENTER);
        
        // Content
        JPanel contentPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        contentPanel.setBackground(BABY_PINK);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        String[] peopleArts = {"Portrait Art", "Group Photos", "Character Study", 
                              "Expression Art", "Cultural Portraits", "Family Moments"};
        
        for (String art : peopleArts) {
            contentPanel.add(createArtPanel(art, "People"));
        }
        
        // Upload section
        JPanel uploadPanel = new JPanel();
        uploadPanel.setBackground(BABY_PINK);
        uploadPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        JButton uploadButton = new JButton("Upload People Art");
        uploadButton.addActionListener(e -> uploadArt("People"));
        styleUploadButton(uploadButton);
        uploadPanel.add(uploadButton);
        
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        add(uploadPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createArtPanel(String title, String category) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new CompoundBorder(
            new LineBorder(BABY_BLUE, 2),
            new EmptyBorder(10, 10, 10, 10)
        ));
        
        JLabel imageLabel = new JLabel("👥", SwingConstants.CENTER);
        imageLabel.setFont(new Font("SansSerif", Font.PLAIN, 48));
        
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLabel.setForeground(DARK_BLUE);
        
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(titleLabel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void uploadArt(String category) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Upload " + category + " Art");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Uploaded to " + category + " gallery!");
        }
    }
    
    private void styleButton(JButton button) {
        button.setBackground(BABY_BLUE);
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.WHITE, 1));
    }
    
    private void styleUploadButton(JButton button) {
        button.setBackground(DARK_BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(new CompoundBorder(
            new LineBorder(BABY_BLUE, 2),
            new EmptyBorder(10, 20, 10, 20)
        ));
    }
}