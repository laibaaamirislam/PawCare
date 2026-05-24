package com.example.pawcare.ui;

import com.example.pawcare.model.Customer;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpScreen {
    private final CustomerStorageService storageService = CustomerStorageService.defaultStorage();
    private final ValidationService validationService = ValidationService.defaultService();

    public void show(Stage stage) {
        GridPane signupPane = new GridPane();
        signupPane.setAlignment(Pos.CENTER);
        signupPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        signupPane.setPadding(new Insets(20));
        signupPane.setHgap(10);
        signupPane.setVgap(20);

        Text signupText = new Text("PawCare");
        signupText.setFill(Color.HOTPINK);
        signupText.setFont(new Font("Ink free", 30));

        Label nameLabel = new Label("Name:");
        nameLabel.setTextFill(Color.BLACK);
        TextField nameField = new TextField();

        Label emailLabel = new Label("Email:");
        emailLabel.setTextFill(Color.BLACK);
        TextField emailField = new TextField();
        Label alertLabelEmail = new Label();
        alertLabelEmail.setTextFill(Color.RED);
        alertLabelEmail.setFont(new Font("arial", 10));

        Label genderLabel = new Label("Gender:");
        genderLabel.setTextFill(Color.BLACK);
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(genderGroup);
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(genderGroup);

        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setTextFill(Color.BLACK);
        TextField phoneField = new TextField();

        Label addressLabel = new Label("Address:");
        addressLabel.setTextFill(Color.BLACK);
        TextField addressField = new TextField();

        Label alertLabelUsername = new Label();
        alertLabelUsername.setTextFill(Color.RED);
        alertLabelUsername.setFont(new Font("arial", 10));

        Button signupButton = new Button("Continue");
        signupButton.setMaxWidth(150);
        signupButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");

        Button back = new Button("Back");
        back.setMaxWidth(150);
        back.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");

        back.setOnAction(backevent -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.show(stage);
        });

        signupButton.setOnAction(signupEvent -> {
            String email = validationService.normalize(emailField.getText());
            String username = validationService.normalize(nameField.getText());
            String phoneNumber = validationService.normalize(phoneField.getText());
            String address = validationService.normalize(addressField.getText());
            String gender = genderGroup.getSelectedToggle() == null
                    ? ""
                    : ((RadioButton) genderGroup.getSelectedToggle()).getText();

            alertLabelEmail.setText("");
            alertLabelUsername.setText("");

            if (validationService.isBlank(username) || validationService.isBlank(email)
                    || validationService.isBlank(phoneNumber) || validationService.isBlank(address)
                    || validationService.isBlank(gender)) {
                DialogUtils.showMessage("Please complete all fields.");
                return;
            }

            boolean isEmailFormatValid = validationService.isValidEmailFormat(email);
            boolean isEmailAvailable = validationService.isEmailAvailable(email);
            boolean isUsernameAvailable = validationService.isUsernameAvailable(username);

            if (!isEmailFormatValid) {
                alertLabelEmail.setText("Invalid email format");
            } else if (!isEmailAvailable) {
                alertLabelEmail.setText("Account on this email exists");
            }

            if (!isUsernameAvailable) {
                alertLabelUsername.setText("This username is not available");
            }

            if (!validationService.isValidPhoneNumber(phoneNumber)) {
                DialogUtils.showMessage("Phone number must be numeric.");
                return;
            }

            if (!isEmailFormatValid || !isEmailAvailable || !isUsernameAvailable) {
                return;
            }

            Stage passStage = new Stage();
            GridPane passPane = new GridPane();
            passPane.setAlignment(Pos.CENTER);
            passPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            passPane.setPadding(new Insets(20));
            passPane.setHgap(10);
            passPane.setVgap(10);

            Text createText = new Text("PawCare");
            createText.setFill(Color.HOTPINK);
            createText.setFont(new Font("Ink free", 30));

            Label passwordLabelSignup = new Label("Password:");
            passwordLabelSignup.setTextFill(Color.BLACK);
            PasswordField passwordFieldSignup = new PasswordField();

            Label passwordLabelSignup2 = new Label("Confirm Password:");
            passwordLabelSignup2.setTextFill(Color.BLACK);
            TextField passwordFieldSignup2 = new TextField();

            Button signupButton2 = new Button("Create Account");
            signupButton2.setMaxWidth(150);
            signupButton2.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
            Label alertPasswordLabel = new Label();
            alertPasswordLabel.setText("");
            alertPasswordLabel.setTextFill(Color.RED);

            passPane.add(createText, 0, 0, 2, 1);
            passPane.add(passwordLabelSignup, 0, 1);
            passPane.add(passwordFieldSignup, 1, 1);
            passPane.add(passwordLabelSignup2, 0, 2);
            passPane.add(passwordFieldSignup2, 1, 2);
            passPane.add(alertPasswordLabel, 1, 3);
            passPane.add(signupButton2, 0, 4, 2, 1);

            signupButton2.setOnAction(e4 -> {
                String password = validationService.normalize(passwordFieldSignup.getText());
                String confirmPassword = validationService.normalize(passwordFieldSignup2.getText());

                if (!validationService.isValidPassword(password)) {
                    alertPasswordLabel.setText("password must be 5-8 characters long.");
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    alertPasswordLabel.setText("passwords are not same");
                    return;
                }

                Customer customer = new Customer(username, email, password, gender, phoneNumber, address);
                if (!storageService.addCustomer(customer)) {
                    DialogUtils.showMessage("Unable to create account. Please try again.");
                    return;
                }

                DialogUtils.showMessage("Your account has been created successfully.");
                passStage.close();
            });

            Scene signupScene = new Scene(passPane, 300, 250, Color.LIGHTYELLOW);

            passStage.setTitle("PawCare Pet Store");
            passStage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
            passStage.setScene(signupScene);
            passStage.show();
        });

        signupPane.add(signupText, 0, 0, 2, 1);
        signupPane.add(nameLabel, 0, 1);
        signupPane.add(nameField, 1, 1);
        signupPane.add(emailLabel, 0, 2);
        signupPane.add(emailField, 1, 2);
        signupPane.add(alertLabelEmail, 1, 3);
        signupPane.add(genderLabel, 0, 4);
        signupPane.add(maleRadioButton, 1, 4);
        signupPane.add(femaleRadioButton, 2, 4);
        signupPane.add(phoneLabel, 0, 5);
        signupPane.add(phoneField, 1, 5);
        signupPane.add(addressLabel, 0, 6);
        signupPane.add(addressField, 1, 6);
        signupPane.add(alertLabelUsername, 1, 7);
        signupPane.add(signupButton, 1, 8, 2, 1);
        signupPane.add(back, 1, 9, 2, 1);

        Scene signupScene = new Scene(signupPane, 500, 500);
        stage.setScene(signupScene);
        stage.setTitle("PawCare Pet Store");
        stage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
        stage.show();
    }
}
