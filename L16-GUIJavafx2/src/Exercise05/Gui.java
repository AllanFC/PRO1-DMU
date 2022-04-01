package Exercise05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise05");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> boys = new ArrayList<>();
    private final ArrayList<String> girls = new ArrayList<>();
    private final RadioButton rbBoys = new RadioButton();
    private final RadioButton rbGirls = new RadioButton();



    private void initContent(GridPane pane) {
        // show or hide grid lines
        this.initBoys();
        this.initGirls();
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Names:");
        pane.add(lblName, 0, 1);

        // add a label to the pane (at col=0, row=1)
        Label lblNames = new Label("Name:");
        pane.add(lblNames, 0, 2);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 2);

        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwNames, 1, 1);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(boys);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 2);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        HBox box = new HBox();
        pane.add(box, 1, 0);

        ToggleGroup group = new ToggleGroup();
        box.getChildren().add(rbBoys);
        rbBoys.setSelected(true);
        rbBoys.setText("Boys");
        rbBoys.setToggleGroup(group);
        // set the method to execute when a radio button is selected
        rbBoys.setOnAction(event -> this.boyListAction());


        box.getChildren().add(rbGirls);
        rbGirls.setText("Girls");
        rbGirls.setToggleGroup(group);
        // set the method to execute when a radio button is selected
        rbGirls.setOnAction(event -> this.girlListAction());
    }

    // -------------------------------------------------------------------------

    private void initBoys() {
        boys.add("Bo");
        boys.add("Bob");
        boys.add("James");
        boys.add("Mads");
        boys.add("Lars");
        boys.add("Karsten");
        boys.add("Henrik");
        boys.add("Kasper");
        boys.add("Lucas");
    }

    private void initGirls() {
        girls.add("Jane");
        girls.add("Eva");
        girls.add("Lene");
        girls.add("Mette");
        girls.add("Tine");
        girls.add("Line");
        girls.add("Lone");
        girls.add("Alberte");
        girls.add("Pia");
    }

    private void boyListAction(){
        lvwNames.getItems().setAll(boys);
    }

    private void girlListAction(){
        lvwNames.getItems().setAll(girls);
    }

    private void addAction(){
        String name = txfName.getText().trim();
        if(name.length() > 0 && rbBoys.isSelected()){
            boys.add(name);
            lvwNames.getItems().setAll(boys);
        } else if (name.length() > 0 && rbGirls.isSelected()){
            girls.add(name);
            lvwNames.getItems().setAll(girls);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add name");
            alert.setHeaderText("No name entered");
            alert.setContentText("Enter a name");
            alert.show();
        }

    }


}
