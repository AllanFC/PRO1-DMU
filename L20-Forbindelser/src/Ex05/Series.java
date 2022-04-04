package Ex05;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;

    public Series(String title, ArrayList<String> cast){
        this.title = title;
        this.cast = cast;
    }

    private ArrayList<Episode> episodes = new ArrayList<>();

    public Episode createEpisode(ArrayList<String> guestActors, int length){
        Episode episode = new Episode(guestActors, length);
        episodes.add(episode);
        return episode;
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     */
    public int totalLength(){
        int totalMinutes = 0;
        for(Episode e : episodes){
            totalMinutes += e.getLength();
        }
        return totalMinutes;
    }

    /**
     * Return the total list of all guest actors from all episodes.
     */
    public ArrayList<String> getGuestActors(){
        ArrayList<String> guestActors = new ArrayList<>();
        for(Episode e : episodes){
            guestActors.addAll(e.getGuestCast());
        }
        return guestActors;
    }

}
