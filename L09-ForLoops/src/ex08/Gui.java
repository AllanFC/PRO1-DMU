package ex08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
	private int screenWidth = 200;
	private int screenHeight = 200;

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Exercise 3");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(screenWidth, screenHeight);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		int x = 16;
		int x2 = x;
		int y = 80;
		int y2 = 160;

		for(int i = 0; i <= 9; i++) {
			gc.strokeLine(x, y, x2, y2);
			x += 16;
			x2 = x;
			y -= 4;
			y2 -= 12;
		}
	}
}
