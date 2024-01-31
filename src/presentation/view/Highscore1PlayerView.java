package presentation.view;

import business.data.Highscore;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

public class Highscore1PlayerView extends VBox {
    LinkedList<Highscore> highScores;
    ObservableList<Highscore> observableList;
    ListView<Highscore> listView;
    Label nameScoreLabel;
    VBox contentVBox;

    public Button switch2PlayerButton;
    public Button resetButton;
    HBox buttonsHBox;



    public Highscore1PlayerView() {
    //    this.observableList = FXCollections.observableArrayList(highScores);
    //    this.listView = new ListView<>(observableList);

        this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        this.nameScoreLabel = new Label();
        this.nameScoreLabel.setText("Name - Score");

        this.listView = new ListView<>();
        this.listView.setCellFactory(param -> new HighscoreCell());
        this.listView.getStyleClass().add("listview");

        this.switch2PlayerButton = new Button();
        this.switch2PlayerButton.setText("2 Spiele Tabelle");

        this.resetButton = new Button();
        this.resetButton.setText("Reset Liste");

        this.resetButton.getStyleClass().add("confirm-button");
        this.switch2PlayerButton.getStyleClass().add("confirm-button");

        this.buttonsHBox = new HBox(switch2PlayerButton, resetButton);

        this.contentVBox = new VBox(nameScoreLabel, listView, buttonsHBox);
        this.getChildren().addAll(contentVBox);
    }

    public ListView<Highscore> getListView() {
        return listView;
    }


}
