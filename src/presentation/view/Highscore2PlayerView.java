package presentation.view;

import business.data.Highscore;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

public class Highscore2PlayerView extends VBox {
    LinkedList<Highscore> highScores;
    ObservableList<Highscore> observableList;
    ListView<Highscore> listView;
    Label nameScoreLabel;
    VBox contentVBox;

    public Button switch1PlayerButton;
    public Button resetButton;
    HBox buttonsHBox;



    public Highscore2PlayerView() {
    //    this.observableList = FXCollections.observableArrayList(highScores);
    //    this.listView = new ListView<>(observableList);
        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        this.nameScoreLabel = new Label();
        this.nameScoreLabel.setText("Name - Score");
        this.nameScoreLabel.getStyleClass().add("listview-label");

        this.listView = new ListView<>();
        this.listView.setCellFactory(param -> new HighscoreCell());
        this.listView.getStyleClass().add("listview");

        this.switch1PlayerButton = new Button();
        this.switch1PlayerButton.setText("Einzelspieler Tabelle");
        this.switch1PlayerButton.getStyleClass().add("confirm-button");

        this.resetButton = new Button();
        this.resetButton.setText("Reset Liste");
        this.resetButton.getStyleClass().add("confirm-button");

        this.buttonsHBox = new HBox(switch1PlayerButton, resetButton);

        this.contentVBox = new VBox(nameScoreLabel, listView, buttonsHBox);
        this.getChildren().addAll(contentVBox);
    }

    public ListView<Highscore> getListView() {
        return listView;
    }


}
