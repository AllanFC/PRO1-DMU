package Exercise01;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 01");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfJob = new TextField();
    private final CheckBox checkBox = new CheckBox();

    private void initContent(GridPane pane) {
        this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblJob = new Label("Job:");
        pane.add(lblJob, 0, 1);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);


        checkBox.setText("Senior");
        pane.add(checkBox, 1, 2);

        pane.add(txfName, 1, 0, 2, 1);

        pane.add(txfJob, 1, 1, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);


        Button btnAdd = new Button("Add person");
        pane.add(btnAdd, 6, 2);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());


    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        String job = txfJob.getText().trim();
        if (name.length() > 0) {
            Person p = new Person(name, job, checkBox.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        }
    }


    private void initPersons() {
        persons.add(new Person("Jens Jensen", "Lærer", true));
        persons.add(new Person("Hans Hansen", "Sekretær", true));
        persons.add(new Person("Pia Peters", "Sælger",  false));
    }

}
