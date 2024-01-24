package presentation.view;

import application.ApplicationController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NameView extends VBox {
    Label name;
    public TextField nameField;
    public Button confirmButton;



    public  NameView() {
        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        this.name = new Label("Name Player 2");
        this.name.getStyleClass().add("name-label");

        this.nameField = new TextField();
        this.nameField.getStyleClass().add("name-field");

        this.confirmButton = new Button("Play");
        this.confirmButton.getStyleClass().add("confirm-button");

        this.getStyleClass().add("name-view");

        this.getChildren().addAll(name, nameField, confirmButton);
    }


}
