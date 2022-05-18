package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;

import java.util.ArrayList;

public class CreateHotelWindow extends Stage {


    public CreateHotelWindow(String title) {
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
    private final TextField txfAddress = new TextField();
    private final TextField txfSingleRoom = new TextField();
    private final TextField txfDoubleRoom = new TextField();
    private final ArrayList<TextField> textFields = new ArrayList<>();
    private final ArrayList<TextField> intTextFields = new ArrayList<>();
    private final TextField txfWifiPrice = new TextField();
    private final TextField txfBathPrice = new TextField();
    private final TextField txfFoodPrice = new TextField();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPrefHeight(200);
        pane.setGridLinesVisible(false);

       Label lblName = new Label("Name*:");
       pane.add(lblName,0,0);
       pane.add(txfName,2,0);

       Label lblAddress = new Label("Address*:");
       pane.add(lblAddress, 0, 1);
       pane.add(txfAddress, 2, 1);

       Label lblSingleRoom = new Label("Single room price*:");
       pane.add(lblSingleRoom,0,2);
       pane.add(txfSingleRoom,2,2);

       Label lblDoubleRoom = new Label("Double room price*:");
       pane.add(lblDoubleRoom,0,3);
       pane.add(txfDoubleRoom,2,3);

       textFields.add(txfName);
       textFields.add(txfAddress);

       Label lblAddServices = new Label("Add Services:");
       pane.add(lblAddServices,0,4);
       Label lblServicePrice = new Label("Price for service:");
       pane.add(lblServicePrice,2,4);
       lblServicePrice.setAlignment(Pos.CENTER);

       Label lblWifi = new Label("Wifi:");
       pane.add(lblWifi,0,5);
       pane.add(txfWifiPrice,2,5);

       Label lblBath = new Label("Bath:");
       pane.add(lblBath,0,6);
       pane.add(txfBathPrice,2,6);

       Label lblFood = new Label("Food:");
       pane.add(lblFood,0,7);
       pane.add(txfFoodPrice,2,7);

       intTextFields.add(txfSingleRoom);
       intTextFields.add(txfDoubleRoom);
       intTextFields.add(txfWifiPrice);
       intTextFields.add(txfBathPrice);
       intTextFields.add(txfFoodPrice);

       Button btnCreate = new Button("Create");
       pane.add(btnCreate, 0, 8);
        btnCreate.setOnAction(event -> this.createHotelAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 2, 8);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

//----------------------------------------------------------------------------------------------------------------------

    public void createHotelAction(){
        String name = txfName.getText().trim();
        String address = txfAddress.getText().trim();
        int singleRoom = Integer.parseInt(txfSingleRoom.getText().trim());
        int doubleRoom = Integer.parseInt(txfDoubleRoom.getText().trim());
        Hotel hotel = Controller.createHotel(name, address, singleRoom, doubleRoom);
        int wifiPrice;
        int bathPrice;
        int foodPrice;

        if(txfWifiPrice.getText().trim().equals("")){
            wifiPrice = 0;
        } else {
            wifiPrice = Integer.parseInt(txfWifiPrice.getText().trim());
        }
        Controller.createService("Wifi", wifiPrice,hotel);

        if(txfBathPrice.getText().trim().equals("")){
            bathPrice = 0;
        } else {
            bathPrice = Integer.parseInt(txfBathPrice.getText().trim());;
        }
        Controller.createService("Bath", bathPrice,hotel);

        if(txfFoodPrice.getText().trim().equals("")){
            foodPrice = 0;
        } else {
            foodPrice = Integer.parseInt(txfFoodPrice.getText().trim());
        }
        Controller.createService("Food", foodPrice,hotel);

        this.hide();
    }

    public void cancelAction(){
        this.hide();
    }
}
