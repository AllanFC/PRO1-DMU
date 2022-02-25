package ex04;

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

		stage.setTitle("Exercise 4");
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
		int r;
		int w;
		int h;
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
		x = 100;
		y = 100;
		r = 20;
		while(r <= 100) {
			gc.strokeOval(x - r, y - r, r * 2, r * 2);
			r += 20;
		}

		// Figur 2
		x = 40 + screenWidth / 3;
		y = 100;
		r = 20;
		while(r <= 80) {
			gc.strokeOval(x - r, y - r, r * 2, r * 2);
			r += 10;
			x += 10;
		}

		// Figur 3
		x = 100 + screenWidth / 3 * 2;
		y = 100;
		h = 40;
		w = 20;
		while(w <= 100) {
			gc.strokeOval(x - w, y - h, w * 2, h * 2);
			w += 10;
		}
	}
}
