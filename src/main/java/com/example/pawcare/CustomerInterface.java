package com.example.pawcare;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerInterface {
    SignUpValidation signup = new SignUpValidation();
    public void show(Stage stage,String logginUsername,String logginPassword) throws IOException{


        try{
            if ((signup.validateLogin(logginUsername, logginPassword)) == false) {

                Stage invalidStage = new Stage();
                GridPane invalidPane = new GridPane();
                invalidPane.setAlignment(Pos.CENTER);
                invalidPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                invalidPane.setPadding(new Insets(20));
                invalidPane.setHgap(10);
                invalidPane.setVgap(20);

                Text header = new Text("PawCare");
                header.setFill(Color.HOTPINK);
                header.setFont(new Font("Ink free", 30));

                Image invalidIcon = new Image("file:\\C:\\Users\\Lenovo\\Pictures\\warningFinal.jpg");
                ImageView invalidImageView = new ImageView(invalidIcon);
                invalidImageView.setFitWidth(50);
                invalidImageView.setFitHeight(50);

                Label invalidLabel = new Label("Invalid uername or password.");
                invalidLabel.setTextFill(Color.BLACK);

                Button closeButton = new Button("Close");
                closeButton.setMaxWidth(150);
                closeButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
                closeButton.setOnAction(event -> invalidStage.close());

                invalidPane.setAlignment(Pos.CENTER);
                invalidPane.add(header, 0, 0, 2, 1);
                invalidPane.add(invalidImageView, 0, 1, 2, 1);
                invalidPane.add(invalidLabel, 0, 2);
                invalidPane.add(closeButton, 0, 3);

                invalidPane.setHalignment(invalidImageView, HPos.CENTER);
                invalidPane.setValignment(invalidImageView, VPos.CENTER);

                invalidPane.setHalignment(header, HPos.CENTER);
                invalidPane.setValignment(header, VPos.CENTER);

                invalidPane.setHalignment(invalidLabel, HPos.CENTER);
                invalidPane.setValignment(invalidLabel, VPos.CENTER);

                invalidPane.setHalignment(closeButton, HPos.CENTER);
                invalidPane.setValignment(closeButton, VPos.CENTER);

                Scene invalidScene = new Scene(invalidPane, 300, 200, Color.PINK);

                invalidStage.setTitle("PawCare Pet Store");
                Image icon = new Image("pawIcon.jpeg");
                invalidStage.getIcons().add(icon);
                invalidStage.setScene(invalidScene);
                invalidStage.show();
            } else {
//                    alertLabel.setText(userNameField.getText());
//                    stage.setScene(new Scene(new FlowPane(), 500, 500));
                Stage customerInterface = new Stage();
                VBox parent = new VBox();
                parent.setAlignment(Pos.CENTER);
                parent.setPadding(new Insets(20));

                VBox vbox = new VBox();
                Image image = new Image("pawIcon.jpeg");
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(75);
                imageView.setFitHeight(75);
                imageView.setClip(new Circle(50, 50, 50));

                Text welcome = new Text();
                welcome.setText("PawCare");
                welcome.setFill(Color.HOTPINK);
                welcome.setFont(new Font("Ink Free", 50));

                Text options = new Text();
                options.setText("what would you like to do?");
                options.setFill(Color.HOTPINK);
                options.setFont(new Font("Arial", 20));
                vbox.setPadding(new Insets(20));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(welcome, imageView, options);
                TilePane tilePane = new TilePane();
                tilePane.setPadding(new Insets(20));
                tilePane.setHgap(10);
                tilePane.setVgap(20);
                tilePane.setAlignment(Pos.CENTER);

                Button myCart = new Button();
                myCart.setText("My Cart");
                myCart.setTextFill(Color.WHITE);
                myCart.setFont(new Font("Ink free", 25));
                myCart.setPrefWidth(175);
                myCart.setPrefHeight(100);
                myCart.setStyle("-fx-background-color: HOTPINK ; -fx-background-radius: 20;-fx-border-color: FLORALWHITE;");

                Button myPets = new Button();
                myPets.setText("My Pets");
                myPets.setFont(new Font("Ink Free", 25));
                myPets.setTextFill(Color.WHITE);
                myPets.setPrefWidth(175);
                myPets.setPrefHeight(100);
                myPets.setStyle("-fx-background-color: HOTPINK ; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");

                Button PetStore = new Button();
                PetStore.setText("Paw Store");
                PetStore.setFont(new Font("Ink Free", 25));
                PetStore.setTextFill(Color.WHITE);
                PetStore.setPrefWidth(175);
                PetStore.setPrefHeight(100);
                PetStore.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");

                Button OrderHistory = new Button();
                OrderHistory.setText(" My Orders");
                OrderHistory.setFont(new Font("Ink Free", 25));
                OrderHistory.setTextFill(Color.WHITE);
                OrderHistory.setPrefWidth(175);
                OrderHistory.setPrefHeight(100);
                OrderHistory.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");

                tilePane.getChildren().addAll(myCart, myPets, PetStore, OrderHistory);

                HBox hbox = new HBox();
                hbox.setPadding(new Insets(20));

                Image profile = new Image("file:\\C:\\Users\\Lenovo\\Pictures\\profile.jpeg");
                ImageView profileView = new ImageView(profile);
                profileView.setFitWidth(50);
                profileView.setFitHeight(50);


                Image cart = new Image("file:\\C:\\Users\\Lenovo\\Pictures\\cartFinal.png");
                ImageView cartView = new ImageView(cart);
                cartView.setFitWidth(50);
                cartView.setFitHeight(50);
                // cartView.setClip(new Circle(50));

                Image settings = new Image("file:\\C:\\Users\\Lenovo\\Pictures\\settingsFinal.png");
                ImageView settingsView = new ImageView(settings);
                settingsView.setFitWidth(50);
                settingsView.setFitHeight(50);
//                settingsView.setClip(new Circle(25));

                settingsView.setOnMouseClicked(event -> {
                    Stage settingsStage = new Stage();
                    VBox settingsvbox = new VBox();
                    settingsvbox.setPadding(new Insets(20));
                    settingsvbox.setAlignment(Pos.CENTER);

                    Text welcomeVbox = new Text();
                    welcomeVbox.setText("PawCare");
                    welcomeVbox.setFont(new Font("ink free", 50));
                    welcomeVbox.setFill(Color.HOTPINK);

                    Image setimage = new Image("pawIcon.jpeg");
                    ImageView setimageView = new ImageView(setimage);
                    setimageView.setFitWidth(100);
                    setimageView.setFitHeight(100);
                    setimageView.setClip(new Circle(50, 50, 50));

                    Button editProfile = new Button();
                    editProfile.setText("Edit profile");
                    editProfile.setFont(new Font("Ink Free", 20));
                    editProfile.setTextFill(Color.WHITE);
                    editProfile.setPrefWidth(155);
                    editProfile.setPrefHeight(75);
                    editProfile.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");

                    Button signOut = new Button();
                    signOut.setText("signOut");
                    signOut.setFont(new Font("Ink Free", 20));
                    signOut.setTextFill(Color.WHITE);
                    signOut.setPrefWidth(155);
                    signOut.setPrefHeight(75);
                    signOut.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");
                    signOut.setOnAction(e4 -> {
                        Stage signOutStage = new Stage();
                        GridPane signOutPane = new GridPane();
                        signOutPane.setAlignment(Pos.CENTER);
                        signOutPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                        signOutPane.setPadding(new Insets(20));
                        signOutPane.setHgap(10);
                        signOutPane.setVgap(20);

                        Text updateText = new Text("PawCare");
                        updateText.setFill(Color.HOTPINK);
                        updateText.setFont(new Font("Ink free", 30));

                        Label successLabel = new Label("You have been signed out successfully.");
                        successLabel.setTextFill(Color.BLACK);

                        Button closeButton = new Button("Close");
                        closeButton.setMaxWidth(150);
                        closeButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
                        closeButton.setOnAction(eventsignOut -> signOutStage.close());

                        signOutPane.add(updateText, 0, 0);
                        signOutPane.add(successLabel, 0, 1);
                        signOutPane.add(closeButton, 0, 2);

                        Scene signOutScene = new Scene(signOutPane, 300, 200, Color.PINK);

                        signOutStage.setTitle("PawCare Pet Store");
                        Image icon = new Image("pawIcon.jpeg");
                        signOutStage.getIcons().add(icon);
                        signOutStage.setScene(signOutScene);
                        signOutStage.show();
                    });

                    Button deleteProfile = new Button();
                    deleteProfile.setText("Delete Account");
                    deleteProfile.setFont(new Font("Ink Free", 20));
                    deleteProfile.setTextFill(Color.WHITE);
                    deleteProfile.setPrefWidth(155);
                    deleteProfile.setPrefHeight(75);
                    deleteProfile.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");
                    deleteProfile.setOnAction(e4 -> {
                        Stage deleteStage = new Stage();
                        GridPane deletePane = new GridPane();
                        deletePane.setAlignment(Pos.CENTER);
                        deletePane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                        deletePane.setPadding(new Insets(20));
                        deletePane.setHgap(10);
                        deletePane.setVgap(20);

                        Text updateText = new Text("PawCare");
                        updateText.setFill(Color.HOTPINK);
                        updateText.setFont(new Font("Ink free", 30));

                        Label successLabel = new Label("You account has been deleted successfully.");
                        successLabel.setTextFill(Color.BLACK);

                        Button closeButton = new Button("Close");
                        closeButton.setMaxWidth(150);
                        closeButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
                        closeButton.setOnAction(eventsignOut -> deleteStage.close());

                        deletePane.add(updateText, 0, 0);
                        deletePane.add(successLabel, 0, 1);
                        deletePane.add(closeButton, 0, 2);

                        Scene deleteScene = new Scene(deletePane, 300, 200, Color.PINK);

                        deleteStage.setTitle("PawCare Pet Store");
                        Image icon = new Image("pawIcon.jpeg");
                        deleteStage.getIcons().add(icon);
                        deleteStage.setScene(deleteScene);
                        deleteStage.show();
                    });


                    settingsvbox.setSpacing(20);
                    settingsvbox.getChildren().addAll(welcomeVbox, setimageView, editProfile, signOut, deleteProfile);
                    Scene settingsScene = new Scene(settingsvbox, 500, 600, Color.FLORALWHITE);
                    settingsStage.setTitle("pawCare Pet Store");
                    Image icon = new Image("pawIcon.jpeg");
                    settingsStage.getIcons().add(icon);
                    settingsStage.setScene(settingsScene);
                    settingsStage.show();
                });


                hbox.setSpacing(100);
                hbox.setAlignment(Pos.CENTER);
                hbox.getChildren().addAll(profileView, cartView, settingsView);
                parent.getChildren().addAll(vbox, tilePane, hbox);
                Scene scene = new Scene(parent, 500, 600, Color.FLORALWHITE);
                customerInterface.setTitle("PawCare Pet store");
                Image icon = new Image("pawIcon.jpeg");
                customerInterface.getIcons().add(icon);
                customerInterface.setScene(scene);
                customerInterface.show();
            }
        }catch(IOException | ClassNotFoundException exceptions){
            exceptions.printStackTrace();
        }
    }
}
