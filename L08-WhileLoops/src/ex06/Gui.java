package ex06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Exercise 6");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		// base axis
		gc.strokeLine(5, 175, 195, 175);
		// ending arrow
		gc.strokeLine(195, 175, 195 - 4, 175 - 4);
		gc.strokeLine(195, 175, 195 - 4, 175 + 4);

		int x = 15;
		int y = 170;
		int x2 = x;
		int y2 = 180;
		int i = 0;

		while(i < 11){
			if(i == 0 || i == 5 || i == 10) {
				gc.strokeLine(x, y - 3, x2, y2 + 3);
				String s = "" + i;
				gc.fillText(s, x - 3, y2 + 13);
			} else {
				gc.strokeLine(x, y, x2, y2);
			}
			x += 17;
			x2 = x;
			i++;
		}
	}
}
