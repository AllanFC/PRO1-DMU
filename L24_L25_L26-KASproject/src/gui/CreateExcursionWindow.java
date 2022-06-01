package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Conference;

import java.time.LocalDateTime;

public class CreateExcursionWindow extends Stage {
    private final Conference conference;
    public CreateExcursionWindow(String title, Conference conference) {
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

    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();
    private final TextField txfTime = new TextField();
    private final CheckBox cbxLunch = new CheckBox();
    private final DatePicker datePicker = new DatePicker();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPrefHeight(200);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name*:");
        pane.add(lblName,0,0);
        pane.add(txfName,1,0);

        Label lblAddress = new Label("Date:");
        pane.add(lblAddress, 0, 1);
        pane.add(datePicker, 1, 1);
        datePicker.setValue(conference.getStartDate().toLocalDate());
        datePicker.setEditable(false);

        Label lblTime = new Label("Time(eg.14:00)*:");
        pane.add(lblTime,0,2);
        pane.add(txfTime,1,2);

        Label lblPrice = new Label("Price*:");
        pane.add(lblPrice,0,3);
        pane.add(txfPrice, 1, 3);

        cbxLunch.setText("Lunch included");
        pane.add(cbxLunch, 0, 4);

        Button btnCreate = new Button("Create");
        pane.add(btnCreate, 0, 5);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 5);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

    public void createAction(){
        String name = txfName.getText().trim();
        String[] arrOfStr = txfTime.getText().trim().split(":");
        int hour = Integer.parseInt(arrOfStr[0]);
        int minute = Integer.parseInt(arrOfStr[1]);
        LocalDateTime time = datePicker.getValue().atTime(hour,minute);
        int price = Integer.parseInt(txfPrice.getText().trim());
        Controller.createExcursion(conference,name,time,price,cbxLunch.isSelected());
        this.hide();
    }

    public void cancelAction(){
        this.hide();
    }
}
