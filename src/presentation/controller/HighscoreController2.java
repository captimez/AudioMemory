package presentation.controller;

import application.ApplicationController;
import business.data.Highscore;
import business.services.HighscoreVerwalter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import presentation.view.Highscore2PlayerView;

import java.util.LinkedList;

public class HighscoreController2 {

    private Highscore2PlayerView highscore2PlayerView;
    private ObservableList<Highscore> highscores;

    private ApplicationController controller;

    public HighscoreController2(Highscore2PlayerView highscore2PlayerView, ApplicationController controller) {
        this.highscore2PlayerView = highscore2PlayerView;
        this.highscores = FXCollections.observableArrayList();
        this.highscore2PlayerView.getListView().setItems(highscores);
        this.controller = controller;

        init();
    }

    private void init(){
        handleSwitchHighscore();
        handleReset();
    }

    private void handleSwitchHighscore() {
        highscore2PlayerView.switch1PlayerButton.setOnMouseClicked(event -> {
           this.controller.transitionToHighscore1();
        });
    }

    private void handleReset() {
        highscore2PlayerView.resetButton.setOnMouseClicked(event -> {
            HighscoreVerwalter htest = new HighscoreVerwalter();
            htest.resetHighscore(true);
            highscores.removeAll();
            this.controller.transitionToHighscore1();
        });
    }




    public void addHighScore(LinkedList<Highscore> entry) {
        for (int i = 0; i < entry.size(); i++) {
            highscores.add(entry.get(i));
        }

    }
}
