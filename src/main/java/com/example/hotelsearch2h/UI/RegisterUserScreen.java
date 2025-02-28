package com.example.hotelsearch2h.UI;

import com.example.hotelsearch2h.controllers.RegisterController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class RegisterUserScreen {


    public RegisterUserScreen() {

        var value = ClassLoader.getSystemResource("register.fxml");
        Stage primaryStage = new Stage();
        try {

            FXMLLoader loader = Optional.ofNullable(value).map(FXMLLoader::new).orElseThrow(
                    () -> new NoSuchElementException("View FXML resource not found")
            );
            RegisterController.stage = primaryStage;
            var scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NoSuchElementException | IOException e) {

            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}
