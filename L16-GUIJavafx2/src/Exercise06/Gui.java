package Exercise06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise06");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private Slider red = new Slider(0, 255, 70);
    private Slider green = new Slider(0, 255, 70);
    private Slider blue = new Slider(0, 255, 70);
    private Label lblRGB = new Label();

    private void initContent(GridPane pane) {
        this.sliderValueChanged(pane);
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(lblRGB, 1, 0);

        Label lblRed = new Label("Red:");
        pane.add(lblRed, 0, 1);

        Label lblGreen = new Label("Green:");
        pane.add(lblGreen, 0, 2);

        Label lblBlue = new Label("Blue:");
        pane.add(lblBlue, 0, 3);

        red.valueProperty().addListener(
                event -> this.sliderValueChanged(pane));
        pane.add(red, 1, 1);

        green.valueProperty().addListener(
                event -> this.sliderValueChanged(pane));
        pane.add(green, 1, 2);

        blue.valueProperty().addListener(
                event -> this.sliderValueChanged(pane));
        pane.add(blue, 1, 3);

    }

    // -------------------------------------------------------------------------

    private void sliderValueChanged(GridPane pane){
        int r = (int) red.getValue();
        int g = (int) green.getValue();
        int b = (int) blue.getValue();
        String color = "#" + String.format("%02X", r) + String.format("%02X", g) + String.format("%02X", b);
        pane.setStyle("-fx-background: " + color + ";");
        lblRGB.setText(String.format("R: %d G: %d B: %d", r, g, b));
    }
}
