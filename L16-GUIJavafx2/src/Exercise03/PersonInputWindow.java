package Exercise03;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfJob = new TextField();
    private final CheckBox checkBox = new CheckBox();

    private Person actualPerson = null;

    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblJob = new Label("Job:");
        pane.add(lblJob, 0, 1);

        pane.add(txfName, 1, 0);

        pane.add(txfJob, 1, 1);

        checkBox.setText("Senior");
        pane.add(checkBox, 1, 2);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3, 2, 1);
        buttonBox.setPadding(new Insets(0, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfJob.clear();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        String job = txfJob.getText().trim();

        if (name.length() > 0 && job.length() > 0) {
            actualPerson = new Person(name, job, checkBox.isSelected());
            txfName.clear();
            txfJob.clear();
            txfName.requestFocus();
            PersonInputWindow.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Create person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Enter name and job");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Person getActualPerson() {
        return actualPerson;
    }

}
