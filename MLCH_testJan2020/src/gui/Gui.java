package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Festival;
import model.Frivillig;
import model.Job;
import model.Vagt;
import storage.Storage;

public class Gui extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Festival administration af frivillige");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Festival> lvwFestival = new ListView<>();
    private final ListView<Job> lvwJob = new ListView<>();
    private final ListView<Frivillig> lvwFrivillig = new ListView<>();
    private final TextArea txaFrivilligJobs = new TextArea();
    private final TextField txfTimer = new TextField();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblFestivaller = new Label("Festivaller");
        pane.add(lblFestivaller, 0, 0);

        pane.add(lvwFestival, 0, 1);
        lvwFestival.setPrefHeight(200);
        lvwFestival.setPrefWidth(250);
        ChangeListener<Festival> listener =
                (obs, o, n) -> this.festivalSelectionChanged();
        lvwFestival.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblJobs = new Label("Jobs");
        pane.add(lblJobs, 1, 0);

        pane.add(lvwJob, 1, 1);
        lvwJob.setPrefHeight(200);
        lvwJob.setPrefWidth(250);

        Label lblFrivillige = new Label("Frivillige");
        pane.add(lblFrivillige, 2, 0);

        pane.add(lvwFrivillig, 2, 1);
        lvwFrivillig.setPrefHeight(200);
        lvwFrivillig.setPrefWidth(250);
        ChangeListener<Frivillig> listener1 =
                (obs, o, n) -> this.frivilligSelectionChanged();
        lvwFrivillig.getSelectionModel().selectedItemProperty().addListener(listener1);

        Label lblTildelteJobs = new Label("Tildelte jobs");
        pane.add(lblTildelteJobs, 3, 0);

        pane.add(txaFrivilligJobs, 3, 1);
        txaFrivilligJobs.setPrefWidth(300);

        HBox hBox = new HBox(20);
        pane.add(hBox, 0, 4, 4, 1);
        hBox.setAlignment(Pos.CENTER);

        Label lblTimer = new Label("Timer:");
        hBox.getChildren().add(lblTimer);

        hBox.getChildren().add(txfTimer);

        Button btnTagVagt = new Button("Tag vagt");
        hBox.getChildren().add(btnTagVagt);
        btnTagVagt.setOnAction(event -> this.tagVagtAction());

        this.fillFestivalList();
        this.fillFrivilligList();
    }

    // -------------------------------------------------------------------------

    private void fillFestivalList() {
        lvwFestival.getItems().clear();
        lvwFestival.getItems().addAll(Storage.getFestivaller());
    }

    private void fillFrivilligList() {
        lvwFrivillig.getItems().clear();
        lvwFrivillig.getItems().addAll(Storage.getFrivillige());
    }

    private void fillJobList(Festival festival) {
        lvwJob.getItems().clear();
        lvwJob.getItems().addAll(festival.getJobs());
    }

    private void fillTildelteJobs(Frivillig frivillig) {
        txaFrivilligJobs.clear();
        txaFrivilligJobs.appendText(frivillig.getNavn() + "\n");
        txaFrivilligJobs.appendText("Maks. timer: " + frivillig.getMaksAntalTimer() + "\n");
        for (Vagt frivilligJob : frivillig.getVagter()) {
            txaFrivilligJobs.appendText(frivilligJob.getTimer() + " timer på jobbet " + frivilligJob.getJob().getKode() + "\n");
        }
    }

    private void festivalSelectionChanged() {
        Festival selected = lvwFestival.getSelectionModel().getSelectedItem();
        if (selected != null)
            this.fillJobList(selected);
    }

    private void frivilligSelectionChanged() {
        Frivillig selected = lvwFrivillig.getSelectionModel().getSelectedItem();
        if (selected != null)
            this.fillTildelteJobs(selected);
    }
    private void tagVagtAction() {
        int timer = Integer.parseInt(txfTimer.getText().trim());
        Job job = lvwJob.getSelectionModel().getSelectedItem();
        Frivillig frivillig = lvwFrivillig.getSelectionModel().getSelectedItem();
        if (job != null && frivillig != null) {
            try {
                System.out.println("In tagVagt");
                Vagt frivilligJob = Controller.tagVagt(job, frivillig, timer);
                System.out.println(frivilligJob);
                this.fillTildelteJobs(frivillig);
            } catch (RuntimeException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Tildel timer");
                alert.setHeaderText("Timer kan ikke tildeles");
                alert.setContentText("Teknisk meddelelse:\n" + ex.getMessage());
                alert.showAndWait();
                // wait for modal window to close ...
            }
        }
    }
}
