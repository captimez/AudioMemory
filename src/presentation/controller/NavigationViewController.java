package presentation.controller;

import application.ApplicationController;
import business.data.Player;
import javafx.application.Platform;
import presentation.view.NavigationView;

public class NavigationViewController {
    NavigationView navigationView;
    ApplicationController controller;
    public NavigationViewController(ApplicationController controller, NavigationView navigationView){
        this.controller = controller;
        this.navigationView = navigationView;
        init();
    }

    private void init(){
        handleHomeButton();
        handleExitButton();
    }

    private void handleHomeButton(){
        this.navigationView.homeButton.setOnMouseClicked( event -> {
            controller.transitionToMainMenu();
        });
    }

    private void handleExitButton(){
        this.navigationView.exitButton.setOnMouseClicked(event ->{
            Platform.exit();
        });
    }
}
