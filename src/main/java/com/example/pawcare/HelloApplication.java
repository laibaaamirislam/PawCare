package com.example.pawcare;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application{



    @Override
    public void start(Stage stage) throws IOException {

     LoginScreen loginScreen=new LoginScreen();
     loginScreen.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}