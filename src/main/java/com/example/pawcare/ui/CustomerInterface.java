package com.example.pawcare.ui;

import com.example.pawcare.service.ValidationService;
import com.example.pawcare.util.DialogUtils;
import com.example.pawcare.util.ImageLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerInterface {
    private final ValidationService validationService = ValidationService.defaultService();

    public void show(Stage stage, String loginUsername, String loginPassword) {
        String username = validationService.normalize(loginUsername);
        String password = validationService.normalize(loginPassword);

        if (validationService.isBlank(username) || validationService.isBlank(password)) {
            DialogUtils.showMessage("Username and password are required.");
            return;
        }

        if (validationService.authenticate(username, password).isEmpty()) {
            DialogUtils.showMessage("Invalid username or password.", ImageLoader.load("/warningFinal.jpg"));
            return;
        }

        Stage customerInterface = new Stage();
        VBox parent = new VBox();
        parent.setAlignment(Pos.CENTER);
        parent.setPadding(new Insets(20));

        VBox vbox = new VBox();
        Image image = ImageLoader.load("/pawIcon.jpeg");
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

        Button petStore = new Button();
        petStore.setText("Paw Store");
        petStore.setFont(new Font("Ink Free", 25));
        petStore.setTextFill(Color.WHITE);
        petStore.setPrefWidth(175);
        petStore.setPrefHeight(100);
        petStore.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");

        Button orderHistory = new Button();
        orderHistory.setText(" My Orders");
        orderHistory.setFont(new Font("Ink Free", 25));
        orderHistory.setTextFill(Color.WHITE);
        orderHistory.setPrefWidth(175);
        orderHistory.setPrefHeight(100);
        orderHistory.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");

        tilePane.getChildren().addAll(myCart, myPets, petStore, orderHistory);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20));

        Image profile = ImageLoader.load("/profile.jpeg");
        ImageView profileView = new ImageView(profile);
        profileView.setFitWidth(50);
        profileView.setFitHeight(50);

        Image cart = ImageLoader.load("/cartFinal.png");
        ImageView cartView = new ImageView(cart);
        cartView.setFitWidth(50);
        cartView.setFitHeight(50);

        Image settings = ImageLoader.load("/settingsFinal.png");
        ImageView settingsView = new ImageView(settings);
        settingsView.setFitWidth(50);
        settingsView.setFitHeight(50);

        settingsView.setOnMouseClicked(event -> {
            Stage settingsStage = new Stage();
            VBox settingsvbox = new VBox();
            settingsvbox.setPadding(new Insets(20));
            settingsvbox.setAlignment(Pos.CENTER);

            Text welcomeVbox = new Text();
            welcomeVbox.setText("PawCare");
            welcomeVbox.setFont(new Font("ink free", 50));
            welcomeVbox.setFill(Color.HOTPINK);

            Image setimage = ImageLoader.load("/pawIcon.jpeg");
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
            signOut.setOnAction(e4 -> DialogUtils.showMessage("You have been signed out successfully."));

            Button deleteProfile = new Button();
            deleteProfile.setText("Delete Account");
            deleteProfile.setFont(new Font("Ink Free", 20));
            deleteProfile.setTextFill(Color.WHITE);
            deleteProfile.setPrefWidth(155);
            deleteProfile.setPrefHeight(75);
            deleteProfile.setStyle("-fx-background-color: HOTPINK; -fx-background-radius: 20; -fx-border-color: FLORALWHITE");
            deleteProfile.setOnAction(e4 -> DialogUtils.showMessage("You account has been deleted successfully."));

            settingsvbox.setSpacing(20);
            settingsvbox.getChildren().addAll(welcomeVbox, setimageView, editProfile, signOut, deleteProfile);
            Scene settingsScene = new Scene(settingsvbox, 500, 600, Color.FLORALWHITE);
            settingsStage.setTitle("pawCare Pet Store");
            settingsStage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
            settingsStage.setScene(settingsScene);
            settingsStage.show();
        });

        hbox.setSpacing(100);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(profileView, cartView, settingsView);
        parent.getChildren().addAll(vbox, tilePane, hbox);
        Scene scene = new Scene(parent, 500, 600, Color.FLORALWHITE);
        customerInterface.setTitle("PawCare Pet store");
        customerInterface.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
        customerInterface.setScene(scene);
        customerInterface.show();
    }
}
