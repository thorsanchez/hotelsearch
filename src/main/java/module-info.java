module com.example.hotelsearch2h {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hotelsearch2h to javafx.fxml;
    exports com.example.hotelsearch2h;
    exports com.example.hotelsearch2h.controllers;
    exports com.example.hotelsearch2h.models;
    opens com.example.hotelsearch2h.controllers to javafx.fxml;
}
