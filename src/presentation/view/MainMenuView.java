package presentation.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class MainMenuView extends VBox {
    Font arcadeFont = Font.loadFont(getClass().getResource("/Fonts/ARCADECLASSIC.TTF").toExternalForm(), 35);

    BorderPane border;
    VBox centerVBox;
    public Label paketSelectLabel;
    public Label multiplayerLabel;
    public Label highscoreLabel;
    public Label exitLabel;

    public Label singleplayerLabel;

    Label headline;
    HBox topHBox;
    HBox bottomHBox;
    HBox leftHBox;
    HBox rightHBox;

    public MainMenuView() {
        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        this.singleplayerLabel = new Label();
        this.singleplayerLabel.setText("Singleplayer");

        this.paketSelectLabel = new Label();
        this.paketSelectLabel.setText("Paket Select");

        this.multiplayerLabel = new Label();
        this.multiplayerLabel.setText("Multiplayer");

        this.highscoreLabel = new Label();
        this.highscoreLabel.setText("Highscores");

        this.exitLabel = new Label();
        this.exitLabel.setText("Exit");

        this.headline = new Label("ARCADE MEMORY");


        this.getStyleClass().add("main-menu-view");
        this.singleplayerLabel.getStyleClass().add("label-menu");
        this.paketSelectLabel.getStyleClass().add("label-menu");
        this.multiplayerLabel.getStyleClass().add("label-menu");
        this.highscoreLabel.getStyleClass().add("label-menu");
        this.exitLabel.getStyleClass().add("label-menu");
        this.headline.getStyleClass().add("headline");

        this.singleplayerLabel.setFont(arcadeFont);
        this.paketSelectLabel.setFont(arcadeFont);
        this.multiplayerLabel.setFont(arcadeFont);
        this.highscoreLabel.setFont(arcadeFont);
        this.exitLabel.setFont(arcadeFont);

        VBox.setMargin(this, new Insets(0, 500, 0, 0));



        this.getChildren().addAll(headline, singleplayerLabel, multiplayerLabel, paketSelectLabel, highscoreLabel, exitLabel);

    }

}


