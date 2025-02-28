package com.example.hotelsearch2h.UI;

import com.example.hotelsearch2h.controllers.RoomBookingController;
import com.example.hotelsearch2h.models.Room;
import com.example.hotelsearch2h.models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

public class RoomBookingScreen {
    User currentUser;
    Room selectedRoom;

    public RoomBookingScreen(User currentUser, Room selectedRoom, LocalDate startDate, LocalDate endDate) {
        this.currentUser = currentUser;
        this.selectedRoom = selectedRoom;
        var value = ClassLoader.getSystemResource("room_booking.fxml");
        Stage primaryStage = new Stage();
        try {

            FXMLLoader loader = Optional.ofNullable(value).map(FXMLLoader::new).orElseThrow(
                    () -> new NoSuchElementException("View FXML resource not found")
            );
            RoomBookingController.stage = primaryStage;
            RoomBookingController.currentUser = currentUser;
            RoomBookingController.selectedRoom = selectedRoom;
            RoomBookingController.eDate = endDate;
            RoomBookingController.sDate = startDate;
            var scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NoSuchElementException | IOException e) {

            System.err.println(e.getMessage());
            System.exit(1);
        }


    }
}
