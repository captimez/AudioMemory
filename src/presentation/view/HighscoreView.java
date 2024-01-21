package presentation.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HighscoreView extends VBox {
    protected Label score;
    public Label scorePoints;

    HighscoreView() {
        this.getStylesheets().add(getClass().getResource("/presentation/view/style.css").toExternalForm());

        this.score = new Label();
        this.scorePoints = new Label();
        this.score.setText("Score:");
        this.scorePoints.setText("00000");

        // Apply CSS styles
        this.getStyleClass().add("highscore-view");
        this.score.getStyleClass().add("score-label");
        this.scorePoints.getStyleClass().add("score-points-label");

        this.getChildren().addAll(score, scorePoints);
    }
}

