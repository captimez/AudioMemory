package presentation.view;


import business.data.Highscore;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;

public class HighscoreCell extends ListCell<Highscore> {

    @Override
    protected void updateItem(Highscore item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.getSpielerName() + " - " + item.getPunkte());
            setTextFill(Color.BLACK);
        }
    }
}
