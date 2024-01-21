package presentation.controller;

import business.services.SoloGame;
import javafx.scene.Node;
import javafx.scene.control.Button;
import presentation.view.ButtonView;
import presentation.view.SoloGameView;

public class SoloGameController {
    SoloGameView soloGameView;
    ButtonView buttonView;
    SoloGame soloGame;

    Node firstCardSelect = null;
    Node secondCardSelect;

    public SoloGameController(SoloGameView soloGameView, SoloGame soloGame){
        this.soloGameView = soloGameView;
        this.soloGame  = soloGame;
        this.buttonView = soloGameView.buttonView;

        init();
    }

    private void init(){
        handleCardSelected();
        handleCardFinished();
        handleHighscoreUpdate();
        handleCardReset();
        for (Node node : this.buttonView.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setOnMouseClicked(event -> {
                    this.soloGame.playerClick(this.buttonView.getChildren().indexOf(button));

                });
                System.out.print(this.buttonView.getChildren().indexOf(button));
            }
        }
    }

    private void handleCardReset(){
        this.soloGame.cardReset.addListener((observable, oldValue, newValue) -> {
            firstCardSelect.getStyleClass().remove("selected");
            buttonView.getChildren().get((Integer) newValue).getStyleClass().remove("selected");
        });
    }

    private void handleCardSelected(){
        this.soloGame.cardSelected.addListener((observable, oldValue, newValue) -> {
            System.out.println(buttonView.getChildren().get((Integer) newValue).getStyleClass());
            buttonView.getChildren().get((Integer) newValue).getStyleClass().add("selected");
            if(firstCardSelect == null){
                firstCardSelect = buttonView.getChildren().get((Integer) newValue);
            }else{
                firstCardSelect =buttonView.getChildren().get((Integer) oldValue);
            }
        });
    }

    private void handleCardFinished(){
        this.soloGame.cardFinished.addListener((observable, oldValue, newValue) -> {
            Node button2 = buttonView.getChildren().get((Integer) newValue);
            button2.getStyleClass().add("disabled");
            button2.setDisable(true);
        });
    }

    private void handleHighscoreUpdate(){
        this.soloGame.highscoreProperty.addListener((observable, oldValue, newValue) -> {
            this.soloGameView.highscoreView.scorePoints.setText(newValue);
            System.out.println(oldValue);
            if(!newValue.equals(oldValue))
                this.soloGameView.blinkBackground();
        });
    }


}
