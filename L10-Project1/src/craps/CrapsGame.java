package craps;


public class CrapsGame {

    /**
     * Simulates playing one game of craps.
     */
    public void play() {
        // TODO

    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        // TODO
        System.out.println("You won! RNGjesus would be proud");
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        // TODO
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
