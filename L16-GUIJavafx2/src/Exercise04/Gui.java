package Exercise04;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Names:");
        pane.add(lblName, 0, 0);

        // add a label to the pane (at col=0, row=1)
        Label lblNames = new Label("Name:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 1);

        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwNames, 1, 0);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);

        this.initNames();
        lvwNames.getItems().setAll(this.initNames());

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 2);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());
    }

    // -------------------------------------------------------------------------

    private ArrayList<String> initNames() {
        names.add("Bo");
        names.add("Bob");
        names.add("James");
        names.add("Mads");
        names.add("Lars");
        names.add("Karsten");
        names.add("Henrik");
        names.add("Kasper");
        names.add("Lucas");
        return names;
    }

    private void addAction(){
        String name = txfName.getText().trim();
        if(name.length() > 0){
            names.add(name);
            lvwNames.getItems().setAll(names);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add name");
            alert.setHeaderText("No name entered");
            alert.setContentText("Enter a name");
            alert.show();
        }

    }


}
