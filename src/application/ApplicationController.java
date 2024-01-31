package application;

import business.data.Highscore;
import business.data.Kartenset;
import business.data.Player;
import business.services.HighscoreVerwalter;
import business.services.KartenVerwalter;
import business.services.MultiplayerGame;
import business.services.SoloGame;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.controller.*;
import presentation.view.*;

import java.util.LinkedList;

public class ApplicationController {

    private Stage primaryStage;
    private VBox root;
    public Player player1;
    public Player player2;
    NavigationView navigationView;
    NavigationViewController navigationViewController;

    public String gamemode = "singleplayer";

    public int currentSetIndex = 1;
    public ApplicationController(Stage primaryStage, VBox root, Player player1, Player player2) {
        this.navigationView = new NavigationView();
        this.navigationView.getStyleClass().add("navigation-view");
        this.navigationViewController = new NavigationViewController(this,navigationView);

        this.primaryStage = primaryStage;
        this.root = root;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void transitionToSoloGame(){
        this.root.getChildren().clear();

        SoloGame soloGame = new SoloGame(currentSetIndex,player1,20);

        SoloGameView soloGameView = new SoloGameView();
        soloGameView.setMaxWidth(500);
        soloGameView.getStyleClass().add("solo-game-view");

        SoloGameController soloGameController= new SoloGameController(soloGameView, soloGame, this);

        root.getChildren().addAll(navigationView,soloGameView);

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

        root.getChildren().addAll(navigationView,nameView);


    }

    public void transitionToNameViewPlayer1(){
        this.root.getChildren().clear();

        NameView nameView = new NameView();
        nameView.setMaxWidth(500);
        nameView.getStyleClass().add("name-view");
        nameView.name.setText("Your name");


        NameViewController nameViewController = new NameViewController(nameView, player1,this);
        nameViewController.gameNext =false;


        root.getChildren().addAll(navigationView,nameView);


    }

    public void transitionToMultiplayerGame(){
        this.root.getChildren().clear();

        MultiplayerGame multiplayerGame = new MultiplayerGame(currentSetIndex,player1,player2,20);

        MultiplayerGameView multiplayerGameView = new MultiplayerGameView();
        multiplayerGameView.setMaxWidth(800);
        multiplayerGameView.getStyleClass().add("solo-game-view");

        MultiplayerGameController multiplayerGameController= new MultiplayerGameController(multiplayerGame, multiplayerGameView, this);
        root.getChildren().addAll(navigationView,multiplayerGameView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);
    }

    public void transitionToCardPackSelect(){
        this.root.getChildren().clear();

        CardPackSelectView cardPackSelectView = new CardPackSelectView();
        cardPackSelectView.setMaxWidth(500);
        cardPackSelectView.getStyleClass().add("CardPackSelect-view");


        CardPackSelectViewController cardPackSelectViewController= new CardPackSelectViewController(cardPackSelectView, this);
        root.getChildren().addAll(cardPackSelectView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);

    }

    public void transitionToHighscore(){
        this.root.getChildren().clear();

    }

    public void transitionToHighscore1(){
        this.root.getChildren().clear();

        HighscoreVerwalter htest = new HighscoreVerwalter();

        LinkedList<Highscore> highscores = new LinkedList<>();
        highscores= htest.showListe(true);

        Highscore1PlayerView highscore1PlayerView = new Highscore1PlayerView();
        highscore1PlayerView.setMaxWidth(500);
        highscore1PlayerView.getStyleClass().add("Highscore-SinglePlayer-view");

        HighscoreController1 highscoreController= new HighscoreController1(highscore1PlayerView, this);
        highscoreController.addHighScore( highscores= htest.showListe(true));

        root.getChildren().addAll(navigationView, highscore1PlayerView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);

    }

    public void transitionToHighscore2(){
        this.root.getChildren().clear();

        HighscoreVerwalter htest = new HighscoreVerwalter();

        LinkedList<Highscore> highscores = new LinkedList<>();
        highscores= htest.showListe(false);

        Highscore2PlayerView highscore2PlayerView = new Highscore2PlayerView();
        highscore2PlayerView.setMaxWidth(500);
        highscore2PlayerView.getStyleClass().add("Highscore-2-Spieler-view");

        HighscoreController2 highscoreController2= new HighscoreController2(highscore2PlayerView, this);
        highscoreController2.addHighScore( highscores= htest.showListe(false));

        root.getChildren().addAll(navigationView, highscore2PlayerView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);

    }

    public void transitionToMainMenu(){
        this.root.getChildren().clear();

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.setMaxWidth(500);
        mainMenuView.getStyleClass().add("main-menu-view");


        MainMenuViewController mainMenuViewController= new MainMenuViewController(mainMenuView, this);
        root.getChildren().addAll(mainMenuView);

        Scene gameScene = primaryStage.getScene();
        this.primaryStage.setScene(gameScene);
    }
}
