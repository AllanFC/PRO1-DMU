package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDateTime;

public class CreateConferenceWindow extends Stage {

    public CreateConferenceWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();
    private final TextField txfLocation = new TextField();
    private final DatePicker startDate = new DatePicker();
    private final TextField txfStartTime = new TextField();
    private final DatePicker endDate = new DatePicker();
    private final TextField txfEndTime = new TextField();


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPrefHeight(200);
        pane.setPrefWidth(325);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name of Conference:");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 1, 0);

        Label lblPrice = new Label("Price per day:");
        pane.add(lblPrice, 0, 1);
        pane.add(txfPrice, 1, 1);

        Label lblLocation = new Label("Location:");
        pane.add(lblLocation, 0, 2);
        pane.add(txfLocation, 1, 2);

        Label lblStart = new Label("Start date:");
        pane.add(lblStart, 0, 3);
        pane.add(startDate, 1, 3);
        startDate.setEditable(false);
        Label lblStartTime = new Label("Start time(eg. 14:00)*:");
        pane.add(lblStartTime, 0, 4);
        pane.add(txfStartTime, 1,4);


        Label lblEnd = new Label("End date:");
        pane.add(lblEnd, 0, 5);
        pane.add(endDate, 1, 5);
        endDate.setEditable(false);
        Label lblEndTime = new Label("End time(eg. 15:00)*:");
        pane.add(lblEndTime, 0, 6);
        pane.add(txfEndTime, 1, 6);

        Button btnCreate = new Button("Create");
        pane.add(btnCreate, 0, 7);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 7);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

    private void createAction() {
        String name = txfName.getText().trim();
        String location = txfLocation.getText().trim();
        int price = Integer.parseInt(txfPrice.getText().trim());

        // Start date and time
        String[] arrOfStartStr = txfStartTime.getText().trim().split(":");
        int startHour = Integer.parseInt(arrOfStartStr[0]);
        int startMinute = Integer.parseInt(arrOfStartStr[1]);
        LocalDateTime startTime = startDate.getValue().atTime(startHour, startMinute);

        // End date and time
        String[] arrOfEndStr = txfEndTime.getText().trim().split(":");
        int endHour = Integer.parseInt(arrOfEndStr[0]);
        int endMinute = Integer.parseInt(arrOfEndStr[1]);
        LocalDateTime endTime = endDate.getValue().atTime(endHour, endMinute);

        // Create conference
        Controller.createConference(name, price, location,startTime, endTime);
        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }
}
