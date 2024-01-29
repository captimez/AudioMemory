package application;

import business.data.Player;
import business.services.MultiplayerGame;
import business.services.SoloGame;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
		//VBox root = new VBox();
		//root.setAlignment(Pos.CENTER);


		ApplicationController controller = new ApplicationController(primaryStage,root,player1,player2);
		controller.transitionToMainMenu();

		root.getChildren().addAll();

		// Apply CSS styles to the root
		root.getStyleClass().add("root");
		root.setFillWidth(true);
		Scene scene = new Scene(root, 1280, 720);



		// Load app.css
		scene.getStylesheets().add(getClass().getResource("../presentation/view/style.css").toExternalForm());

		VBox.setVgrow(root, Priority.ALWAYS);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Audio Memory");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}