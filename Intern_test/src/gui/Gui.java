package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;


public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Title");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //--------------------------------------------------------
    private ListView<Medarbejder> lvwWorkers = new ListView();
    private ListView<Vagt> lvwShifts = new ListView<>();
    private TextArea txaChosenShift = new TextArea();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblWorker = new Label("Alle Medarbejdere");
        pane.add(lblWorker, 0,0);
        pane.add(lvwWorkers, 0,1);
        lvwWorkers.getItems().setAll(Storage.getWorkers());

        Label lblShifts = new Label("Alle Vagter");
        pane.add(lblShifts, 1,0);
        pane.add(lvwShifts,1,1);
        lvwShifts.getItems().setAll(Storage.getShifts());

        ChangeListener<Vagt> listener = (ov, o, n) -> this.updateControls();
        lvwShifts.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblChosenShift = new Label("Valgt vagt");
        pane.add(lblChosenShift, 2,0);
        pane.add(txaChosenShift, 2,1);
        txaChosenShift.setEditable(false);

        Button btnTildelVagt = new Button("Tildel Vagt");
        pane.add(btnTildelVagt, 1, 2);
        btnTildelVagt.setOnAction(event -> tildelVagtAction());

        Button btnUdskrivVagt = new Button("Udskriv vagt til fil");
        pane.add(btnUdskrivVagt, 2, 2);
        btnUdskrivVagt.setOnAction(event -> udskrivVagtAction());
    }

    //--------------------------------------------------------

    private void udskrivVagtAction() {
        Vagt shift = lvwShifts.getSelectionModel().getSelectedItem();

        Controller.udskrivVagtplan(shift, shift.getNavn());
    }

    private void tildelVagtAction() {
        Vagt shift = lvwShifts.getSelectionModel().getSelectedItem();
        Medarbejder worker = lvwWorkers.getSelectionModel().getSelectedItem();

        if(Controller.takeShift(worker,shift) != null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tildel vagt");
            alert.setHeaderText("Vagt kan ikke tildeles");
            alert.setContentText("" + worker.getNavn() + " har en overlappende vagt");
            alert.showAndWait();
        } else {
            Controller.takeShift(worker, shift);
        }
        updateControls();

    }

    private void updateControls() {
        Vagt shift = lvwShifts.getSelectionModel().getSelectedItem();

        if(shift != null){
            StringBuilder sb = new StringBuilder();
            sb.append("Navn: " + shift.getNavn() + "\n");
            sb.append("Fra: " + shift.getTidFraFormatted() + "\n");
            sb.append("Til: " + shift.getTidTilFormatted() + "\n");
            sb.append("Status: " + shift.status() + "\n");
            sb.append("Tilknyttede medarbejdere:\n");
            for(Medarbejder e : shift.getWorkers()){
                sb.append(e.getNavn() + " ");
            }
            txaChosenShift.setText(sb.toString());
        }
    }
}
