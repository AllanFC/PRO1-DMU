package Exercise01;

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
        stage.setTitle("Exercise01");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txtfFirstName = new TextField();
    private final TextField txtfLastName = new TextField();
    private final TextField txtfFullName = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblFirstName = new Label("First name:");
        pane.add(lblFirstName, 0, 0);

        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName, 1, 0);

        Label lblName = new Label("Full name:");
        pane.add(lblName, 0, 2);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
//        TextField txfName = new TextField();
//        txfName = new TextField();
        pane.add(txtfFirstName, 0, 1);

        pane.add(txtfLastName, 1, 1);

        pane.add(txtfFullName, 0,3, 2, 1);
        txtfFullName.setEditable(false);

        Button btnCombine = new Button("Combine");
        pane.add(btnCombine, 1, 4);

        // connect a method to the button
        btnCombine.setOnAction(event -> this.combineNameAction());
    }

    // -------------------------------------------------------------------------

    private void combineNameAction() {
        String firstName = txtfFirstName.getText().trim();
        String lastName = txtfLastName.getText().trim();
        txtfFullName.setText(firstName + " " + lastName);
    }
}
