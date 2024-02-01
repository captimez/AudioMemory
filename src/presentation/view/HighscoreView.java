package presentation.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HighscoreView extends VBox {
    protected Label score;
    public Label scorePoints;

    public Label playerName;

    HighscoreView() {
        this.getStylesheets().add(getClass().getResource("/presentation/view/style.css").toExternalForm());

        this.score = new Label();
        this.playerName = new Label("test");
        this.scorePoints = new Label();
        this.score.setText("Score:");
        this.scorePoints.setText("00000");

        // Apply CSS styles
        this.getStyleClass().add("highscore-view");
        this.score.getStyleClass().add("score-label");
        playerName.getStyleClass().add("score-points-label");
        this.scorePoints.getStyleClass().add("score-points-label");

        this.getChildren().addAll(playerName,score, scorePoints);
    }
}

