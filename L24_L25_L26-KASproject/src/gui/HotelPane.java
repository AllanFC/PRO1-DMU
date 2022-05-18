package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import model.Hotel;
import model.Service;


public class HotelPane extends GridPane {

    private final ListView<Hotel> lvwHotels = new ListView<>();
    private final ListView<Service> lvwServices = new ListView<>();
    private final TextField txfPriceSingle = new TextField();
    private final TextField txfPriceDouble = new TextField();
    private final TextField txfAddress = new TextField();


    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        this.add(lvwHotels, 0, 1, 1, 5);
        lvwHotels.setPrefHeight(200);
        lvwHotels.setPrefWidth(200);
        lvwHotels.getItems().setAll(Controller.getHotels());

        ChangeListener<Hotel> listener = (ov, o, n) -> this.selectedHotelChanged();
        lvwHotels.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblPriceSingle = new Label("Single room:");
        this.add(lblPriceSingle, 1, 1);
        this.add(txfPriceSingle, 2, 1);
        txfPriceSingle.setEditable(false);

        Label lblPriceDouble = new Label("Double room");
        this.add(lblPriceDouble, 1, 2);
        this.add(txfPriceDouble, 2, 2);
        txfPriceDouble.setEditable(false);

        Label lblAddress = new Label("Address");
        this.add(lblAddress, 1, 3);
        this.add(txfAddress, 2, 3);
        txfAddress.setEditable(false);

        Label lblServices = new Label("Services:");
        this.add(lblServices,1,4);
        this.add(lvwServices,2,4,1,2);
        lvwServices.setPrefSize(70,70);
    }

//    -------------------------------------------------------------------------------

    public void updateControls() {
        if(!lvwHotels.getItems().containsAll(Controller.getHotels())) {
            lvwHotels.getItems().setAll(Controller.getHotels());
        }
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            txfPriceSingle.setText("" + hotel.getPriceSingle());
            txfPriceDouble.setText("" + hotel.getPriceDouble());
            txfAddress.setText(hotel.getAddress());
            lvwServices.getItems().setAll(Controller.getServiceOfHotel(hotel));
        } else {
            txfPriceSingle.clear();
            txfPriceDouble.clear();
            txfAddress.clear();
            lvwServices.getItems().clear();
        }
    }
    private void selectedHotelChanged() {
        this.updateControls();
    }
}