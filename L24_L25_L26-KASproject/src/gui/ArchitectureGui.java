package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ArchitectureGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabOverview = new Tab("Overview");
        tabPane.getTabs().add(tabOverview);


        OverviewPane overviewPane = new OverviewPane();
        tabOverview.setContent(overviewPane);
        tabOverview.setOnSelectionChanged(event -> overviewPane.updateControls());

        Tab tabConference = new Tab("Conferences");
        tabPane.getTabs().add(tabConference);

        ConferencePane conferencePane = new ConferencePane();
        tabConference.setContent(conferencePane);
        tabConference.setOnSelectionChanged(event -> conferencePane.updateControls());

        Tab tabHotel = new Tab("Hotel");
        tabPane.getTabs().add(tabHotel);

        HotelPane hotelPane = new HotelPane();
        tabHotel.setContent(hotelPane);
        tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());

        Tab tabAdministration = new Tab("Administration");
        tabPane.getTabs().add(tabAdministration);

        AdministrationPane administrationPane = new AdministrationPane();
        tabAdministration.setContent(administrationPane);
        tabAdministration.setOnSelectionChanged(event -> administrationPane.updateControls());
    }
}
