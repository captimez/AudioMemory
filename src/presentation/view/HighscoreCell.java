package presentation.view;


import business.data.Highscore;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HighscoreCell extends ListCell<Highscore> {
    Label name = new Label();
    Label score = new Label();
    Pane spacer = new Pane();


    HighscoreCell(){

        HBox hbox = new HBox();
        name.setMinWidth(100);
        score.setMinWidth(100);

        spacer.setPrefWidth(20);
        hbox.getChildren().addAll(name,spacer,score);

        this.setGraphic(hbox);
    }

    @Override
    protected void updateItem(Highscore item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            this.name.setText(null);
            this.score.setText(null);
        } else {
            this.name.setText(item.getSpielerName());
            this.score.setText(""+item.getPunkte());
        }
    }
}
