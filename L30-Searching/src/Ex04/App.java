package Ex04;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>(List.of(
                new Player("Hans", 179,80,10),
                new Player("Eric", 180,85,11),
                new Player("Christian", 182,85,14),
                new Player("Taric", 190,90,15),
                new Player("Henric", 176, 75, 16),
                new Player("Lars", 169, 75, 51)));

        System.out.println(findPlayerLinear(players, 14));
        System.out.println(findPlayerBinary(players, 15));
        System.out.println(findPlayerName(players));
    }

    public static Player findPlayerLinear(ArrayList<Player> players, int score){
        Player player = null;
        int i = 0;
        while(player == null && i < players.size()){
            Player k = players.get(i);
            if(k.getScoredGoals() == score){
                player = k;
            }else{
                i++;
            }
        }
        return player;
    }

    public static Player findPlayerBinary(ArrayList<Player> players, int score){
        Player player = null;
        int left = 0;
        int right = players.size() - 1;
        while (player == null && left <= right) {
            int middle = (left+right) / 2;
            Player k = players.get(middle);
            if (k.getScoredGoals() == score)
                player = k;
            else if (k.getScoredGoals() > score)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return player;
    }

    public static String findPlayerName(ArrayList<Player> players){
        int i = 0;
        String playerName = "";
        while(playerName.equals("") && i < players.size()){
            Player k = players.get(i);
            if(k.getHieght() < 170 && k.getScoredGoals() > 50){
                playerName = k.getName();
            }
            i++;
        }
        return playerName;
    }
}
