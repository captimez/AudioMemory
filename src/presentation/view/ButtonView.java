package presentation.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class ButtonView extends GridPane {


    public ButtonView() {
        this.getStylesheets().add(getClass().getResource("/presentation/view/button.css").toExternalForm());
        this.getStyleClass().add("button-view");
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        // Create 20 buttons in a 4x5 grid
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                Button button = createStyledButton("?" + (row * 5 + col + 1));
                this.add(button, col, row); // Add row and column constraints
            }
        }
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(80, 80);
        button.getStyleClass().add("button");
        return button;
    }


}
