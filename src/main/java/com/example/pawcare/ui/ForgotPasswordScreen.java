package com.example.pawcare.ui;

import com.example.pawcare.service.CustomerStorageService;
import com.example.pawcare.service.ValidationService;
import com.example.pawcare.util.DialogUtils;
import com.example.pawcare.util.ImageLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPasswordScreen {
    private final ValidationService validationService = ValidationService.defaultService();
    private final CustomerStorageService storageService = CustomerStorageService.defaultStorage();

    public void show(Stage stage) {
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

        forgotPasswordPane.add(welcomeTextForgot, 0, 0);
        forgotPasswordPane.add(instructionLabel, 0, 1);
        forgotPasswordPane.add(emailField, 0, 2);
        forgotPasswordPane.add(resetButton, 0, 3);

        resetButton.setOnAction(e2 -> {
            String email = validationService.normalize(emailField.getText());
            if (validationService.isBlank(email)) {
                DialogUtils.showMessage("Please enter your email address.");
                return;
            }
            if (!validationService.isValidEmailFormat(email)) {
                DialogUtils.showMessage("Invalid email format.");
                return;
            }
            if (storageService.findByEmail(email).isEmpty()) {
                DialogUtils.showMessage("No account found for that email.");
                return;
            }

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
                String newPassword = validationService.normalize(newPasswordField.getText());
                String confirmPassword = validationService.normalize(confirmNewField.getText());

                if (validationService.isBlank(newPassword) || validationService.isBlank(confirmPassword)) {
                    DialogUtils.showMessage("Please enter and confirm your new password.");
                    return;
                }
                if (!validationService.isValidPassword(newPassword)) {
                    DialogUtils.showMessage("Password must be 5-8 characters long.");
                    return;
                }
                if (!newPassword.equals(confirmPassword)) {
                    DialogUtils.showMessage("Passwords do not match.");
                    return;
                }

                if (storageService.updatePassword(email, newPassword)) {
                    DialogUtils.showMessage("Your password has been updated successfully.");
                    resetPasswordStage.close();
                } else {
                    DialogUtils.showMessage("Unable to update password. Please try again.");
                }
            });

            Scene resetPasswordScene = new Scene(resetPasswordPane, 300, 250, Color.PINK);

            resetPasswordStage.setTitle("PawCare Pet Store");
            resetPasswordStage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
            resetPasswordStage.setScene(resetPasswordScene);
            resetPasswordStage.show();
        });

        Scene forgotPasswordScene = new Scene(forgotPasswordPane, 300, 200, Color.PINK);

        stage.setTitle("PawCare Pet store");
        stage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
        stage.setScene(forgotPasswordScene);
        stage.show();
    }
}
