package com.example.pawcare.util;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public final class DialogUtils {
    private DialogUtils() {
    }

    public static void showMessage(String message) {
        showMessage(message, null);
    }

    public static void showMessage(String message, Image optionalImage) {
        Stage dialogStage = new Stage();
        GridPane dialogPane = new GridPane();
        dialogPane.setAlignment(Pos.CENTER);
        dialogPane.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        dialogPane.setPadding(new Insets(20));
        dialogPane.setHgap(10);
        dialogPane.setVgap(20);

        Text header = new Text("PawCare");
        header.setFill(Color.HOTPINK);
        header.setFont(new Font("Ink free", 30));

        Label messageLabel = new Label(message);
        messageLabel.setTextFill(Color.BLACK);

        Button closeButton = new Button("Close");
        closeButton.setMaxWidth(150);
        closeButton.setStyle("-fx-background-color: pink; -fx-border-color: pink; -fx-border-radius: 50;");
        closeButton.setOnAction(event -> dialogStage.close());

        dialogPane.add(header, 0, 0, 2, 1);

        int nextRow = 1;
        if (optionalImage != null) {
            ImageView imageView = new ImageView(optionalImage);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            dialogPane.add(imageView, 0, nextRow, 2, 1);
            dialogPane.setHalignment(imageView, HPos.CENTER);
            dialogPane.setValignment(imageView, VPos.CENTER);
            nextRow++;
        }

        dialogPane.add(messageLabel, 0, nextRow, 2, 1);
        dialogPane.add(closeButton, 0, nextRow + 1, 2, 1);

        dialogPane.setHalignment(header, HPos.CENTER);
        dialogPane.setValignment(header, VPos.CENTER);
        dialogPane.setHalignment(messageLabel, HPos.CENTER);
        dialogPane.setValignment(messageLabel, VPos.CENTER);
        dialogPane.setHalignment(closeButton, HPos.CENTER);
        dialogPane.setValignment(closeButton, VPos.CENTER);

        Scene dialogScene = new Scene(dialogPane, 300, 200, Color.PINK);

        dialogStage.setTitle("PawCare Pet Store");
        dialogStage.getIcons().add(ImageLoader.load("/pawIcon.jpeg"));
        dialogStage.setScene(dialogScene);
        dialogStage.show();
    }
}
