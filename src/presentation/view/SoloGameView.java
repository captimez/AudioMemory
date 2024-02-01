package presentation.view;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class SoloGameView extends VBox {
    public HighscoreView highscoreView;
    public ButtonView buttonView;

    public Button highscore;
    public Label combo;

    public SoloGameView() {
        this.highscoreView = new HighscoreView();
        this.buttonView = new ButtonView();

        highscore = new Button("Highscore Table");
        highscore.getStyleClass().add("confirm-button");
        highscore.setVisible(false);
        combo = new Label();
        combo.getStyleClass().add("name-label");

        // Set Hgrow for HighscoreView and ButtonView to ALWAYS
        VBox.setVgrow(highscoreView, Priority.ALWAYS);
        VBox.setVgrow(buttonView, Priority.ALWAYS);

        this.setAlignment(Pos.CENTER); // Center the content vertically
        this.getChildren().addAll(highscoreView,combo, buttonView,highscore);

    }

    public void blinkBackground() {
        Duration blinkDuration = Duration.seconds(0.5); // Duration for each blink
        Duration totalDuration = Duration.seconds(3);   // Total duration for blinking

        ColorAdjust colorAdjust = new ColorAdjust();

        Timeline blinkTimeline = new Timeline(
                new KeyFrame(blinkDuration, new KeyValue(colorAdjust.brightnessProperty(), 0.5)),
                new KeyFrame(blinkDuration.multiply(2), new KeyValue(colorAdjust.brightnessProperty(), 0))
        );

        blinkTimeline.setCycleCount((int) (totalDuration.toMillis() / (blinkDuration.toMillis() * 3))); // Blink for 3 seconds
        blinkTimeline.setOnFinished(event -> this.setEffect(null)); // Remove effect when finished
        blinkTimeline.play();

        this.setEffect(colorAdjust);
    }
}

