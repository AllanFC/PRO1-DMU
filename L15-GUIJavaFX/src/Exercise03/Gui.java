package Exercise03;

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
        stage.setTitle("Exercise03");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txtfInvestment = new TextField();
    private final TextField txtfYears = new TextField();
    private final TextField txtfInterest = new TextField();
    private final TextField txtfFuture = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblInvestment = new Label("Investment:");
        pane.add(lblInvestment, 0, 0);

        Label lblYears = new Label("Years:");
        pane.add(lblYears, 0, 1);

        Label lblInterest = new Label("Interest (%):");
        pane.add(lblInterest, 0, 2);

        Label lblFuture = new Label("Future value:");
        pane.add(lblFuture, 0, 4);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
//        TextField txfName = new TextField();
//        txfName = new TextField();
        pane.add(txtfInvestment, 1, 0);

        pane.add(txtfYears, 1, 1);

        pane.add(txtfInterest, 1,2);

        pane.add(txtfFuture, 1,4);

        Button btnCombine = new Button("Calculate");
        pane.add(btnCombine, 1, 3);

        // connect a method to the button
        btnCombine.setOnAction(event -> this.calculateAction());
    }

    // -------------------------------------------------------------------------

    private void calculateAction() {
        int investment = Integer.parseInt(txtfInvestment.getText().trim());
        int years = Integer.parseInt(txtfYears.getText().trim());
        double interest = (double) Integer.parseInt(txtfInterest.getText().trim()) / 100;
        double future = investment * Math.pow((1+ interest), years);
        String total = String.format("%.2f",future);
        txtfFuture.setText(total);
    }
}
