package Exercise04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise04");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txtfCelcius = new TextField();
    private final TextField txtfFahrenheit = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblFirstName = new Label("Celcius:");
        pane.add(lblFirstName, 0, 0);

        Label lblLastName = new Label("Fahrenheit:");
        pane.add(lblLastName, 1, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
//        TextField txfName = new TextField();
//        txfName = new TextField();
        pane.add(txtfCelcius, 0, 1);

        pane.add(txtfFahrenheit, 1, 1);

        Button btnConvert = new Button("Convert");
        pane.add(btnConvert, 0, 2);

        // connect a method to the button
        btnConvert.setOnAction(event -> this.ConvertAction());
    }

    // -------------------------------------------------------------------------

    private void ConvertAction() {
        if(txtfCelcius.getText().trim().isEmpty()){
            double celcius = (Double.parseDouble(txtfFahrenheit.getText().trim()) - 32)/1.8;
            txtfCelcius.setText("" + celcius);
        } else if(txtfFahrenheit.getText().trim().isEmpty()){
            double fahrenheit = 1.8 * Double.parseDouble(txtfCelcius.getText().trim()) + 32;
            txtfFahrenheit.setText("" + fahrenheit);
        }
    }
}
