package pig;

public class Player {
    private String playerName;
    private int playerPoints;

    public Player(String playerName){
        this.playerName = playerName;
        playerPoints = 0;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints += playerPoints;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public String getPlayerName() {
        return playerName;
    }
}
