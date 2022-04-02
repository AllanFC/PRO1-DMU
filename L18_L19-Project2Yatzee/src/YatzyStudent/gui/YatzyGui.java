package YatzyStudent.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import YatzyStudent.model.YatzyDice;

import java.lang.reflect.Method;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // Shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // Shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final TextField[] txfResults = new TextField[15];

    private final Label[] lblResults = new Label[15];
    private final String[] lblNames = {"1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One Pair", "Two Pair", "Three Kind",
                                       "Four Kind", "Full House", "S Straight", "L Straight", "Chance", "Yatzy"};
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField("0"), txfBonus = new TextField("0"),
            txfSumOther = new TextField("0"), txfTotal = new TextField("0");
    private final Label lblSumSame = new Label(), lblBonus = new Label(),
            lblSumOther = new Label(), lblTotal = new Label();
    Button rollbtn = new Button("Throw");
    private int winCounter = 0;
    //    private final Label lblRolled = new Label();

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        // dicePane.setGridLinesVisible(true);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds, lblRolled and btnRoll
        // TODO
        for (int i = 0; i < txfValues.length; i++) {
            TextField txf = new TextField();
            dicePane.add(txf, i, 0);
            txf.setPrefWidth(70);
            txf.setPrefHeight(70);
            txf.setFont(Font.font(30));
            txf.setAlignment(Pos.CENTER);
            txf.setEditable(false);
            txfValues[i] = txf;
        }
        for (int i = 0; i < cbxHolds.length; i++) {
            CheckBox cbx = new CheckBox("Hold");
            dicePane.add(cbx, i, 1);
            cbxHolds[i] = cbx;
            cbx.setOnMouseClicked(event -> this.mouseClickedCbx(event));
        }

        dicePane.add(rollbtn, 3, 3, 2, 1);
        rollbtn.setPrefWidth(125);
        rollbtn.setPrefHeight(35);
        rollbtn.setOnAction(event -> this.rollAction());


        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        // scorePane.setGridLinesVisible(true);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        // add labels for results, add txfResults,
        // add labels and text fields for sums, bonus and total.
        for (int i = 0; i < 6; i++) {
            Label lbl = new Label(lblNames[i]);
            scorePane.add(lbl, 0, i);
            lblResults[i] = lbl;
        }
        for (int i = 7; i < lblResults.length + 1; i++) {
            Label lbl = new Label(lblNames[i-1]);
            scorePane.add(lbl, 0, i);
            lblResults[i-1] = lbl;
        }

        for (int i = 0; i < 6; i++) {
            TextField txf = new TextField("0");
            scorePane.add(txf, 1, i);
            txf.setPrefWidth(60);
            txf.setEditable(false);
            txf.setOnMouseClicked(event -> this.mouseClickedTxf(event));
            txfResults[i] = txf;
        }

        for (int i = 7; i < txfResults.length + 1; i++) {
            TextField txf = new TextField("0");
            scorePane.add(txf, 1, i);
            txf.setPrefWidth(60);
            txf.setEditable(false);
            txf.setOnMouseClicked(event -> this.mouseClickedTxf(event));
            txfResults[i-1] = txf;
        }

        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setPrefWidth(60);
        txfSumSame.setEditable(false);

        scorePane.add(txfBonus, 3, 6);
        txfBonus.setPrefWidth(60);
        txfBonus.setEditable(false);

        scorePane.add(txfSumOther, 3, 15);
        txfSumOther.setPrefWidth(60);
        txfSumOther.setEditable(false);

        scorePane.add(txfTotal, 3, 16);
        txfTotal.setPrefWidth(60);
        txfTotal.setEditable(false);

        scorePane.add(lblSumSame, 2, 5);
        lblSumSame.setText("Sum");

        scorePane.add(lblBonus, 2, 6);
        lblBonus.setText("Bonus");

        scorePane.add(lblSumOther, 2, 15);
        lblSumOther.setText("Sum");

        scorePane.add(lblTotal, 2, 16);
        lblTotal.setText("TOTAL");

    }

    // -------------------------------------------------------------------------

    // Create an action method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    private boolean[] holds(){
        boolean[] holds = new boolean[5];
        for(int i = 0; i < cbxHolds.length; i++){
            holds[i] = cbxHolds[i].isSelected();
        }
        return holds;
    }

    private void updateTxfResults(){
        int[] results = dice.getResults();
        for(int i = 0; i < txfResults.length; i++){
            if(txfResults[i].getUserData() != "Locked") {
                txfResults[i].setText("" + results[i]);
            }
        }
        if(dice.getThrowCount() == 3){
            for(int i = 0; i < txfResults.length; i++){
                if(txfResults[i].getUserData() != "Locked") {
                    txfResults[i].setStyle("-fx-background-color: yellow");
                    txfResults[i].setUserData("Clickable");
                }
            }
        }
    }

    private void rollAction(){
        dice.throwDice(holds());
        int[] values = dice.getValues();

        for(int i = 0; i < 5; i++){
            txfValues[i].setText("" + values[i]);
        }

        int throwCount = dice.getThrowCount();
        if(throwCount == 3){
            rollbtn.setDisable(true);
            rollbtn.setText("Pick result");
            updateTxfResults();
        } else {
            rollbtn.setText("Throw " + throwCount);
        }

    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO
    private void resetTxf(){
        for(int i = 0; i < txfResults.length; i++){
            if(txfResults[i].getUserData() != "Locked") {
                txfResults[i].setUserData("");
                txfResults[i].setText("0");
                txfResults[i].setStyle("-fx-background-color: transparent");
            }
        }
    }

    private void resetCbx(){
        for(int i = 0; i < cbxHolds.length; i++){
            cbxHolds[i].setDisable(false);
            cbxHolds[i].setSelected(false);
        }
    }

    private void updateSums(){
        int sumSame = 0;
        int sumOther = 0;
        for(int i = 0; i < 6; i++){
            sumSame += Integer.parseInt(txfResults[i].getText());
        }
        for(int i = 7; i < txfResults.length; i++){
            sumOther += Integer.parseInt(txfResults[i].getText());
        }
        txfSumSame.setText("" + sumSame);
        txfSumOther.setText("" + sumOther);
        if(sumSame >= 63){
            txfBonus.setText("50");
        }
    }

    private void done(){
        int total = 0;
        total += Integer.parseInt(txfSumSame.getText());
        total += Integer.parseInt(txfBonus.getText());
        total += Integer.parseInt(txfSumOther.getText());
        txfTotal.setText("" + total);
    }

    private void mouseClickedCbx(MouseEvent event) {
        CheckBox cbx = (CheckBox) event.getSource();
        cbx.setDisable(true);

    }

    private void mouseClickedTxf(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if(txf.getUserData() == "Clickable") {
            txf.setUserData("Locked");
            txf.setStyle("-fx-background-color: transparent");
            resetTxf();
            updateSums();
            winCounter++;
            if(winCounter != 15){
                resetCbx();
                dice.resetThrowCount();
                rollbtn.setDisable(false);
                rollbtn.setText("Throw " + dice.getThrowCount());
            }else {
                done();
            }
        }

    }

}
