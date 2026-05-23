package com.example.pawcare;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginScreen {

    public void show(Stage stage) throws IOException{
        SignUpValidation signup = new SignUpValidation();
        ArrayList<Customer> customer = new ArrayList<>();

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setBorder(Border.stroke(Color.BLACK));
        gridPane.setBackground(Background.fill(Color.HOTPINK));


        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(10);
        gridPane.setVgap(20);


        Text welcomeText = new Text("PawCare says woof!");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(new Font("Ink free", 40));

        gridPane.add(welcomeText,0,0,2,1);
        gridPane.setHalignment(welcomeText, HPos.CENTER);
        gridPane.setValignment(welcomeText, VPos.CENTER);
        Image image=new Image("pawIcon.jpeg");
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setClip(new Circle(50, 50, 50));


        Label userNameLabel = new Label("Username:");
        userNameLabel.setTextFill(Color.WHITE);
        userNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        TextField userNameField = new TextField();
        userNameField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,
                new CornerRadii(10), Insets.EMPTY)));
        userNameField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
                new CornerRadii(10), BorderWidths.DEFAULT)));
        userNameField.setMaxWidth(150);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.WHITE);
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(150);
        passwordField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,
                new CornerRadii(10), Insets.EMPTY)));

        passwordField.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

        CheckBox showPasswordCheckBox = new CheckBox("Show Password");
        showPasswordCheckBox.setTextFill(Color.WHITE);
        showPasswordCheckBox.setOnAction(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setPromptText(passwordField.getText());
                passwordField.setText("");
                passwordField.setBackground(new Background(new BackgroundFill(Color.WHITE,
                        new CornerRadii(10), Insets.EMPTY)));

                passwordField.setStyle("-fx-font-weight:bold; -fx-text-fill: black; -fx-opacity: 1.0;");


            } else {
                passwordField.setText(passwordField.getPromptText());
                passwordField.setPromptText("");
                passwordField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,
                        new CornerRadii(10), Insets.EMPTY)));

            }
        });


        VBox vBox=new VBox();
        vBox.getChildren().addAll(imageView,userNameLabel,userNameField,passwordLabel,passwordField,showPasswordCheckBox);
        vBox.setAlignment(Pos.CENTER);

        vBox.setSpacing(10);
        gridPane.add(vBox,1,1);

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(125);
        loginButton.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-radius: 30;");
        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(125);
        cancelButton.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-radius: 30;");
        VBox buttonBox = new VBox(15, loginButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);
        gridPane.add(buttonBox, 0, 3,4,1);

        Label alertLabel = new Label();

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               CustomerInterface customerInterface=new CustomerInterface();
                try {
                    customerInterface.show(stage,userNameField.getText(),passwordField.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Hyperlink hyperlink=new Hyperlink("forgot password?");
        hyperlink.setTextFill(Color.WHITE);
        Hyperlink hyperlink2=new Hyperlink("Admin");
        hyperlink2.setTextFill(Color.WHITE);
        Hyperlink hyperlink3 =new Hyperlink("Sign up");
        hyperlink3.setTextFill(Color.WHITE);
        hyperlink3.setOnAction(e -> {
            try {
                SignUpScreen signUpScreen = new SignUpScreen();
                signUpScreen.show(stage);
            }catch(IOException ioException){
                ioException.getMessage();
            }
        });


        hyperlink2.setOnAction(ex -> {
            AdminLogin adminLoginScreen = new AdminLogin();
            try {
                adminLoginScreen.show(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        hyperlink.setOnAction(e -> {
            ForgotPasswordScreen forgotPasswordScreen=new ForgotPasswordScreen();
            try {
                forgotPasswordScreen.show(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        VBox vBox2=new VBox();
        vBox2.setAlignment(Pos.BOTTOM_RIGHT);
        vBox2.getChildren().addAll(hyperlink,hyperlink2,hyperlink3);
        gridPane.add(vBox2,1,4,1,1);



        Scene scene =  new Scene(gridPane,500,600,Color.DEEPPINK);
        stage.setTitle("PawCare Pet store");
        Image icon = new Image("pawIcon.jpeg");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
}
