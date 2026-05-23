package com.example.pawcare;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOError;
import java.io.IOException;

public class ForgotPasswordScreen {


    public void show(Stage stage) throws IOException{
       // Stage forgotPasswordStage = new Stage();
        GridPane forgotPasswordPane = new GridPane();
        forgotPasswordPane.setAlignment(Pos.CENTER);
        forgotPasswordPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        forgotPasswordPane.setPadding(new Insets(20));
        forgotPasswordPane.setHgap(10);
        forgotPasswordPane.setVgap(20);
        Text welcomeTextForgot = new Text("PawCare");
        welcomeTextForgot.setFill(Color.HOTPINK);
        welcomeTextForgot.setFont(new Font("Ink free", 30));

        Label instructionLabel = new Label("Please enter your email to reset password:");
        instructionLabel.setTextFill(Color.BLACK);

        TextField emailField = new TextField();
        emailField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
        emailField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
        emailField.setMaxWidth(200);

        Button resetButton = new Button("Reset Password");
        resetButton.setMaxWidth(150);
        resetButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");

        forgotPasswordPane.add(welcomeTextForgot,0,0);
        forgotPasswordPane.add(instructionLabel, 0, 1);
        forgotPasswordPane.add(emailField, 0, 2);
        forgotPasswordPane.add(resetButton, 0, 3);

        resetButton.setOnAction(e2 -> {
            Stage resetPasswordStage = new Stage();
            GridPane resetPasswordPane = new GridPane();
            resetPasswordPane.setAlignment(Pos.CENTER);
            resetPasswordPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            resetPasswordPane.setPadding(new Insets(20));
            resetPasswordPane.setHgap(10);
            resetPasswordPane.setVgap(10);

            Text resetText = new Text("PawCare");
            resetText.setFill(Color.HOTPINK);
            resetText.setFont(new Font("Ink free", 25));

            Label newPasswordLabel = new Label("New Password:");
            newPasswordLabel.setTextFill(Color.BLACK);

            PasswordField newPasswordField = new PasswordField();
            newPasswordField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            newPasswordField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            newPasswordField.setMaxWidth(200);

            Label confirmNewLabel = new Label("Confirm New Password:");
            confirmNewLabel.setTextFill(Color.BLACK);

            PasswordField confirmNewField = new PasswordField();
            confirmNewField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            confirmNewField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            confirmNewField.setMaxWidth(200);

            Button updateButton = new Button("Update Password");
            updateButton.setMaxWidth(150);
            updateButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");

            resetPasswordPane.add(resetText, 0, 0);
            resetPasswordPane.add(newPasswordLabel, 0, 1);
            resetPasswordPane.add(newPasswordField, 0, 2);
            resetPasswordPane.add(confirmNewLabel, 0, 3);
            resetPasswordPane.add(confirmNewField, 0, 4);
            resetPasswordPane.add(updateButton, 0, 5);

            updateButton.setOnAction(e3 -> {
                Stage updatePasswordStage = new Stage();
                GridPane updatePasswordPane = new GridPane();
                updatePasswordPane.setAlignment(Pos.CENTER);
                updatePasswordPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                updatePasswordPane.setPadding(new Insets(20));
                updatePasswordPane.setHgap(10);
                updatePasswordPane.setVgap(20);

                Text updateText = new Text("PawCare");
                updateText.setFill(Color.HOTPINK);
                updateText.setFont(new Font("Ink free", 30));

                Label successLabel = new Label("Your password has been updated successfully.");
                successLabel.setTextFill(Color.BLACK);

                Button closeButton = new Button("Close");
                closeButton.setMaxWidth(150);
                closeButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
                closeButton.setOnAction(event -> updatePasswordStage.close());

                updatePasswordPane.add(updateText, 0, 0);
                updatePasswordPane.add(successLabel, 0, 1);
                updatePasswordPane.add(closeButton, 0, 2);

                Scene updatePasswordScene = new Scene(updatePasswordPane, 300, 200, Color.PINK);

                updatePasswordStage.setTitle("PawCare Pet Store");
                Image icon = new Image("pawIcon.jpeg");
                updatePasswordStage.getIcons().add(icon);
                updatePasswordStage.setScene(updatePasswordScene);
                updatePasswordStage.show();
            });


            Scene resetPasswordScene = new Scene(resetPasswordPane, 300, 250, Color.PINK);

            resetPasswordStage.setTitle("PawCare Pet Store");
            Image icon = new Image("pawIcon.jpeg");
            resetPasswordStage.getIcons().add(icon);
            resetPasswordStage.setScene(resetPasswordScene);
            resetPasswordStage.show();
        });


        Scene forgotPasswordScene = new Scene(forgotPasswordPane, 300, 200, Color.PINK);

        stage.setTitle("PawCare Pet store");
        Image icon = new Image("pawIcon.jpeg");
        stage.getIcons().add(icon);
        stage.setScene(forgotPasswordScene);
        stage.show();



    }
}
