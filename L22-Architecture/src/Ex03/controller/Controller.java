package Ex03.controller;

import Ex03.model.Newsflash;
import Ex03.storage.Storage;

import java.util.ArrayList;

public class Controller {
    /**
     * Create a new Company.
     * Pre: name not empty, hours >= 0.
     */
    public static Newsflash createNewsflash(String header, String content) {
        Newsflash newsflash = new Newsflash(header, content);
        Storage.storeNewsflash(newsflash);
        return newsflash;
    }

    public static void deleteNewsflash(Newsflash newsflash){
        Storage.deleteNewsflash(newsflash);
    }

    public static void updateNewsflash(Newsflash newsflash, String header, String content){
        newsflash.setHeader(header);
        newsflash.setContent(content);
        newsflash.updateVersion();
    }

    public static ArrayList<Newsflash> getNewsflash(){
        return Storage.getNewsflashes();
    }
}
