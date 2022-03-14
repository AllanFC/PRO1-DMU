package Exercise03;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Hans", 25);
        p1.addScore(11);
        Player p2 = new Player("Erik", 27);
        p2.addScore(8);
        Player p3 = new Player("Jorgen", 24);
        p3.addScore(11);
        Player p4 = new Player("Per", 30);
        p4.addScore(1);

        Team t1 = new Team("Viby IF");
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);
        t1.addPlayer(p4);

        t1.printPlayers();

        System.out.println("Average age: " + t1.calcAverageAge());

        System.out.println("Total Score: " + t1.calcTotalScore());

        System.out.println("Total Score(age restrict): " + t1.calcOldPlayerScore(27));

        System.out.println("Max score: " + t1.maxScore());

        System.out.println("Best players: " + t1.bestPlayerNames());

    }
}
