package Opgave02;

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

        stage.setTitle("Opgave02");
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

        //Rectangle
        Rectangle rectangle = new Rectangle(100, 150, 80, 40);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.DARKBLUE);

        //Text
        Text text = new Text(118, 178, "Allan");
        text.setFont(new Font(20));
        text.setFill(Color.RED);
        pane.getChildren().add(text);

    }
}
