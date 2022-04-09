package Ex03.storage;

import Ex03.model.Newsflash;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Newsflash> newsflashes = new ArrayList<>();

    public static ArrayList<Newsflash> getNewsflashes() {
        return new ArrayList<>(newsflashes);
    }

    public static void storeNewsflash(Newsflash newsflash) {
        newsflashes.add(newsflash);
    }

    public static void deleteNewsflash(Newsflash newsflash) {
        newsflashes.remove(newsflash);
    }
}
