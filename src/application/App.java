package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void init() {

	}

	@Override
	public void start(Stage primaryStage) {
		Pane root = new Pane();

		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);

		primaryStage.setTitle("My first Application");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}