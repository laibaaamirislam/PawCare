package com.example.pawcare.ui;

import com.example.pawcare.service.ValidationService;
import com.example.pawcare.util.DialogUtils;
import com.example.pawcare.util.ImageLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScreen {
    private final ValidationService validationService = ValidationService.defaultService();

    public void show(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setBorder(Border.stroke(Color.BLACK));
        gridPane.setBackground(Background.fill(Color.HOTPINK));

        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(20);

        Text welcomeText = new Text("PawCare says woof!");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(new Font("Ink free", 40));

        gridPane.add(welcomeText, 0, 0, 2, 1);
        gridPane.setHalignment(welcomeText, HPos.CENTER);
        gridPane.setValignment(welcomeText, VPos.CENTER);

        Image image = ImageLoader.load("/pawIcon.jpeg");
        ImageView imageView = new ImageView(image);
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

        VBox vBox = new VBox();
        vBox.getChildren().addAll(imageView, userNameLabel, userNameField, passwordLabel, passwordField,
                showPasswordCheckBox);
        vBox.setAlignment(Pos.CENTER);

        vBox.setSpacing(10);
        gridPane.add(vBox, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(125);
        loginButton.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-radius: 30;");
        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(125);
        cancelButton.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-radius: 30;");
        VBox buttonBox = new VBox(15, loginButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);
        gridPane.add(buttonBox, 0, 3, 4, 1);

        cancelButton.setOnAction(actionEvent -> stage.close());

        loginButton.setOnAction(actionEvent -> {
            String username = validationService.normalize(userNameField.getText());
            String password = validationService.normalize(passwordField.getText());
            if (validationService.isBlank(username) || validationService.isBlank(password)) {
                DialogUtils.showMessage("Please enter both username and password.");
                return;
            }
            CustomerInterface customerInterface = new CustomerInterface();
            customerInterface.show(stage, username, password);
        });

        Hyperlink hyperlink = new Hyperlink("forgot password?");
        hyperlink.setTextFill(Color.WHITE);
        Hyperlink hyperlink2 = new Hyperlink("Admin");
        hyperlink2.setTextFill(Color.WHITE);
        Hyperlink hyperlink3 = new Hyperlink("Sign up");
        hyperlink3.setTextFill(Color.WHITE);
        hyperlink3.setOnAction(e -> {
            SignUpScreen signUpScreen = new SignUpScreen();
            signUpScreen.show(stage);
        });

        hyperlink2.setOnAction(ex -> {
            AdminLogin adminLoginScreen = new AdminLogin();
            adminLoginScreen.show(stage);
        });

        hyperlink.setOnAction(e -> {
            ForgotPasswordScreen forgotPasswordScreen = new ForgotPasswordScreen();
            forgotPasswordScreen.show(stage);
        });

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.BOTTOM_RIGHT);
        vBox2.getChildren().addAll(hyperlink, hyperlink2, hyperlink3);
        gridPane.add(vBox2, 1, 4, 1, 1);

        Scene scene = new Scene(gridPane, 500, 600, Color.DEEPPINK);
        stage.setTitle("PawCare Pet store");
        stage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
        stage.setScene(scene);
        stage.show();
    }
}
