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

import java.io.IOException;

public class AdminLogin {

      ///Stage adminStage = new Stage();
    public void show(Stage stage) throws IOException {

        VBox adminVBox = new VBox(20);
        adminVBox.setAlignment(Pos.CENTER);
        adminVBox.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        adminVBox.setPadding(new Insets(50));

        Text welcomeTextAdmin = new Text("PawCare");
        welcomeTextAdmin.setFill(Color.HOTPINK);
        welcomeTextAdmin.setFont(new Font("Ink free", 30));

        Button button1 = new Button("ADMIN");
        button1.setMaxWidth(250);
        button1.setStyle("-fx-background-color: pink; -fx-border-radius: 50;");
        button1.setOnAction(event -> {
            Stage adminLoginStage = new Stage();
            GridPane adminLoginPane = new GridPane();
            adminLoginPane.setAlignment(Pos.CENTER);
            adminLoginPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            adminLoginPane.setPadding(new Insets(20));
            adminLoginPane.setHgap(10);
            adminLoginPane.setVgap(10);

            Text adminLoginText = new Text("PawCare");
            adminLoginText.setFill(Color.HOTPINK);
            adminLoginText.setFont(new Font("Ink free", 30));

            Label adminUsernameLabel = new Label("Username:");
            adminUsernameLabel.setTextFill(Color.BLACK);

            TextField adminUsernameField = new TextField();
            adminUsernameField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            adminUsernameField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            adminUsernameField.setMaxWidth(200);

            Label adminPasswordLabel = new Label("Password:");
            adminPasswordLabel.setTextFill(Color.BLACK);

            PasswordField adminPasswordField = new PasswordField();
            adminPasswordField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            adminPasswordField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            adminPasswordField.setMaxWidth(200);

            Button adminLoginButton = new Button("Login");
            adminLoginButton.setMaxWidth(150);
            adminLoginButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
            adminLoginButton.setOnAction(loginEvent -> {

            });

            adminLoginPane.add(adminLoginText, 0, 0);
            adminLoginPane.add(adminUsernameLabel, 0, 1);
            adminLoginPane.add(adminUsernameField, 0, 2);
            adminLoginPane.add(adminPasswordLabel, 0, 3);
            adminLoginPane.add(adminPasswordField, 0, 4);
            adminLoginPane.add(adminLoginButton, 0, 5);

            Scene adminLoginScene = new Scene(adminLoginPane, 300, 250, Color.PINK);

            adminLoginStage.setTitle("PawCare Pet Store");
            Image icon = new Image("pawIcon.jpeg");
            adminLoginStage.getIcons().add(icon);
            adminLoginStage.setScene(adminLoginScene);
            adminLoginStage.show();
        });

        Button button2 = new Button("VET");
        button2.setMaxWidth(250);
        button2.setStyle("-fx-background-color: pink; -fx-border-radius: 50;");
        button2.setOnAction(event -> {
            Stage adminLoginStage = new Stage();
            GridPane adminLoginPane = new GridPane();
            adminLoginPane.setAlignment(Pos.CENTER);
            adminLoginPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            adminLoginPane.setPadding(new Insets(20));
            adminLoginPane.setHgap(10);
            adminLoginPane.setVgap(10);

            Text adminLoginText = new Text("PawCare");
            adminLoginText.setFill(Color.HOTPINK);
            adminLoginText.setFont(new Font("Ink free", 30));

            Label adminUsernameLabel = new Label("Username:");
            adminUsernameLabel.setTextFill(Color.BLACK);

            TextField adminUsernameField = new TextField();
            adminUsernameField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            adminUsernameField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            adminUsernameField.setMaxWidth(200);

            Label adminPasswordLabel = new Label("Password:");
            adminPasswordLabel.setTextFill(Color.BLACK);

            PasswordField adminPasswordField = new PasswordField();
            adminPasswordField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            adminPasswordField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            adminPasswordField.setMaxWidth(200);

            Button adminLoginButton = new Button("Login");
            adminLoginButton.setMaxWidth(150);
            adminLoginButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
            adminLoginButton.setOnAction(loginEvent -> {

            });

            adminLoginPane.add(adminLoginText, 0, 0);
            adminLoginPane.add(adminUsernameLabel, 0, 1);
            adminLoginPane.add(adminUsernameField, 0, 2);
            adminLoginPane.add(adminPasswordLabel, 0, 3);
            adminLoginPane.add(adminPasswordField, 0, 4);
            adminLoginPane.add(adminLoginButton, 0, 5);

            Scene adminLoginScene = new Scene(adminLoginPane, 300, 250, Color.PINK);

            adminLoginStage.setTitle("PawCare Pet Store");
            Image icon = new Image("pawIcon.jpeg");
            adminLoginStage.getIcons().add(icon);
            adminLoginStage.setScene(adminLoginScene);
            adminLoginStage.show();
        });

        Button button3 = new Button("EMPLOYEE");
        button3.setMaxWidth(250);
        button3.setStyle("-fx-background-color: pink; -fx-border-radius: 50;");
        button3.setOnAction(event -> {
            Stage adminLoginStage = new Stage();
            GridPane adminLoginPane = new GridPane();
            adminLoginPane.setAlignment(Pos.CENTER);
            adminLoginPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            adminLoginPane.setPadding(new Insets(20));
            adminLoginPane.setHgap(10);
            adminLoginPane.setVgap(10);

            Text adminLoginText = new Text("PawCare");
            adminLoginText.setFill(Color.HOTPINK);
            adminLoginText.setFont(new Font("Ink free", 30));

            Label adminUsernameLabel = new Label("Username:");
            adminUsernameLabel.setTextFill(Color.BLACK);

            TextField adminUsernameField = new TextField();
            adminUsernameField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            adminUsernameField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            adminUsernameField.setMaxWidth(200);

            Label adminPasswordLabel = new Label("Password:");
            adminPasswordLabel.setTextFill(Color.BLACK);

            PasswordField adminPasswordField = new PasswordField();
            adminPasswordField.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(10), Insets.EMPTY)));
            adminPasswordField.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
            adminPasswordField.setMaxWidth(200);

            Button adminLoginButton = new Button("Login");
            adminLoginButton.setMaxWidth(150);
            adminLoginButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
            adminLoginButton.setOnAction(loginEvent -> {

            });

            adminLoginPane.add(adminLoginText, 0, 0);
            adminLoginPane.add(adminUsernameLabel, 0, 1);
            adminLoginPane.add(adminUsernameField, 0, 2);
            adminLoginPane.add(adminPasswordLabel, 0, 3);
            adminLoginPane.add(adminPasswordField, 0, 4);
            adminLoginPane.add(adminLoginButton, 0, 5);

            Scene adminLoginScene = new Scene(adminLoginPane, 300, 250, Color.PINK);

            adminLoginStage.setTitle("PawCare Pet Store");
            Image icon = new Image("pawIcon.jpeg");
            adminLoginStage.getIcons().add(icon);
            adminLoginStage.setScene(adminLoginScene);
            adminLoginStage.show();
        });
        adminVBox.getChildren().addAll(welcomeTextAdmin, button1, button2, button3);
        stage.setTitle("PawCare Pet store");
        Image icon = new Image("pawIcon.jpeg");
        stage.getIcons().add(icon);

        Scene adminScene = new Scene(adminVBox, 400, 300, Color.BEIGE);
        stage.setScene(adminScene);
        stage.show();
    }
}
