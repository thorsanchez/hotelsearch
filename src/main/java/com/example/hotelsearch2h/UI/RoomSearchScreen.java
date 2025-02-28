package com.example.hotelsearch2h.UI;

import com.example.hotelsearch2h.controllers.RoomSearchController;
import com.example.hotelsearch2h.models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class RoomSearchScreen {
    //logged in user
    User currentUser;

    //constructer
    public RoomSearchScreen(User currentUser) {
        this.currentUser = currentUser;

        var value = ClassLoader.getSystemResource("room_search_screen.fxml");
        Stage primaryStage = new Stage();
        try {
            //load fxml file
            FXMLLoader loader = Optional.ofNullable(value).map(FXMLLoader::new).orElseThrow(
                    () -> new NoSuchElementException("View FXML resource not found")
            );
            // passing stage and user to RoomSearchController
            RoomSearchController.stage = primaryStage;
            RoomSearchController.currentUser = currentUser;
            //load scene
            var scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NoSuchElementException | IOException e) {

            System.err.println(e);
            System.exit(1);
        }


    }
}
