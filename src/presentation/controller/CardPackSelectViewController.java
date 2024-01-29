package presentation.controller;

import application.ApplicationController;
import presentation.view.CardPackSelectView;

public class CardPackSelectViewController {

    CardPackSelectView cardPackSelectView;
    ApplicationController controller;


    public CardPackSelectViewController(CardPackSelectView cardPackSelectView, ApplicationController controller) {
        this.cardPackSelectView = cardPackSelectView;
        this.controller = controller;

        init();
    }

    private void init(){
        handleConfirm();
    }

    private void handleConfirm() {
        cardPackSelectView.confirmButton.setOnMouseClicked(event -> {
            System.out.println("OK");
            String selectedOption = cardPackSelectView.comboBox.getValue();

            switch(selectedOption){
                case "Tiere":
                    controller.currentSetIndex = 1;
                    controller.transitionToMainMenu();
                    break;
                case "Pico 8":
                    controller.currentSetIndex = 3;
                    controller.transitionToMainMenu();
            }
        });
    }



}
