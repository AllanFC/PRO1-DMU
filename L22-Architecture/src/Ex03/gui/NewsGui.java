package Ex03.gui;

import Ex03.controller.Controller;
import Ex03.model.Newsflash;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;

public class NewsGui extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Newsflash");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final ListView<Newsflash> lvheaders = new ListView<>();
    private final TextArea txacontents = new TextArea();

    private void initContent(GridPane gridPane){
        gridPane.setPadding(new Insets(20));

        // set horizontal gap between components
        gridPane.setHgap(10);
        // set vertical gap between components
        gridPane.setVgap(10);

        Label lblTitle = new Label("The Academy Xpress");
        lblTitle.setFont(Font.font(30));
        gridPane.add(lblTitle, 0, 0);

        Label lblHeader = new Label("Headers");
        gridPane.add(lblHeader, 0, 1);

        Label lblContent = new Label("Content");
        gridPane.add(lblContent, 1, 1);

        gridPane.add(lvheaders, 0, 2);
        ChangeListener<Newsflash> listener = (ov, o, n) -> selectedNewsflashChanged();
        lvheaders.getSelectionModel().selectedItemProperty().addListener(listener);
        lvheaders.getItems().setAll(Controller.getNewsflash());

        txacontents.setWrapText(true);
        gridPane.add(txacontents, 1, 2);

        HBox hbxButtons = new HBox(40);
        gridPane.add(hbxButtons, 0, 4, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        if (!lvheaders.getItems().isEmpty()){
            lvheaders.getSelectionModel().select(0);
        }
    }

    private void createAction(){
        NewsWindow dialog = new NewsWindow("Create News", null);
        dialog.showAndWait();

        lvheaders.getItems().setAll(Controller.getNewsflash());
        int index = lvheaders.getItems().size() - 1;
        lvheaders.getSelectionModel().select(index);
    }

    private void updateAction(){
        Newsflash newsflash = lvheaders.getSelectionModel().getSelectedItem();
        if (newsflash == null)
            return;

        NewsWindow dialog = new NewsWindow("Update Company", newsflash);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvheaders.getSelectionModel().getSelectedIndex();
        lvheaders.getItems().setAll(Controller.getNewsflash());
        lvheaders.getSelectionModel().select(selectIndex);
    }

    private void deleteAction(){
        Newsflash newsflash = lvheaders.getSelectionModel().getSelectedItem();
        if (newsflash == null)
            return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete newsflash");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        // wait for the modal dialog to close

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            Controller.deleteNewsflash(newsflash);
            lvheaders.getItems().setAll(Controller.getNewsflash());
            this.updateControls();
        }


    }


    private void selectedNewsflashChanged(){
        updateControls();
    }

    public void updateControls() {
        Newsflash newsflash = lvheaders.getSelectionModel().getSelectedItem();
        if (newsflash != null) {
            txacontents.setText(newsflash.getContent());
        } else {
            txacontents.clear();
        }
    }
}
