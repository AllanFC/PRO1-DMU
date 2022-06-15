package gui;

import controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller.createSomeObjects();
        Gui.launch(Gui.class);
    }
}
