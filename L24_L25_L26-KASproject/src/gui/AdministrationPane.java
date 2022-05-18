package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Conference;

public class AdministrationPane extends GridPane {

    private final ListView<Conference> lvwConferences = new ListView<>();
    private final TextArea txaHotels = new TextArea();
    private final TextArea txaExcursions = new TextArea();

    public AdministrationPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        // Conference
        GridPane conferencePane = new GridPane();
        this.add(conferencePane, 0, 0);
        conferencePane.setPadding(new Insets(10));
        conferencePane.setHgap(10);
        conferencePane.setVgap(10);
        conferencePane.add(lvwConferences, 0,1,1,2);
        lvwConferences.setPrefHeight(200);
        lvwConferences.setPrefWidth(200);
        lvwConferences.getItems().setAll(Controller.getConferences());
        if(!lvwConferences.getItems().isEmpty()){
            lvwConferences.getSelectionModel().select(0);
            updateControls();
        }

        ChangeListener<Conference> listener = (ov, o, n) -> this.selectedConferenceChanged();
        lvwConferences.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnCreateConference = new Button("Create Conference");
        conferencePane.add(btnCreateConference, 0, 3);
        btnCreateConference.setOnAction(event -> createConferenceAction());

        Button btnHotelToConference = new Button("Conference Hotels");
        conferencePane.add(btnHotelToConference, 0, 4);
        btnHotelToConference.setOnAction(event -> hotelToConferenceAction());
//------------------------------------------------------------------------------------------------------

        // Hotel
        GridPane hotelPane = new GridPane();
        this.add(hotelPane, 1, 0);
        hotelPane.setPadding(new Insets(10));
        hotelPane.setHgap(10);
        hotelPane.setVgap(10);
        hotelPane.add(txaHotels, 0,1,1,3);
        txaHotels.setPrefHeight(200);
        txaHotels.setPrefWidth(200);
        txaHotels.setEditable(false);

        Button btnCreateHotel = new Button("Create Hotel");
        hotelPane.add(btnCreateHotel, 0, 4);
        btnCreateHotel.setOnAction(event -> createHotelAction());

//------------------------------------------------------------------------------------------------------

        // Excursions
        GridPane excursionsPane = new GridPane();
        this.add(excursionsPane, 2, 0);
        excursionsPane.setPadding(new Insets(10));
        excursionsPane.setHgap(10);
        excursionsPane.setVgap(10);
        excursionsPane.add(txaExcursions, 0,1,1,3);
        txaExcursions.setPrefHeight(200);
        txaExcursions.setPrefWidth(200);
        txaExcursions.setEditable(false);

        Button btnCreateExcursion = new Button("Create Excursion");
        excursionsPane.add(btnCreateExcursion, 0, 4);
        btnCreateExcursion.setOnAction(event -> createExcursionAction());
    }

// -------------------------------------------------------------------------------------------------

    public void updateControls(){
        StringBuilder sb = new StringBuilder();
        for(Conference e : Controller.getConferences()){
            sb.append(e.getName()).append(":\n");
            for(String str : e.listOfExcursions()){
                sb.append("  ").append(str).append("\n");
            }
        }
        txaExcursions.setText(sb.toString());
        sb = new StringBuilder();
        for (String e : Controller.listOfHotels()){
            sb.append(e);
        }
        txaHotels.setText(sb.toString());
        if(!lvwConferences.getItems().containsAll(Controller.getConferences())){
            lvwConferences.getItems().setAll(Controller.getConferences());
        }
    }

    public void selectedConferenceChanged(){
        updateControls();
    }

    private void createHotelAction() {
        CreateHotelWindow dialog = new CreateHotelWindow("Create a new hotel");
        dialog.showAndWait();
        updateControls();
    }

    public void hotelToConferenceAction(){
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if(conference != null){
            HotelToConferenceWindow dialog = new HotelToConferenceWindow("Add hotels to " + conference, conference);
            dialog.showAndWait();
        }
    }

    private void createConferenceAction(){
        CreateConferenceWindow dialog = new CreateConferenceWindow("Create a new conference");
        dialog.showAndWait();
        updateControls();
    }

    private void createExcursionAction(){
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if(conference != null){
            CreateExcursionWindow dialog = new CreateExcursionWindow("Create a new excursion for " + conference.getName(), conference);
            dialog.showAndWait();
            updateControls();
        }
    }
}
