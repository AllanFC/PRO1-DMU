package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Kamp;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administration of player participation");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Kamp> lvwMatches = new ListView<>();
    private final TextField txfPlace = new TextField();
    //private final TextField txfDate = new TextField();
    private final DatePicker datePicker = new DatePicker();
    private final TextField txfTime = new TextField();
    private ArrayList<Kamp> matches = new ArrayList<>(Storage.getMatches());

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblMatches = new Label("Matches");
        pane.add(lblMatches, 0,0);

        pane.add(lvwMatches, 0,1, 1,5);
        lvwMatches.setPrefWidth(200);
        lvwMatches.setPrefHeight(200);
        Collections.sort(matches);
        lvwMatches.getItems().setAll(matches);
        ChangeListener<Kamp> listener = (ov, o, n) -> this.updateControls();
        lvwMatches.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwMatches.getSelectionModel().select(0);



        Label lblPlace = new Label("Place:");
        pane.add(lblPlace, 1,0);

        pane.add(txfPlace, 2, 0,2,1);

        Label lblDate = new Label("Date:");
        pane.add(lblDate, 1,1);

        //pane.add(txfDate, 2, 1,2,1);
        pane.add(datePicker, 2, 1,2,1);

        Label lblTime = new Label("Time:");
        pane.add(lblTime, 1,2);

        pane.add(txfTime, 2,2,2,1);

        Button btnCreate = new Button("Create");
        pane.add(btnCreate, 2, 3);
        btnCreate.setOnAction(event -> this.createMatch());

        Button btnUpdate = new Button("Update");
        pane.add(btnUpdate, 3, 3);
        btnUpdate.setOnAction(event -> this.updateMatch());

        Button btnFile = new Button("Make file");
        pane.add(btnFile, 2, 4);
        btnFile.setOnAction(event -> this.createFile());
    }

    public void updateControls(){
        Kamp match = lvwMatches.getSelectionModel().getSelectedItem();

        if(match != null){
            txfPlace.setText(match.getPlace());
            //txfDate.setText(match.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            datePicker.setValue(match.getDate());
            txfTime.setText(match.getTime().toString());
        }else{
            txfPlace.clear();
            //txfDate.clear();
            datePicker.setValue(null);
            txfTime.clear();
        }
        if(!lvwMatches.getItems().containsAll(Storage.getMatches())) {
            matches = Storage.getMatches();
            Collections.sort(matches);
            lvwMatches.getItems().setAll(matches);
        }
    }

    public void createMatch(){
        String place = txfPlace.getText().trim();
        LocalDate date = datePicker.getValue();
        String[] arrOfTime = txfTime.getText().trim().split(":");
        int hour = Integer.parseInt(arrOfTime[0]);
        int minute = Integer.parseInt(arrOfTime[1]);
        LocalTime time = LocalTime.of(hour, minute);
        Controller.createMatch(place, date, time);
        updateControls();
    }

    public void updateMatch(){
        Kamp match = lvwMatches.getSelectionModel().getSelectedItem();

        if(match != null){
            match.setPlace(txfPlace.getText().trim());
            match.setDate(datePicker.getValue());
            String[] arrOfTime = txfTime.getText().trim().split(":");
            int hour = Integer.parseInt(arrOfTime[0]);
            int minute = Integer.parseInt(arrOfTime[1]);
            match.setTime(LocalTime.of(hour, minute));
            lvwMatches.getSelectionModel().select(lvwMatches.getEditingIndex());
        }
    }

    public void createFile(){
        Kamp match = lvwMatches.getSelectionModel().getSelectedItem();

        if(match != null){
            match.spillerHonorar("salary for " + match.getPlace());
        }
    }
}
