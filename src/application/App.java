package application;

import business.data.Player;
import business.services.SoloGame;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.controller.SoloGameController;
import presentation.view.ButtonView;
import presentation.view.SoloGameView;

public class App extends Application {

	SoloGameController soloGameController;
	SoloGameView soloGameView;
	Player player1 = new Player("Tim");
	SoloGame soloGame;

	@Override
	public void init() {
		this.soloGame = new SoloGame(3,player1,20);
		this.soloGameView = new SoloGameView();
		this.soloGameController = new SoloGameController(soloGameView, soloGame);


	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		soloGameView.setMaxWidth(500);
		soloGameView.getStyleClass().add("solo-game-view"); // Apply SoloGameView style
		root.getChildren().add(soloGameView);

		// Apply CSS styles to the root
		root.getStyleClass().add("root");

		Scene scene = new Scene(root, 500, 500);

		// Load app.css
		scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Audio Memory");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}