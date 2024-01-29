package presentation.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NavigationView extends VBox {
    public Button homeButton;
    public Button exitButton;
    public NavigationView(){
        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        this.getStyleClass().add("navigation-view");

        this.homeButton = new Button();
        this.exitButton = new Button();


        this.homeButton.setText("Home");
        this.exitButton.setText("Exit Game");
        homeButton.getStyleClass().add("confirm-button");
        exitButton.getStyleClass().add("confirm-button");

        this.getChildren().addAll(this.homeButton,this.exitButton);
    }
}
