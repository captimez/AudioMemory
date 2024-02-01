package presentation.controller;

import application.ApplicationController;
import business.services.MultiplayerGame;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.util.Duration;
import presentation.view.MultiplayerGameView;



public class MultiplayerGameController {
    MultiplayerGameView multiplayerGameView;
    MultiplayerGame multiplayerGame;

    Node firstCardSelect = null;
    ApplicationController controller;

    public MultiplayerGameController(MultiplayerGame multiplayerGame, MultiplayerGameView multiplayerGameView, ApplicationController controller) {
        this.multiplayerGame = multiplayerGame;
        this.multiplayerGameView = multiplayerGameView;
        this.controller = controller;
        this.multiplayerGameView.highscoreView1.playerName.setText(multiplayerGame.player1.getName());
        this.multiplayerGameView.highscoreView2.playerName.setText(multiplayerGame.player2.getName());



        init();
    }

    private void init(){
        this.multiplayerGameView.combo.textProperty().bind(multiplayerGame.comboProperty);
        handleCardSelected();
        handleCardFinished();
        handleHighscoreUpdate();
        handleCardReset();
        handleWinningPlayer();

        //Binding for currentPlayer
        multiplayerGameView.currentPlayer.textProperty().bind(multiplayerGame.currentPlayerProperty);

        //Button OnClickFunctions
        for (Node node : this.multiplayerGameView.buttonView.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setOnMouseClicked(event -> {
                    if(this.multiplayerGame.playerClick(this.multiplayerGameView.buttonView.getChildren().indexOf(button)) == "finished"){
                       // controller.transitionToNameViewPlayer2();
                    }else{}

                });
                System.out.print(this.multiplayerGameView.buttonView.getChildren().indexOf(button));
            }
        }
    }

    private void handleWinningPlayer(){
        this.multiplayerGame.winningPlayerProperty.addListener((observable, oldValue, newValue) -> {
            this.multiplayerGameView.winner.setText(newValue);
            this.multiplayerGameView.highscore.setVisible(true);
            handleHighscoreButton();
        });
    }

    private void handleHighscoreButton(){
        this.multiplayerGameView.highscore.setOnMouseClicked(event -> {
            controller.transitionToHighscore2();
        });
    }

    private void handleCardReset(){
        this.multiplayerGame.cardReset.addListener((observable, oldValue, newValue) -> {
            if((Integer)newValue!=21) {
                multiplayerGameView.buttonView.getChildren().get((Integer) newValue).getStyleClass().remove("selected");
            }
        });
    }


    private void handleCardSelected(){
        this.multiplayerGame.cardSelected.addListener((observable, oldValue, newValue) -> {
            System.out.println(multiplayerGameView.buttonView.getChildren().get((Integer) newValue).getStyleClass());
            multiplayerGameView.buttonView.getChildren().get((Integer) newValue).getStyleClass().add("selected");
            if(firstCardSelect == null){
                firstCardSelect = multiplayerGameView.buttonView.getChildren().get((Integer) newValue);
            }else{
                firstCardSelect =multiplayerGameView.buttonView.getChildren().get((Integer) oldValue);
            }
        });
    }

    private void handleCardFinished(){
        this.multiplayerGame.cardFinished.addListener((observable, oldValue, newValue) -> {
            Node button2 = multiplayerGameView.buttonView.getChildren().get((Integer) newValue);
            button2.getStyleClass().add("disabled");
            button2.setDisable(true);
        });
    }

    private void handleHighscoreUpdate(){
        this.multiplayerGame.highscoreProperty1.addListener((observable, oldValue, newValue) -> {
            this.multiplayerGameView.highscoreView1.scorePoints.setText(newValue);
            System.out.println(oldValue);
            if(!newValue.equals(oldValue))
                this.multiplayerGameView.blinkBackground();
        });
        this.multiplayerGame.highscoreProperty2.addListener((observable, oldValue, newValue) -> {
            this.multiplayerGameView.highscoreView2.scorePoints.setText(newValue);
            System.out.println(oldValue);
            if(!newValue.equals(oldValue))
                this.multiplayerGameView.blinkBackground();
        });
    }


}
