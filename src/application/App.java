package application;

import business.data.Player;
import business.services.MultiplayerGame;
import business.services.SoloGame;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.controller.NameViewController;
import presentation.controller.SoloGameController;
import presentation.view.ButtonView;
import presentation.view.NameView;
import presentation.view.SoloGameView;

public class App extends Application {

	SoloGameController soloGameController;
	SoloGameView soloGameView;
	Player player1 = new Player("Tim");
	Player player2 = new Player(null);
	SoloGame soloGame;
	MultiplayerGame multiplayerGame;
	NameView nameViewPlayer1;
	NameView nameViewPlayer2;
	NameViewController nameViewControllerPlayer1;
	NameViewController nameViewControllerPlayer2;

	@Override
	public void init() {
		this.soloGame = new SoloGame(3,player1,20);
		this.soloGameView = new SoloGameView();
		this.nameViewPlayer1 = new NameView();

	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);

		ApplicationController controller = new ApplicationController(primaryStage,root,player1,player2);
		this.nameViewControllerPlayer1 = new NameViewController(this.nameViewPlayer1,player1,controller);

		nameViewPlayer1.setMaxWidth(500);
		nameViewPlayer1.getStyleClass().add("name-view");
		root.getChildren().addAll(nameViewPlayer1);

		// Apply CSS styles to the root
		root.getStyleClass().add("root");

		Scene scene = new Scene(root, 800, 600);

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