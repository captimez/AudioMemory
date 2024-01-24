package presentation.controller;


import application.App;
import application.ApplicationController;
import business.data.Player;
import presentation.view.NameView;

public class NameViewController {
    NameView nameView;
    Player player;
    public Boolean gameNext;
    ApplicationController controller;

    public NameViewController(NameView nameView, Player player, ApplicationController controller){
        this.nameView = nameView;
        this.player = player;
        this.controller = controller;
        this.gameNext = false;
        init();
    }

    void init(){
        handleConfirm();
    }

    void handleConfirm(){

        nameView.nameField.textProperty().addListener((observable, oldValue, newValue) -> {

        });
        nameView.confirmButton.setOnMouseClicked(event -> {
            System.out.println("name" + nameView.nameField.getText());
            player.setName(nameView.nameField.getText());
            if(gameNext)
                this.controller.transitionToMultiplayerGame();
            else
                this.controller.transitionToNameViewPlayer2();
        });
    }
}
