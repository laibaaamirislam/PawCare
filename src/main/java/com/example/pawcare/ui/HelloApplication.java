package com.example.pawcare.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}