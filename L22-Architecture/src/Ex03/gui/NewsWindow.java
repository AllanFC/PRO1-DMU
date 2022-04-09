package Ex03.gui;

import Ex03.controller.Controller;
import Ex03.model.Newsflash;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewsWindow extends Stage {
    private final Newsflash newsflash; // nullable

    /** Note: Nullable param newsflash. */
    public NewsWindow(String title, Newsflash newsflash) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.newsflash = newsflash;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfHeader = new TextField();
    private final TextArea txaContent = new TextArea();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Header");
        pane.add(lblName, 0, 0);

        pane.add(txfHeader, 0, 1);
        txfHeader.setPrefWidth(200);

        Label lblContent = new Label("Header");
        pane.add(lblContent, 0, 2);

        pane.add(txaContent, 0, 3);
        txaContent.setPrefWidth(300);
        txaContent.setPrefHeight(300);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 4);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 3);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();

    }

    private void initControls() {
        if (newsflash != null) {
            txfHeader.setText(newsflash.getHeader());
            txaContent.setText(newsflash.getContent());
        } else {
            txfHeader.clear();
            txaContent.clear();
        }
    }

    private void cancelAction(){
        this.hide();
    }

    private void okAction(){
        String header = txfHeader.getText().trim();
        String content = txaContent.getText().trim();
        if (header.length() == 0) {
            lblError.setText("header is empty");
            return;
        }

        if (content.length() == 0) {
            lblError.setText("content is empty");
            return;
        }

        if (newsflash != null){
            // update existing news
            Controller.updateNewsflash(newsflash, header, content);
        } else {
            // create new news
            Controller.createNewsflash(header, content);
        }

        this.hide();
    }
}
