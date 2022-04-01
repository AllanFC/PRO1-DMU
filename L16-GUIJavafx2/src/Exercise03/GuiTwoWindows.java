package Exercise03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuiTwoWindows extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personWindow = new PersonInputWindow("Person Information", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private PersonInputWindow personWindow;

    private void initContent(GridPane pane) {
        this.initPersons();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Persons:");
        pane.add(lblName, 0, 0);

        pane.add(lvwPersons, 0, 1, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        Button btnAddPerson = new Button("Add person");
        pane.add(btnAddPerson, 2, 1);
        btnAddPerson.setOnAction(event -> this.addPersonAction());

    }

    // -----------------------------------------------------
    // Button action

    private void addPersonAction() {
        personWindow.showAndWait();

        if (personWindow.getActualPerson() != null) {
            Person person = personWindow.getActualPerson();
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void initPersons() {
        persons.add(new Person("Jens Jensen", "Lærer", true));
        persons.add(new Person("Hans Hansen", "Sekretær", true));
        persons.add(new Person("Pia Peters", "Sælger",  false));
    }
}
