package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Conference;
import model.Hotel;

import java.util.ArrayList;

public class HotelToConferenceWindow extends Stage {
    private final Conference conference;

    public HotelToConferenceWindow(String title, Conference conference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.conference = conference;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final ListView<Hotel> lvwHotels = new ListView<>();
    private final ListView<Hotel> lvwAddedHotels = new ListView<>();
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    private final ArrayList<Hotel> addedHotels = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblAllCustomers = new Label("Available Hotels");
        pane.add(lblAllCustomers, 2,0);

        Label lblAddedCustomers = new Label(conference + " Hotels");
        pane.add(lblAddedCustomers, 0,0);

        hotels.addAll(Controller.getHotels());
        addedHotels.addAll(Controller.getHotelsOfConference(conference));

        pane.add(lvwHotels, 2, 1, 1, 4);
        lvwHotels.setPrefWidth(200);
        lvwHotels.setPrefHeight(200);
        for(Hotel e : addedHotels){
            hotels.remove(e);
        }
        lvwHotels.getItems().setAll(hotels);

        pane.add(lvwAddedHotels, 0, 1, 1, 4);
        lvwAddedHotels.setPrefWidth(200);
        lvwAddedHotels.setPrefHeight(200);
        lvwAddedHotels.getItems().setAll(addedHotels);

        Button btnAdd = new Button("<<");
        pane.add(btnAdd, 1,2);
        btnAdd.setOnAction(event -> this.addAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 2, 5);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 2, 5);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        ArrayList<Hotel> conferenceHotels = new ArrayList<>(Controller.getHotelsOfConference(conference));
        for(Hotel e : addedHotels){
            if(!conferenceHotels.contains(e)){
                Controller.addHotelToConference(e, conference);
            }
        }

        this.hide();
    }

    private void addAction(){
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if(hotel != null) {
            addedHotels.add(hotel);
            hotels.remove(hotel);
        }

        updateControls();
    }

    private void updateControls(){
        lvwHotels.getItems().setAll(hotels);
        lvwAddedHotels.getItems().setAll(addedHotels);
    }
}
