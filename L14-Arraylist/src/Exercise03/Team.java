package Exercise03;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name){
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getplayers() {
        return players;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void printPlayers(){
        for(Player e : players){
            System.out.printf("Name: %s, age: %d, score: %d %n", e.getName(), e.getAge(), e.getScore());
        }
    }

    public double calcAverageAge(){
        double sumAge = 0;
        for(Player e : players){
            sumAge += e.getAge();
        }
        return sumAge / players.size();
    }

    public int calcTotalScore(){
        int totalScore = 0;
        for(Player e : players){
            totalScore += e.getScore();
        }
        return totalScore;
    }

    public int calcOldPlayerScore(int ageLimit){
        int totalScore = 0;
        for(Player e : players){
            if(e.getAge() > ageLimit){
                totalScore += e.getScore();
            }
        }
        return totalScore;
    }

    public int maxScore(){
        int max = players.get(0).getScore();
        for(Player e : players){
            if(e.getScore() > max){
                max = e.getScore();
            }
        }
        return max;
    }

    public ArrayList<String> bestPlayerNames(){
        ArrayList<String> bestPlayers = new ArrayList<>();
        int maxScore = maxScore();
        for(Player e : players){
            if(e.getScore() == maxScore){
                bestPlayers.add(e.getName());
            }
        }
        return bestPlayers;
    }
}
