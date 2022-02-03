package Opgave03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Opgave03");
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
        Circle face = new Circle(200, 200, 100);
        pane.getChildren().add(face);
        face.setFill(null);
        face.setStroke(Color.BLACK);

        Circle eyeLeft = new Circle(180, 180, 10);
        pane.getChildren().add(eyeLeft);
        eyeLeft.setFill(null);
        eyeLeft.setStroke(Color.BLACK);

        Circle eyeRight = new Circle(220, 180, 10);
        pane.getChildren().add(eyeRight);
        eyeRight.setFill(null);
        eyeRight.setStroke(Color.BLACK);

        //Line
        Line mouth = new Line(170, 215, 230, 215);
        pane.getChildren().add(mouth);
    }
}
