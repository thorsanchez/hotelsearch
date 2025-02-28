package com.example.hotelsearch2h.controllers;

import com.example.hotelsearch2h.Database.DatabaseManager;
import com.example.hotelsearch2h.UI.RoomBookingScreen;
import com.example.hotelsearch2h.models.Booking;
import com.example.hotelsearch2h.models.Room;
import com.example.hotelsearch2h.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RoomSearchController implements Initializable {

    ObservableList<Room> allRooms;

    @FXML
    ListView roomView;

    @FXML
    TextField hotel;

    @FXML
    TextField location;

    @FXML
    DatePicker startDatePicker;

    @FXML
    DatePicker endDatePicker;


    @FXML
    Slider sliderSingleBed;


    @FXML
    Slider sliderDoubleBed;

    @FXML
    CheckBox wifi;
    @FXML
    CheckBox bigBathroom;
    @FXML
    CheckBox roomService;

    //used to store  Filter rooms
    ObservableList<Room> filteredRooms = FXCollections.observableArrayList();
    ObservableList<Booking> allBookings;

    public static Stage stage;
    public static User currentUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Room> roomList = DatabaseManager.getAllRoomsFromDB();
        allRooms = FXCollections.observableList(roomList);
        List<Booking> bookingList = DatabaseManager.getAllBookingsFromDB();
        allBookings = FXCollections.observableList(bookingList);
    }

    LocalDate startDate;
    LocalDate endDate;

    @FXML
    public void searchRoom() {
        String hotelName = hotel.getText().trim();
        String locationName = location.getText().trim();
        startDate = startDatePicker.getValue();
        endDate = endDatePicker.getValue();

        LocalDate currentDate = LocalDate.now();

        // empty the ListView before adding filtered rooms
        roomView.getItems().clear();

        if (startDate == null || endDate == null) {
            // Create an alert dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Please select Start and End Date");

            // Show the dialog box
            alert.showAndWait();

            return;
        }
        if (startDate.isAfter(endDate)) {
            // Create an alert dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Start Date cannot be after End Date!");

            // Show dialog box
            alert.showAndWait();

            return;
        }


        if (startDate.isBefore(currentDate) || endDate.isBefore(currentDate)) {
            // alert dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Start Date and End Date must be after current Date");

            // shw dialog box
            alert.showAndWait();

            return;
        }


        // Filter rooms based on hotel name, location, and selected options
        for (Room room : allRooms) {
            if ((hotelName.isEmpty() || room.getHotelName().equalsIgnoreCase(hotelName) || room.getHotelName().contains(hotelName))
                    && (locationName.isEmpty() || room.getCity().equalsIgnoreCase(locationName) || room.getCountry().equalsIgnoreCase(locationName))
                    && (wifi.isSelected() == room.isHasWifi())
                    && (sliderSingleBed.getValue() <= room.getNumberOfSingleBeds())
                    && (sliderDoubleBed.getValue() <= room.getNumberOfDoubleBeds())
                    && (bigBathroom.isSelected() == room.isbigBathroom())
                    && (roomService.isSelected() == room.isHasRoomService())) {
                // Check if the room is available during the selected period
                if (isRoomAvailable(room.getId(), startDate, endDate)) {
                    filteredRooms.add(room);
                }
            }
        }

        // Display filtered rooms in the ListView
        updateListView();

    }

    private boolean isRoomAvailable(int roomId, LocalDate startDate, LocalDate endDate) {
        for (Booking booking : allBookings) {
            // Check if the room is booked during the selected period
            if (booking.getRoomId() == roomId && !booking.isCancelled() && !(endDate.isBefore(booking.getStartDate()) || startDate.isAfter(booking.getEndDate()))) {
                return false;
            }
        }
        return true;
    }

    @FXML
    public void bookRoom() {
        int selectedIndex = roomView.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Please select a room from list");

            // Show the dialog box
            alert.showAndWait();
        } else {
            if (stage != null) {
                stage.close();

            }
            new RoomBookingScreen(currentUser, filteredRooms.get(selectedIndex), startDate, endDate);


        }
    }

    private void updateListView() {

        roomView.setItems(filteredRooms);

    }


    @FXML
    private void handleCheckBoxChange(ActionEvent event) {
        searchRoom();
    }


    @FXML
    private void handleSliderChange(MouseEvent event) {
        searchRoom();
    }
}

