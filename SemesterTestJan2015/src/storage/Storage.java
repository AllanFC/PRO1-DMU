package storage;

import model.Kamp;
import model.Spiller;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Kamp> matches = new ArrayList<>();
    private static final ArrayList<Spiller> players = new ArrayList<>();

    public static ArrayList<Kamp> getMatches(){
        return new ArrayList<>(matches);
    }

    public static ArrayList<Spiller> getPlayers() {
        return new ArrayList<>(players);
    }

    public static void storeMatch(Kamp match){
        matches.add(match);
    }

    public static void storePlayer(Spiller player){
        players.add(player);
    }
}
