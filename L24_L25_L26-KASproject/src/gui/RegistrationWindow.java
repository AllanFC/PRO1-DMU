package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegistrationWindow extends Stage {

    private final Conference conference;
    private Hotel hotel;

    private Registration registration;

    public RegistrationWindow(String title, Conference conference) {
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

    // Participant information
    private final TextField txfName = new TextField();
    private final TextField txfAddress = new TextField();
    private final TextField txfCountry = new TextField();
    private final TextField txfPhoneNr = new TextField();
    private final TextField txfCorporation = new TextField();
    private final TextField txfCorporationNr = new TextField();
    private final CheckBox cbxSpeaker = new CheckBox();

    // Companion information
    private final CheckBox cbxCompanion = new CheckBox();
    private final TextField txfCompanionName = new TextField();
    private final ArrayList<CheckBox> cbxExcursionList = new ArrayList<>();
    private final ArrayList<Excursion> excursions = new ArrayList<>();
    // Hotels
    private final CheckBox cbxHotel = new CheckBox();
    private final ListView<Hotel> lvwHotels = new ListView<>();
    private VBox vbxServices = new VBox(10);
    private VBox vbx = new VBox();
    private final CheckBox cbxWifi = new CheckBox("WIFI");
    private final CheckBox cbxMad = new CheckBox("Food");
    private final CheckBox cbxBad = new CheckBox("Bath");
    private final ArrayList<CheckBox> checkedServices = new ArrayList<>();
    private DatePicker startDatePicker = new DatePicker();
    private DatePicker endDatePicker = new DatePicker();


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPrefWidth(475);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name*:");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 1, 0);

        Label lblAddress = new Label("Address*:");
        pane.add(lblAddress, 0, 1);
        pane.add(txfAddress, 1, 1);

        Label lblCountry = new Label("Country*:");
        pane.add(lblCountry, 0, 2);
        pane.add(txfCountry, 1, 2);

        Label lblPhoneNr = new Label("Phone nr*:");
        pane.add(lblPhoneNr, 0, 3);
        pane.add(txfPhoneNr, 1, 3);

        Label lblCorporation = new Label("Corporation name:");
        pane.add(lblCorporation, 0, 4);
        pane.add(txfCorporation, 1, 4);

        Label lblCorporationNr = new Label("Corporation phone nr:");
        pane.add(lblCorporationNr, 0, 5);
        pane.add(txfCorporationNr, 1, 5);

        Label lblStart = new Label("Arrival date");
        pane.add(lblStart, 0, 6);
        pane.add(startDatePicker, 1, 6);
        startDatePicker.setValue(conference.getStartDate().toLocalDate());

        Label lblEnd = new Label("Departure date");
        pane.add(lblEnd, 0, 7);
        pane.add(endDatePicker, 1, 7);
        endDatePicker.setValue(conference.getEndDate().toLocalDate());

        pane.add(cbxSpeaker, 0, 8);
        cbxSpeaker.setText("Speaker");

        // Companion information
        pane.add(cbxCompanion, 0, 9);
        cbxCompanion.setText("Companion");

        Label lblCompanionName = new Label("Companion name:");
        pane.add(lblCompanionName, 0, 10);
        pane.add(txfCompanionName, 1, 10);
        txfCompanionName.setDisable(true);

        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> this.selectedCompanionChanged(newValue);
        cbxCompanion.selectedProperty().addListener(listener);

        Label lblExcursions = new Label("Excursions");
        pane.add(lblExcursions, 0, 11);
        pane.add(vbx, 0, 12);
        for (Excursion e : Controller.getExcursionsOfConference(conference)) {
                CheckBox cbxExcursions = new CheckBox();
                vbx.getChildren().add(cbxExcursions);
                cbxExcursions.setText(e.toString());
                cbxExcursionList.add(cbxExcursions);
                excursions.add(e);
        }
        vbx.setDisable(true);

        pane.add(cbxHotel, 0, 13);
        cbxHotel.setText("I want to register with a hotel");
        ChangeListener<Boolean> listener1 = (ov, oldValue, newValue) -> this.selectedHotelChanged(newValue);
        cbxHotel.selectedProperty().addListener(listener1);

        pane.add(lvwHotels, 0, 14, 1,6);
        lvwHotels.setPrefHeight(190);
        lvwHotels.getItems().addAll(Controller.getHotelsOfConference(conference));
        lvwHotels.setDisable(true);
        ChangeListener<Hotel> listener2 = (ov, o, n) -> this.updateControls();
        lvwHotels.getSelectionModel().selectedItemProperty().addListener(listener2);


        Label lblServices = new Label("Services");
        pane.add(lblServices, 1, 13);
        pane.add(vbxServices, 1, 14);
        vbxServices.getChildren().add(cbxWifi);
        cbxWifi.setVisible(false);
        vbxServices.getChildren().add(cbxMad);
        cbxMad.setVisible(false);
        vbxServices.getChildren().add(cbxBad);
        cbxBad.setVisible(false);
        checkedServices.add(cbxWifi);
        checkedServices.add(cbxBad);
        checkedServices.add(cbxMad);

        vbxServices.setDisable(true);

        Button btnRegister = new Button("Register");
        pane.add(btnRegister, 0, 20);
        btnRegister.setOnAction(event -> this.registerAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 20);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

    private void updateControls() {
        cbxWifi.setVisible(false);
        cbxMad.setVisible(false);
        cbxBad.setVisible(false);
        selectedHotel();
    }

    private void selectedCompanionChanged(boolean checked) {
        txfCompanionName.setDisable(!checked);
        vbx.setDisable(!checked);

    }

    private void selectedHotelChanged(boolean checked) {
        lvwHotels.setDisable(!checked);
        vbxServices.setDisable(!checked);
    }

    private void selectedHotel() {
        hotel = lvwHotels.getSelectionModel().getSelectedItem();
        for (Service e : Controller.getServiceOfHotel(hotel)) {
            if(e.getName().equalsIgnoreCase(cbxWifi.getText())){
                cbxWifi.setVisible(true);
                if(e.getPrice() == 0){
                    cbxWifi.setSelected(true);
                    cbxWifi.setDisable(true);
                } else{
                    cbxWifi.setSelected(false);
                    cbxWifi.setDisable(false);
                }
            } else if (e.getName().equalsIgnoreCase(cbxMad.getText())) {
                cbxMad.setVisible(true);
                if(e.getPrice() == 0){
                    cbxMad.setSelected(true);
                    cbxMad.setDisable(true);
                } else{
                    cbxMad.setSelected(false);
                    cbxMad.setDisable(false);
                }
            } else if (e.getName().equalsIgnoreCase(cbxBad.getText())) {
                cbxBad.setVisible(true);
                if(e.getPrice() == 0){
                    cbxBad.setSelected(true);
                    cbxBad.setDisable(true);
                } else{
                    cbxBad.setSelected(false);
                    cbxBad.setDisable(false);
                }
            }
        }
    }

    private void registerAction() {
        String name = txfName.getText().trim();
        String address = txfAddress.getText().trim();
        String country = txfCountry.getText().trim();
        String phoneNr = txfPhoneNr.getText().trim();
        String corporation = txfCorporation.getText().trim();
        String corporationNr = txfCorporationNr.getText().trim();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();


        Participant participant = Controller.createParticipant(name, address, country,
                phoneNr, corporation, corporationNr);

        if(cbxHotel.isSelected()){
            registration = Controller.createRegistration(participant, conference, startDate, endDate, hotel);
            ArrayList<Service> services = new ArrayList<>(Controller.getServiceOfHotel(hotel));
            ArrayList<Service> selectedServices = new ArrayList<>();
            for (int i = 0; i < checkedServices.size(); i++) {
                if(checkedServices.get(i).isSelected()){
                    selectedServices.add(services.get(i));
                }
            }
            Controller.addServicesToRegistration(registration, selectedServices);
        } else {
            registration = Controller.createRegistration(participant, conference, startDate, endDate, null);
        }
        if(cbxSpeaker.isSelected()){
            Controller.registerSpeaker(registration);
        }
        if (cbxCompanion.isSelected()) {
            String companionName = txfCompanionName.getText().trim();
            Companion companion = Controller.CreateCompanion(companionName, registration);
            for (int i = 0; i < cbxExcursionList.size(); i++) {
                if(cbxExcursionList.get(i).isSelected()){
                    Controller.addCompanionToExcursion(companion, excursions.get(i));
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Receipt for registration");
        alert.setHeaderText(null);
        alert.setContentText("Your total price for registration is " + Controller.totalPrice(registration) + " Kr.");
        alert.showAndWait();
        this.hide();
    }

    public void cancelAction(){
        this.hide();
    }
}
