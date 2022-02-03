package Opgave05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Opgave05");
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
        Circle blue = new Circle(100, 100, 30);
        pane.getChildren().add(blue);
        blue.setFill(null);
        blue.setStroke(Color.BLUE);

        Circle black = new Circle(160, 100, 30);
        pane.getChildren().add(black);
        black.setFill(null);
        black.setStroke(Color.BLACK);

        Circle red = new Circle(220, 100, 30);
        pane.getChildren().add(red);
        red.setFill(null);
        red.setStroke(Color.RED);

        Circle yellow = new Circle(130, 130, 30);
        pane.getChildren().add(yellow);
        yellow.setFill(null);
        yellow.setStroke(Color.YELLOW);

        Circle green = new Circle(190, 130, 30);
        pane.getChildren().add(green);
        green.setFill(null);
        green.setStroke(Color.GREEN);


    }
}
