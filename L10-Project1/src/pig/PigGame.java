package pig;

import java.util.Random;
import java.util.Scanner;

public class PigGame {
    Player player1 = new Player("Player1");
    Player player2 = new Player("Player2");

    public void play(){
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();
        Random rd = new Random();
        int currentPoints = 0;
        int goal = 100;
        boolean turn;
        boolean finished = false;


        if(rd.nextInt(2) == 0){
            turn = true;
        } else {
            turn = false;
        }

        while(!finished){

            if(turn){
                thrower.roll();
                System.out.println(player1.getPlayerName() + " Rolled " + thrower.sum());
                if(thrower.sum() > 1){
                    currentPoints += thrower.sum();
                    System.out.println("Current points: " + currentPoints);
                    if(currentPoints + player1.getPlayerPoints() >= goal){
                        printGameWon(player1.getPlayerName());
                        finished = true;
                    }

                } else {
                    currentPoints = 0;
                    turn = false;
                    getScore();
                }
            }
            if(!turn){
                thrower.roll();
                System.out.println(player2.getPlayerName() + " Rolled " + thrower.sum());
                if(thrower.sum() > 1){
                    currentPoints += thrower.sum();
                    System.out.println("Current points: " + currentPoints);
                    if(currentPoints + player2.getPlayerPoints() >= goal){
                        printGameWon(player2.getPlayerName());
                        finished = true;
                    }
                } else{
                    currentPoints = 0;
                    turn = true;
                    getScore();
                }
            }

            if(!finished){
                if(thrower.sum() > 1) {
                    System.out.println("Roll again? (Y/n) ");
                }
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    if(turn){
                        player1.updatePlayerPoints(currentPoints);
                    } else {
                        player2.updatePlayerPoints(currentPoints);
                    }
                    turn = !turn;
                    currentPoints = 0;
                    getScore();
                }
            }
        }

        scanner.close();
    }

    /**
     * Prints a 'PlayerX have won' message.
     */
    public void printGameWon(String playerName) {
        System.out.println(playerName + " won! RNGjesus would be proud");
    }

    public void getScore(){
        System.out.println();
        System.out.println(player1.getPlayerName() + ": " + player1.getPlayerPoints());
        System.out.println(player2.getPlayerName() + ": " + player2.getPlayerPoints());
        System.out.println();

    }
    /**
     * Prints the rules of craps.
     */
    public void printRules(){
        System.out.println("The game is played by two players. The players take turns, throwing one die until he/she throws 1, \n" +
                "or until he/she decides to stop throwing. The player accumulates points (the face value of the die) \n" +
                "on each throw, but if he/she throws 1, all points in this turn is lost. If the player stops before \n" +
                "throwing a 1, the points of this turn is added to the points of earlier turns. The player that reaches \n" +
                "100 points after a turn, is the winner.");
    }
}
