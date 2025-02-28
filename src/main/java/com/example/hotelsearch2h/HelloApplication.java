package com.example.hotelsearch2h;


import com.example.hotelsearch2h.Database.SQLiteDBCreator;
import com.example.hotelsearch2h.UI.LoginUserScreen;
import javafx.application.Application;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SQLiteDBCreator.CreateDatabaseIfNotExist();
        new LoginUserScreen();
    }

    public static void main(String[] args) {
        launch();

    }


}
