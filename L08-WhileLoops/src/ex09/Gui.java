package ex09;

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
		int x = 180;
		int x2 = x;
		int y = 65;
		int y2 = 190;

		while(x > 5) {
			gc.strokeLine(x, y, x2, y2);
			y += (x-x*0.75)/5;
			y2 -= (x-x*0.75)/2;
			x *= 0.75;
			x2 = x;
		}
	}
}
