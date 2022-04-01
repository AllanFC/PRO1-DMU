package Exercise02;

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
        stage.setTitle("Exercise02");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txtfNumber = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblFirstName = new Label("Number:");
        pane.add(lblFirstName, 0, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
//        TextField txfName = new TextField();
//        txfName = new TextField();
        pane.add(txtfNumber, 1, 1);
        txtfNumber.setPrefColumnCount(4);

        Button btnIncrease = new Button("Inc");
        pane.add(btnIncrease, 2, 1);
        GridPane.setMargin(btnIncrease, new Insets(35, 0, 0, 0));

        // connect a method to the button
        btnIncrease.setOnAction(event -> this.increaseNumberAction());


        Button btnDecrease = new Button("Dec");
        pane.add(btnDecrease, 2, 1);
        GridPane.setMargin(btnDecrease, new Insets(0, 0, 35, 0));

        // connect a method to the button
        btnDecrease.setOnAction(event -> this.decreaseNumberAction());

    }

    // -------------------------------------------------------------------------

    private void increaseNumberAction() {
        int number = Integer.parseInt(txtfNumber.getText().trim()) + 1;
        txtfNumber.setText("" + number);
    }
    private void decreaseNumberAction() {
        int number = Integer.parseInt(txtfNumber.getText().trim()) - 1;
        txtfNumber.setText("" + number);
    }
}
