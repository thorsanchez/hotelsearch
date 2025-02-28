package com.example.hotelsearch2h.controllers;

import com.example.hotelsearch2h.Database.DatabaseManager;
import com.example.hotelsearch2h.UI.RoomSearchScreen;
import com.example.hotelsearch2h.models.Booking;
import com.example.hotelsearch2h.models.Room;
import com.example.hotelsearch2h.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RoomBookingController implements Initializable {

    public static Stage stage;
    public static User currentUser;
    public static Room selectedRoom;

    @FXML
    TextField startDate;

    @FXML
    TextField endDate;

    @FXML
    TextField numberOfAdults;
    @FXML
    TextField numberOfChildren;
    @FXML
    Label hotelName;
    @FXML
    Button bookRoom;

    @FXML
    Button back;


    public static LocalDate sDate;
    public static LocalDate eDate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startDate.setText(sDate.toString());
        endDate.setText(eDate.toString());
        hotelName.setText(selectedRoom.getHotelName());

    }


    //when back button is pressed
    @FXML
    public void setBack() {


        new RoomSearchScreen(currentUser);
        if (stage != null)
            stage.close();
    }


    //when book room is pressed

    @FXML
    public void bookRoom() {
        //get data from all text fields
        if (numberOfAdults.getText() == null || numberOfAdults.getText().isEmpty() || numberOfChildren.getText() == null || numberOfChildren.getText().isEmpty()) {
            displayAlert("Error!", "Please enter data in all fields", Alert.AlertType.ERROR);
            return;
        }

        int adults = 0;
        int children = 0;
        try {
            adults = Integer.parseInt(numberOfAdults.getText());
            children = Integer.parseInt(numberOfChildren.getText());

            if (adults == 0) {
                displayAlert("Error!", "At least one person should be older than 18 years.", Alert.AlertType.ERROR);
                return;
            }

        } catch (NumberFormatException e) {
            displayAlert("Error!", "Please Enter valid data", Alert.AlertType.ERROR);
            return;
        }

        Booking booking = new Booking();
        currentUser.setNumberOfAdults(adults);
        currentUser.setNumberOfChildren(children);
        booking.setUserID(currentUser.getId());
        booking.setRoomId(selectedRoom.getId());
        booking.setStartDate(sDate);
        booking.setEndDate(eDate);
        booking.setCancelled(false);

        boolean status = DatabaseManager.insertNewBookingIntoDB(booking);

        if (status) {
            displayAlert("Success!", "Room Booked", Alert.AlertType.INFORMATION);

            new RoomSearchScreen(currentUser);
            stage.close();
        } else
            displayAlert("Error!", "Something went wrong..", Alert.AlertType.ERROR);


    }


    private void displayAlert(String title, String content, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    }


}
