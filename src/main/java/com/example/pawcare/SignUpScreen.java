
package com.example.pawcare;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SignUpScreen {
    ArrayList<Customer> customers = new ArrayList<>();
    File customerSignupFile = new File("CustomerSignUp.ser");
    SignUpValidation signup = new SignUpValidation();

    public void show(Stage stage) throws IOException {
        // Ensure the file is created
        if (!customerSignupFile.exists()) {
            customerSignupFile.createNewFile();
        }

        // Set up the main sign-up pane
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

        back.setOnAction(backevent ->{
            LoginScreen loginScreen=new LoginScreen();
            try {
                loginScreen.show(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        signupButton.setOnAction(signupEvent -> {
            try {
                String email = emailField.getText();
                String username = nameField.getText();
                String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
                String phoneNumber = phoneField.getText();
                String address = addressField.getText();

                boolean isEmailValid = signup.validateEmail(email);
                boolean isUsernameValid = signup.validateUsername(username);
                boolean isEmailFormatValid = signup.validateEmailFormat(email);

                alertLabelEmail.setText("");
                alertLabelUsername.setText("");

                if (!isEmailValid || !isUsernameValid || !isEmailFormatValid) {
                    if (!isEmailValid) {
                        alertLabelEmail.setText("Account on this email exists");
                    }
                    if (!isEmailFormatValid) {
                        alertLabelEmail.setText("Invalid email format");
                    }
                    if (!isUsernameValid) {
                        alertLabelUsername.setText("This username is not available");
                    }
                } else {
                    Stage PassStage = new Stage();
                    GridPane PassPane = new GridPane();
                    PassPane.setAlignment(Pos.CENTER);
                    PassPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    PassPane.setPadding(new Insets(20));
                    PassPane.setHgap(10);
                    PassPane.setVgap(10);


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

                    PassPane.add(createText, 0, 0, 2, 1);
                    PassPane.add(passwordLabelSignup, 0, 1);
                    PassPane.add(passwordFieldSignup, 1, 1);
                    PassPane.add(passwordLabelSignup2, 0, 2);
                    PassPane.add(passwordFieldSignup2, 1, 2);
                    PassPane.add(alertPasswordLabel, 1, 3);
                    PassPane.add(signupButton2, 0, 4, 2, 1);

                    signupButton2.setOnAction(e4 -> {

                        boolean validPassword = signup.isValidPassword(passwordFieldSignup2.getText());
                        String myPassword = passwordFieldSignup2.getText();
                        if (passwordFieldSignup.getText().equals(passwordFieldSignup2.getText()) && validPassword) {
                            try {
                                ArrayList<Customer> customers = new ArrayList<>();
                                customers =  signup.readFromFile(new File("CustomerSignUp.ser"));
                                customers.add(new Customer(email,username,myPassword,gender,phoneNumber,address));
                                signup.writeToFile(new File("CustomerSignUp.ser"),customers);
                            }catch(IOException exceptions){
                                exceptions.printStackTrace();
                            }
                            Stage createAccountStage = new Stage();
                            GridPane createAccountPane = new GridPane();
                            createAccountPane.setAlignment(Pos.CENTER);
                            createAccountPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                            createAccountPane.setPadding(new Insets(20));
                            createAccountPane.setHgap(10);
                            createAccountPane.setVgap(20);

                            Text updateText = new Text("PawCare");
                            updateText.setFill(Color.HOTPINK);
                            updateText.setFont(new Font("Ink free", 30));

                            Label successLabel = new Label("Your account has been created successfully.");
                            successLabel.setTextFill(Color.BLACK);

                            Button closeButton = new Button("Close");
                            closeButton.setMaxWidth(150);
                            closeButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
                            closeButton.setOnAction(event -> createAccountStage.close());

                            createAccountPane.add(updateText, 0, 0);
                            createAccountPane.add(successLabel, 0, 1);
                            createAccountPane.add(closeButton, 0, 2);

                            Scene createAccountScene = new Scene(createAccountPane, 300, 200, Color.PINK);
                            // password=passwordFieldSignup2.getText();
                            createAccountStage.setTitle("PawCare Pet Store");
                            Image icon = new Image("pawIcon.jpeg");
                            createAccountStage.getIcons().add(icon);
                            createAccountStage.setScene(createAccountScene);
                            createAccountStage.show();
                        } else {
                            if (!(signup.isValidPassword(passwordFieldSignup2.getText()))) {
                                alertPasswordLabel.setText("password must be 5-8 characters long.");
                            } else if (!(passwordFieldSignup.getText().equals(passwordFieldSignup2.getText()))) {
                                alertPasswordLabel.setText("passwords are not same");
                            } else {
                                alertPasswordLabel.setText("invalid password");
                            }
                        }

                    });


                    Scene signupScene = new Scene(PassPane, 300, 250, Color.LIGHTYELLOW);

                    PassStage.setTitle("PawCare Pet Store");
                    Image icon = new Image("pawIcon.jpeg");
                    PassStage.getIcons().add(icon);
                    PassStage.setScene(signupScene);
                    PassStage.show();
                }
                }
             catch (Exception exception) {
                exception.printStackTrace();
            }
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
        Image icon = new Image("pawIcon.jpeg");
        stage.getIcons().add(icon);
        stage.show();
    }
}

