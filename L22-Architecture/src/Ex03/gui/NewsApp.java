package Ex03.gui;

import Ex03.controller.Controller;
import javafx.application.Application;

public class NewsApp {
    public static void main(String[] args) {
        initStorage();
        Application.launch(NewsGui.class);
    }

    public static void initStorage(){
        Controller.createNewsflash("First huge car crash with flying cars",
                "There has been an accident by air95 Highway");
        Controller.createNewsflash("Boring exercises in schools can kill students",
                "New study shows students actually dies from boredom when doing boring school exercises");
    }
}
