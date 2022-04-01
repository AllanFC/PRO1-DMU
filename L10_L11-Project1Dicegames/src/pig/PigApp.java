package pig;

import craps.CrapsGame;

public class PigApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the PIG game (100)");

        // TODO
        PigGame game = new PigGame();
        game.printRules();
        System.out.println();

        game.play();

        System.out.println("Thank you for playing PIG");
    }
}
