package com.example.hotelsearch2h.controllers;

import com.example.hotelsearch2h.Database.DatabaseManager;
import com.example.hotelsearch2h.UI.LoginUserScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    public static Stage stage;
    @FXML
    TextField txtName;

    @FXML
    TextField txtEmail;

    @FXML
    TextField txtPhone;
    @FXML
    TextField txtPassword;

    @FXML
    Label txtError;

    public void registerButtonClicked() {

        if (txtName.getText() == null || txtName.getText().length() == 0) {
            txtError.setText("Please Enter Your Name");
            return;
        }
        if (txtEmail.getText() == null || txtEmail.getText().length() == 0) {
            txtError.setText("Please Enter Your Email");
            return;
        }
        if (txtPhone.getText() == null || txtPhone.getText().length() == 0) {
            txtError.setText("Please Enter your Phone Number");
            return;
        }
        if (txtPassword.getText() == null || txtPassword.getText().length() < 8) {
            txtError.setText("Password must be 8 characters long");
            return;
        }


        String username = txtName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();

        String status = DatabaseManager.registerUser(username, password, email, phone, 0, 0);

        if (status.contains("Error"))
            txtError.setText(status);
        else {

            // alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register");
            alert.setHeaderText(null);
            alert.setContentText("Success!");

            // Show the dialog box
            alert.showAndWait();
            stage.close();
            new LoginUserScreen();
        }
    }


}
