package Figurer02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Figurer02");
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
        int xCoordinate = 100;
        Color Yellow = Color.YELLOW;

        //Circle
        Circle circle = new Circle(xCoordinate, 100, 40);
        pane.getChildren().add(circle);
        circle.setFill(Yellow);

        //Rectangle
        Rectangle rectangle = new Rectangle(xCoordinate, 150, 80, 40);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Yellow);

        //Line
        Line line = new Line(xCoordinate, 60, 100, 190);
        pane.getChildren().add(line);
        line.setStroke(Yellow);

    }
}
