package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Conference;

public class OverviewPane extends GridPane {

    private final ListView<Conference> lvwConferences = new ListView<>();
    private final TextArea txaHotels = new TextArea();
    private final TextArea txaParticipants = new TextArea();
    private final TextArea txaExcursions = new TextArea();

    public OverviewPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.add(lvwConferences, 0,0);
        lvwConferences.setPrefHeight(200);
        lvwConferences.setPrefWidth(225);
        lvwConferences.getItems().setAll(Controller.getConferences());
        if(!lvwConferences.getItems().isEmpty()){
            lvwConferences.getSelectionModel().select(0);
            updateControls();
        }

        ChangeListener<Conference> listener = (ov, o, n) -> this.selectedConferenceChanged();
        lvwConferences.getSelectionModel().selectedItemProperty().addListener(listener);

        this.add(txaHotels, 0,1);
        txaHotels.setPrefHeight(200);
        txaHotels.setPrefWidth(225);
        txaHotels.setEditable(false);

        this.add(txaParticipants, 1,0);
        txaParticipants.setPrefHeight(200);
        txaParticipants.setPrefWidth(225);
        txaParticipants.setEditable(false);

        this.add(txaExcursions,1,1);
        txaExcursions.setPrefHeight(200);
        txaExcursions.setPrefWidth(225);
        txaExcursions.setEditable(false);

    }

// -------------------------------------------------------------------------------------------------

    private void selectedConferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        if(!lvwConferences.getItems().containsAll(Controller.getConferences())) {
            lvwConferences.getItems().setAll(Controller.getConferences());
        }
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();

        if(conference != null){
            StringBuilder sb = new StringBuilder();
            for (String e : Controller.listOfHotelsForConference(conference)){
                sb.append(e);
            }
            txaHotels.setText(sb.toString());
            sb = new StringBuilder();
            for (String e : conference.listOfParticipants()){
                sb.append(e);
            }
            txaParticipants.setText(sb.toString());
            sb = new StringBuilder();
            for (String e : conference.listOfExcursions()){
                sb.append(e);
            }
            txaExcursions.setText(sb.toString());
        }else {
            txaExcursions.clear();
            txaParticipants.clear();
            txaHotels.clear();
        }
    }


}
