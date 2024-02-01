package presentation.controller;

import application.App;
import application.ApplicationController;
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
    ApplicationController controller;

    public SoloGameController(SoloGameView soloGameView, SoloGame soloGame, ApplicationController controller){
        this.soloGameView = soloGameView;
        this.soloGame  = soloGame;
        this.buttonView = soloGameView.buttonView;
        this.controller = controller;
        this.soloGameView.highscoreView.playerName.setText(controller.player1.getName());

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
                    if( this.soloGame.playerClick(this.buttonView.getChildren().indexOf(button)).equals("finished")){
                        soloGameView.highscore.setVisible(true);
                    }

                });
                System.out.print(this.buttonView.getChildren().indexOf(button));
            }
        }
    }

    private void handleCardReset(){
        this.soloGame.cardReset.addListener((observable, oldValue, newValue) -> {
            if((Integer)newValue!=21) {
                buttonView.getChildren().get((Integer) newValue).getStyleClass().clear();
                buttonView.getChildren().get((Integer) newValue).getStyleClass().add("button");
            }
        });
    }

    private void handleCardSelected(){
        this.soloGame.cardSelected.addListener((observable,oldValue, newValue) -> {
            if((Integer)newValue == 21){

            }else{
                System.out.println(buttonView.getChildren().get((Integer) this.soloGame.cardSelected.get()).getStyleClass());
                buttonView.getChildren().get((Integer) this.soloGame.cardSelected.get()).getStyleClass().add("selected");
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
