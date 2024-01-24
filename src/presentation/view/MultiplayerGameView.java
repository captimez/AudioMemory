package presentation.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class MultiplayerGameView extends VBox {
    public HighscoreView highscoreView1;
    public HighscoreView highscoreView2;
    public ButtonView buttonView;
    public Label currentPlayer;
    public MultiplayerGameView(){
        this.getStylesheets().add(getClass().getResource("/presentation/view/style.css").toExternalForm());
        HBox game = new HBox();
        Label text = new Label("Current Player:");
        currentPlayer = new Label("current");
        currentPlayer.getStyleClass().add("name-label");
        text.getStyleClass().add("name-label");
        Label text2 = new Label("Winner:");
        text2.getStyleClass().add("name-label");
        Label winner = new Label();
        winner.getStyleClass().add("name-label");

        this.highscoreView1 = new HighscoreView();
        this.highscoreView2 = new HighscoreView();
        this.buttonView = new ButtonView();

        HBox.setHgrow(highscoreView1, Priority.ALWAYS);
        HBox.setHgrow(highscoreView2, Priority.ALWAYS);
        HBox.setHgrow(buttonView, Priority.SOMETIMES);

        game.getChildren().addAll(highscoreView1,buttonView,highscoreView2);


        this.setAlignment(Pos.CENTER); // Center the content vertically
        this.getChildren().addAll(text,currentPlayer,game,text2,winner);
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
