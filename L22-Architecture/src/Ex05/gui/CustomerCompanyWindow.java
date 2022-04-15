package Ex05.gui;


import Ex05.controller.Controller;
import Ex05.model.Company;
import Ex05.model.Customer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class CustomerCompanyWindow extends Stage {
    private final Company company;

    public CustomerCompanyWindow(String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final ListView<Customer> lvwCustomers = new ListView<>();
    private final ListView<Customer> lvwAddedCustomers = new ListView<>();
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<Customer> addedCustomers = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblAllCustomers = new Label("Available Customers");
        pane.add(lblAllCustomers, 0,0);

        Label lblAddedCustomers = new Label(company + " Customers");
        pane.add(lblAddedCustomers, 2,0);

        customers.addAll(Controller.getAllCustomers());
        addedCustomers.addAll(Controller.getCustomersOfCompany(company));

        pane.add(lvwCustomers, 0, 1, 1, 4);
        lvwCustomers.setPrefWidth(200);
        lvwCustomers.setPrefHeight(200);
        for(Customer e : addedCustomers){
            customers.remove(e);
        }
        lvwCustomers.getItems().setAll(customers);

        pane.add(lvwAddedCustomers, 2, 1, 1, 4);
        lvwAddedCustomers.setPrefWidth(200);
        lvwAddedCustomers.setPrefHeight(200);
        lvwAddedCustomers.getItems().setAll(addedCustomers);

        Button btnAdd = new Button(">>");
        pane.add(btnAdd, 1,2);
        btnAdd.setOnAction(event -> this.addAction());

        Button btnRemove = new Button("<<");
        pane.add(btnRemove, 1,3);
        btnRemove.setOnAction(event -> this.removeAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 2, 5);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 2, 5);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());
    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        Controller.setCompanyCustomers(addedCustomers, company);

        this.hide();
    }

    private void addAction(){
        Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
        if(customer != null) {
            addedCustomers.add(customer);
            customers.remove(customer);
        }

        updateControls();
    }

    private void removeAction(){
        Customer customer = lvwAddedCustomers.getSelectionModel().getSelectedItem();
        if(customer != null){
            customers.add(customer);
            addedCustomers.remove(customer);
        }

        updateControls();
    }

    private void updateControls(){
        lvwCustomers.getItems().setAll(customers);
        lvwAddedCustomers.getItems().setAll(addedCustomers);
    }
}
