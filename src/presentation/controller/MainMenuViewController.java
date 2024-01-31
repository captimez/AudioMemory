package presentation.controller;

import application.ApplicationController;
import javafx.application.Platform;
import presentation.view.MainMenuView;

public class MainMenuViewController {

    MainMenuView mainMenuView;
    ApplicationController controller;

    public MainMenuViewController(MainMenuView mainMenuView, ApplicationController controller) {
        this.mainMenuView = mainMenuView;
        this.controller = controller;

        init();
    }

    private void init(){
        handlePaketSelect();
        handleMultiplayerSelect();
        handleHighscoreViewSelect();
        handleExitSelect();
        handleSingleplayerSelect();
    }

    private void handleSingleplayerSelect() {
        mainMenuView.singleplayerLabel.setOnMouseClicked(event -> {
            System.out.println("Konfirm");
            this.controller.gamemode = "singleplayer";
            this.controller.transitionToNameViewPlayer1();
        });
    }

    private void handlePaketSelect() {
        mainMenuView.paketSelectLabel.setOnMouseClicked(event -> {
            System.out.println("Konfirm");
            this.controller.transitionToCardPackSelect();
        });
    }

    private void handleMultiplayerSelect() {
        mainMenuView.multiplayerLabel.setOnMouseClicked(event -> {
            System.out.println("Konfirm");
            this.controller.gamemode = "multiplayer";
            this.controller.transitionToNameViewPlayer1();
        });
    }

    private void handleHighscoreViewSelect() {
        mainMenuView.highscoreLabel.setOnMouseClicked(event -> {
            System.out.println("Konfirm");
            this.controller.transitionToHighscore1();
        });
    }

    private void handleExitSelect() {
        mainMenuView.exitLabel.setOnMouseClicked(event -> {
            Platform.exit();
        });
    }
}
