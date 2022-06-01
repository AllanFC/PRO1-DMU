package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Conference;
import model.Excursion;
import model.Hotel;
import model.Service;

public class ConferencePane extends GridPane {

    private final ListView<Conference> lvwConferences = new ListView<>();
    private final TextField txfLocation = new TextField();
    private final TextField txfPrice = new TextField();
    private final TextField txfStartDate = new TextField();
    private final TextField txfEndDate = new TextField();
    private final ListView<Hotel> lvwHotels = new ListView<>();
    private final ListView<Service> lvsServices = new ListView<>();
    private final ListView<Excursion> lvwExcursions = new ListView<>();

    public ConferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.add(lvwConferences, 0, 1, 1, 5);
        lvwConferences.setPrefHeight(200);
        lvwConferences.setPrefWidth(200);
        lvwConferences.getItems().setAll(Controller.getConferences());

        ChangeListener<Conference> listener = (ov, o, n) -> this.selectedConferenceChanged();
        lvwConferences.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblLocation = new Label("Location:");
        this.add(lblLocation, 1, 1);
        this.add(txfLocation, 2, 1);
        txfLocation.setEditable(false);

        Label lblPrice = new Label("Price per day:");
        this.add(lblPrice, 1, 2);
        this.add(txfPrice, 2, 2);
        txfPrice.setEditable(false);

        Label lblStartDate = new Label("Start date:");
        this.add(lblStartDate, 1, 3);
        this.add(txfStartDate, 2, 3);
        txfStartDate.setEditable(false);

        Label lblEndDate = new Label("End date:");
        this.add(lblEndDate, 1, 4);
        this.add(txfEndDate, 2, 4);
        txfEndDate.setEditable(false);

        Button btnRegistration = new Button("Register for Conference");
        this.add(btnRegistration, 0, 6);
        GridPane.setHalignment(btnRegistration, HPos.CENTER);
        btnRegistration.setOnAction(event -> this.registerConferenceAction());
    }




// -------------------------------------------------------------------------------------------------

    private void registerConferenceAction() {
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if(conference != null){
            RegistrationWindow dialog = new RegistrationWindow("Register to " + conference, conference);
            dialog.showAndWait();
        }
    }
    private void selectedConferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        if(!lvwConferences.getItems().containsAll(Controller.getConferences())) {
            lvwConferences.getItems().setAll(Controller.getConferences());
        }
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if (conference != null) {
            txfLocation.setText(conference.getLocation());
            txfPrice.setText("" + conference.getPrice());
            txfStartDate.setText(conference.getStartDateFormatted());
            txfEndDate.setText(conference.getEndDateFormatted());
        }
        else {
            txfLocation.clear();
            txfPrice.clear();
            txfStartDate.clear();
            txfEndDate.clear();
        }
    }
}
