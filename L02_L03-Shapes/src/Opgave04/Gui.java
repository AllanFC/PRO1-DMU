package Opgave04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Opgave04");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {

        //Circle
        Circle center = new Circle(200, 200, 30);
        pane.getChildren().add(center);

        Circle middle = new Circle(200, 200, 63);
        pane.getChildren().add(middle);
        middle.setFill(null);
        middle.setStroke(Color.BLACK);
        middle.setStrokeWidth(20);

        Circle outer = new Circle(200, 200, 105);
        pane.getChildren().add(outer);
        outer.setFill(null);
        outer.setStroke(Color.BLACK);
        outer.setStrokeWidth(20);

    }
}
