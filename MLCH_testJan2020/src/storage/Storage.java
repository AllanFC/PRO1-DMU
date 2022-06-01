package storage;

import model.Festival;
import model.Frivillig;

import java.util.ArrayList;

// S4 (3 p)
public abstract class Storage {
    private static final ArrayList<Festival> festivaller = new ArrayList<>();
    private static final ArrayList<Frivillig> frivillige = new ArrayList<>();

    public static ArrayList<Festival> getFestivaller() {
        return new ArrayList<>(festivaller);
    }

    public static ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }

    public static void storeFestival(Festival festival) {
        festivaller.add(festival);
    }

    public static void storeFrivillig(Frivillig frivillig) {
        frivillige.add(frivillig);
    }
}
