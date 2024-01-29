package presentation.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CardPackSelectView extends VBox {

    BorderPane border;
    VBox centerVBox;
    Label label1;
    public ComboBox<String> comboBox;
    public Button confirmButton;

    HBox topHBox;
    HBox bottomHBox;
    HBox leftHBox;
    public Button goBackButton;
    HBox rightHBox;


    public CardPackSelectView() {
        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        this.getStyleClass().add("card-pack-select-view");
        this.centerVBox = new VBox();;

        this.label1 = new Label();
        this.label1.setText("Select CardSet");
        this.label1.setAlignment(javafx.geometry.Pos.CENTER);
        this.label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        this.label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        this.label1.setFont(new Font(15.0));

        Pane spacer = new Pane();
        spacer.setPrefHeight(50);
        spacer.setPrefWidth(50);

        this.comboBox = new ComboBox<>();
        this.comboBox.getItems().addAll("Tiere", "Pico 8");
        this.comboBox.setValue("Tiere");

        this.confirmButton = new Button();
        this.confirmButton.setText("OK");

        this.getStyleClass().add("card-pack-select-view");
        this.label1.getStyleClass().add("new-label");
        this.comboBox.getStyleClass().add("comboBox");
        this.confirmButton.getStyleClass().add("confirm-button");

        Insets leftMargin = new Insets(0, 300, 0, 0); // Adjust the left margin as needed

        // Set the left margin for the MainMenuView
        VBox.setMargin(this, leftMargin);

        this.centerVBox.getChildren().addAll(label1, comboBox,spacer, confirmButton);


        this.getChildren().addAll(centerVBox);

    }
}
