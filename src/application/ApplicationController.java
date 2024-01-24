package application;

import business.data.Player;
import business.services.MultiplayerGame;
import business.services.SoloGame;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.controller.MultiplayerGameController;
import presentation.controller.NameViewController;
import presentation.controller.SoloGameController;
import presentation.view.MultiplayerGameView;
import presentation.view.NameView;
import presentation.view.SoloGameView;

public class ApplicationController {

    private Stage primaryStage;
    private VBox root;
    public Player player1;
    public Player player2;
    public ApplicationController(Stage primaryStage, VBox root,Player player1, Player player2) {
        this.primaryStage = primaryStage;
        this.root = root;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void transitionToSoloGame(){
        this.root.getChildren().clear();

        SoloGame soloGame = new SoloGame(3,player1,20);

        SoloGameView soloGameView = new SoloGameView();
        soloGameView.setMaxWidth(500);
        soloGameView.getStyleClass().add("solo-game-view");

        SoloGameController soloGameController= new SoloGameController(soloGameView, soloGame, this);
        root.getChildren().add(soloGameView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);

    }
    public void transitionToNameViewPlayer2(){
        this.root.getChildren().clear();

        NameView nameView = new NameView();
        nameView.setMaxWidth(500);
        nameView.getStyleClass().add("name-view");


        NameViewController nameViewController = new NameViewController(nameView, player2,this);
        nameViewController.gameNext =true;

        root.getChildren().add(nameView);


    }

    public void transitionToMultiplayerGame(){
        this.root.getChildren().clear();

        MultiplayerGame multiplayerGame = new MultiplayerGame(3,player1,player2,20);

        MultiplayerGameView multiplayerGameView = new MultiplayerGameView();
        multiplayerGameView.setMaxWidth(800);
        multiplayerGameView.getStyleClass().add("solo-game-view");

        MultiplayerGameController multiplayerGameController= new MultiplayerGameController(multiplayerGame, multiplayerGameView, this);
        root.getChildren().add(multiplayerGameView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);
    }
}
