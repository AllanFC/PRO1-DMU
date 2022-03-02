package craps;

import java.util.Scanner;

public class CrapsGame {

    /**
     * Simulates playing one game of craps.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();
        int firstRoll = 0;

        boolean finished = false;
        while (!finished) {

            if(thrower.getRollCount() > 0){
                System.out.println("Roll again");
                String answer = scanner.nextLine();
            }
            thrower.roll();
            System.out.println(thrower.rollDescription());




            if(thrower.getRollCount() == 1) {
                if(thrower.sum() == 7 || thrower.sum() == 11){
                    printGameWon();
                    finished = true;
                } else if(thrower.sum() == 2 || thrower.sum() == 3 || thrower.sum() == 12){
                    printGameLost();
                    finished = true;
                } else {
                    firstRoll = thrower.sum();
                }
            } else {
                if(thrower.sum() == firstRoll) {
                    printGameWon();
                    finished = true;
                } else if(thrower.sum() == 7) {
                    printGameLost();
                    finished = true;
                }
            }

        }
        scanner.close();

    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        System.out.println("You won! RNGjesus would be proud");
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        System.out.println("You lost to RNGjesus");
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
        // TODO
        System.out.println("In the game a player throws 2 dice. The first throw is called 'the come out roll'. The player wins, if \n" +
                "the sum of the dice in the come out roll is 7 or 11. The player loses, if the sum is 2, 3 or 12. If the \n" +
                "sum is something else (that is, 4, 5, 6, 8, 9 or 10), the sum is set as the player's 'point'. The player \n" +
                "will now continue throwing the dice until he has lost or won. A sum equal his 'point' is a win, and a \n" +
                "sum equal 7 is a loss.");
    }

}
