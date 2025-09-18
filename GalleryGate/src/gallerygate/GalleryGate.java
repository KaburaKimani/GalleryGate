package gallerygate;

import login.Login;

public class GalleryGate {
    public static void main(String[] args) {
        // Start the application by showing the login page
        Login loginPage = new Login();
        loginPage.setVisible(true);
    }
}