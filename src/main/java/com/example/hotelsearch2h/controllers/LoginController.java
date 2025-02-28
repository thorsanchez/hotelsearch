package com.example.hotelsearch2h.controllers;

import com.example.hotelsearch2h.Database.DatabaseManager;
import com.example.hotelsearch2h.UI.RegisterUserScreen;
import com.example.hotelsearch2h.UI.RoomSearchScreen;
import com.example.hotelsearch2h.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//logic fyrir login screen
public class LoginController {


    public static Stage stage;
    @FXML
    private TextField user;

    @FXML
    private TextField pswd;

    @FXML
    private Label msg;//notum fyrir msg á user


    @FXML
    public void loginButtonClicked() {
        // Get the username and password entered by the user
        String username = user.getText();
        String password = pswd.getText();

        // Validate username and password fields
        if (username.isEmpty() || password.isEmpty()) {
            // Display an error message if either field is empty
            msg.setText("Username and password are required.");
        } else {
            // Attempt to login using the DatabaseManager
            User loggedInUser = DatabaseManager.loginUser(username, password);

            // Check if login was successful
            if (loggedInUser != null) {
                // If successful, display a success message
                msg.setText("Login successful. Welcome, " + loggedInUser.getName() + "!");
                // Create an alert dialog
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login Success!");
                alert.setHeaderText(null);
                alert.setContentText("Welcome, " + loggedInUser.getName() + "!");

                // Show the dialog box
                alert.showAndWait();

                if (stage != null)
                    stage.close();

                new RoomSearchScreen(loggedInUser);
            } else {
                // If unsuccessful, display an error message
                msg.setText("Invalid username or password. Please try again.");
            }
        }
    }


    public void registerButtonClicked() {

        new RegisterUserScreen();
        if (stage != null)
            stage.close();
    }


}
