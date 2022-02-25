package ex03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
	private int screenWidth = 600;
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
		int x;
		int y;
		int x2;
		int y2;
		// separates assignments
		x = screenWidth / 3;
		x2 = x;
		y = 0;
		y2 = screenHeight;
		while(x <= 400){
			gc.strokeLine(x, y, x2, y2);
			x += screenWidth / 3;
			x2 = x;
		}

		// Figur 1
		x = 20;
		x2 = x;
		y = 10;
		y2 = 180;
		while(x2 <= 180) {
			gc.strokeLine(x, y, x2, y2);
			x += 40;
			x2 = x;
		}

		// Figur 2
		x = 20 + screenWidth / 3;
		x2 = 180 + screenWidth / 3;
		y = 20;
		y2 = y;
		while(y2 <= 180) {
			gc.strokeLine(x, y, x2, y2);
			y += 40;
			y2 = y;
		}

		// Figur 3
		x = 85 + screenWidth / 3 * 2;
		x2 = 115 + screenWidth / 3 * 2;
		y = 20;
		y2 = y;
		while(y2 <= 180) {
			gc.strokeLine(x, y, x2, y2);
			y += 40;
			y2 = y;
			x -= 15;
			x2 += 15;
		}
	}
}
