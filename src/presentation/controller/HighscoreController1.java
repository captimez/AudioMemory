package presentation.controller;

import application.ApplicationController;
import business.data.Highscore;
import business.services.HighscoreVerwalter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import presentation.view.Highscore1PlayerView;

import java.util.LinkedList;

public class HighscoreController1 {

    private Highscore1PlayerView highscore1PlayerView;
    private ObservableList<Highscore> highscores;

    private ApplicationController controller;

    public HighscoreController1(Highscore1PlayerView highscore1PlayerView, ApplicationController controller) {
        this.highscore1PlayerView = highscore1PlayerView;
        this.highscores = FXCollections.observableArrayList();
        this.highscore1PlayerView.getListView().setItems(highscores);
        this.controller = controller;

        init();
    }

    private void init(){
        handleSwitchHighscore();
        handleReset();
    }

    private void handleSwitchHighscore() {
        highscore1PlayerView.switch2PlayerButton.setOnMouseClicked(event -> {
            this.controller.transitionToHighscore2();
        });
    }

    private void handleReset() {
        highscore1PlayerView.resetButton.setOnMouseClicked(event -> {
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
