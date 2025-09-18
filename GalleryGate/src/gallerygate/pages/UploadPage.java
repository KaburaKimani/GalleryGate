package gallerygate.pages;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import gallerygate.GalleryGate;
import gallerygate.DatabaseConnection;

public class UploadPage extends BasePage {
    private final String[] CATEGORIES = {"Abstract", "Animals", "People", "Sculptures", "Vehicles"};
    private File selectedFile;
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JTextField priceField;
    private JComboBox<String> categoryCombo;
    private JLabel imagePreview;
    private final int PREVIEW_WIDTH = 200;
    private final int PREVIEW_HEIGHT = 200;
    private final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5 MB

    public UploadPage(GalleryGate parent) {
        super(parent, "Upload Artwork");
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = (JPanel) getContentPane();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header
        JPanel headerPanel = createHeader("Upload New Artwork");
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Title:"), gbc);
        titleField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(titleField, gbc);

        // Category
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Category:"), gbc);
        categoryCombo = new JComboBox<>(CATEGORIES);
        gbc.gridx = 1;
        formPanel.add(categoryCombo, gbc);

        // Price
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Price (KSH):"), gbc);
        priceField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(priceField, gbc);

        // Description
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Description:"), gbc);
        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        gbc.gridx = 1;
        formPanel.add(scrollPane, gbc);

        // Image Preview Panel
        JPanel previewPanel = new JPanel(new BorderLayout(10, 10));
        previewPanel.setBackground(Color.WHITE);
        previewPanel.setBorder(BorderFactory.createTitledBorder("Image Preview"));

        imagePreview = new JLabel();
        imagePreview.setPreferredSize(new Dimension(PREVIEW_WIDTH, PREVIEW_HEIGHT));
        imagePreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        imagePreview.setHorizontalAlignment(JLabel.CENTER);
        previewPanel.add(imagePreview, BorderLayout.CENTER);

        JButton chooseImageButton = new JButton("Choose Image");
        chooseImageButton.addActionListener(e -> chooseImage());
        previewPanel.add(chooseImageButton, BorderLayout.SOUTH);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(previewPanel, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener(e -> handleUpload());
        buttonPanel.add(uploadButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> parent.showPage("home"));
        buttonPanel.add(cancelButton);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Navigation Panel
        JPanel navPanel = createNavigationPanel();
        JButton homeButton = createNavButton("Home");
        homeButton.addActionListener(e -> parent.showPage("home"));
        navPanel.add(homeButton);
        mainPanel.add(navPanel, BorderLayout.WEST);
    }

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            if (!file.exists()) {
                showError("Selected file does not exist.");
                return;
            }

            if (file.length() > MAX_FILE_SIZE) {
                showError("File size exceeds 5 MB limit.");
                return;
            }

            selectedFile = file;
            updateImagePreview(selectedFile);
        }
    }

    private void updateImagePreview(File file) {
        try {
            ImageIcon imageIcon = new ImageIcon(file.getPath());
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(PREVIEW_WIDTH, PREVIEW_HEIGHT, Image.SCALE_SMOOTH);
            imagePreview.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            showError("Error loading image preview: " + e.getMessage());
        }
    }

    private void handleUpload() {
        // Validate inputs
        String title = titleField.getText().trim();
        String priceText = priceField.getText().trim();
        String description = descriptionArea.getText().trim();
        String category = (String) categoryCombo.getSelectedItem();

        if (title.isEmpty() || selectedFile == null || priceText.isEmpty()) {
            showError("Please fill in all required fields and select an image.");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
            if (price < 0) {
                showError("Price cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            showError("Please enter a valid price.");
            return;
        }

        // Disable UI components during upload
        setFormEnabled(false);

        // Run upload in background thread
        new SwingWorker<Void, Void>() {
            private String errorMessage = null;

            @Override
            protected Void doInBackground() {
                try {
                    // Prepare uploads directory
                    File uploadsDir = new File("uploads");
                    if (!uploadsDir.exists()) {
                        if (!uploadsDir.mkdirs()) {
                            errorMessage = "Failed to create uploads directory.";
                            return null;
                        }
                    }

                    // Copy image to uploads directory with unique name
                    String uniqueFileName = System.currentTimeMillis() + "_" + selectedFile.getName();
                    File destFile = new File(uploadsDir, uniqueFileName);
                    Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    // Get relative path to store in DB
                    String relativeImagePath = "uploads/" + uniqueFileName;

                    // Get current user ID from parent (implement this method)
                    int userId = parent.getCurrentUser Id();
                    if (userId <= 0) {
                        errorMessage = "Invalid user ID.";
                        return null;
                    }

                    // Insert into database
                    try (Connection conn = DatabaseConnection.connect()) {
                        String sql = "INSERT INTO artworks (title, category, price, description, image_path, user_id) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setString(1, title);
                            pstmt.setString(2, category);
                            pstmt.setDouble(3, price);
                            pstmt.setString(4, description);
                            pstmt.setString(5, relativeImagePath);
                            pstmt.setInt(6, userId);

                            pstmt.executeUpdate();
                        }
                    }
                } catch (IOException ioEx) {
                    errorMessage = "File error: " + ioEx.getMessage();
                } catch (Exception ex) {
                    errorMessage = "Database error: " + ex.getMessage();
                }
                return null;
            }

            @Override
            protected void done() {
                setFormEnabled(true);
                if (errorMessage != null) {
                    showError(errorMessage);
                } else {
                    showInfo("Artwork uploaded successfully!");
                    parent.showPage("home");
                }
            }
        }.execute();
    }

    private void setFormEnabled(boolean enabled) {
        titleField.setEnabled(enabled);
        categoryCombo.setEnabled(enabled);
        priceField.setEnabled(enabled);
        descriptionArea.setEnabled(enabled);
        imagePreview.setEnabled(enabled);
    }
}
