package Figurer03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Figurer03");
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
        Circle sun = new Circle(300, 100, 50);
        pane.getChildren().add(sun);
        sun.setFill(Color.YELLOW);
        sun.setStroke(Color.BLACK);

        //Rectangle
        Rectangle house = new Rectangle(60, 210, 150, 160);
        pane.getChildren().add(house);
        house.setFill(Color.RED);

        Rectangle window = new Rectangle(80, 230, 55, 55);
        pane.getChildren().add(window);

        Rectangle chimney = new Rectangle(170, 100, 30, 80);
        pane.getChildren().add(chimney);
        chimney.setFill(Color.BROWN);

        //Polygon
        Polygon roof = new Polygon(40, 210, 135, 100, 230, 210);
        pane.getChildren().add(roof);
        roof.setFill(Color.GREEN);

        //Line
        Line ground = new Line(20, 370, 380, 370);
        pane.getChildren().add(ground);
    }
}
