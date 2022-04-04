package Ex05;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<String> guestCast = new ArrayList<>(List.of("Matt Leblanc", "Matthew Perry", "David Swimmer",
                "Jennifer Aniston", "Courtney Cox", "Lisa Kudrow"));
        Series friends = new Series("Friends", guestCast);

        ArrayList<String> guestEpisode = new ArrayList<>(List.of("Bruce Wilis"));
        friends.createEpisode(guestEpisode, 22);

        ArrayList<String> guestEpisode1 = new ArrayList<>(List.of("Paul Rudd"));
        friends.createEpisode(guestEpisode1, 21);

        System.out.println(friends.getGuestActors());

        System.out.println(friends.totalLength());
    }
}
