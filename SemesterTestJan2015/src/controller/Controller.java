package controller;

import model.Deltagelse;
import model.Kamp;
import model.ProfSpiller;
import model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {
    //---------------------------Match--------------------------
    public static Kamp createMatch(String place, LocalDate date, LocalTime time){
        Kamp match = new Kamp(place, date, time);
        Storage.storeMatch(match);
        return match;
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2){
        ArrayList<Kamp> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1).compareTo(list2.get(i2)) < 0) {
                // s1's tal er mindst
                result.add(list1.get(i1));
                i1++;
            }
            else {
                // s2's tal er mindst
                result.add(list2.get(i2));
                i2++;
            }
        }

        while (i1 < list1.size()) {
            result.add(list1.get(i1));
            i1++;
        }
        while (i2 < list2.size()) {
            result.add(list2.get(i2));
            i2++;
        }

        return result;
    }

    //---------------------------Participation--------------------------
    public static Deltagelse createParticipation(Kamp match, Boolean canceled, String reason){
        return match.createParticipation(canceled, reason);
    }

    //---------------------------Player--------------------------
    public static Spiller createPlayer(String name, int year){
        Spiller player = new Spiller(name, year);
        Storage.storePlayer(player);
        return player;
    }

    public static Spiller createProPlayer(String name, int year, double gameRate){
        Spiller proPlayer = new ProfSpiller(name, year, gameRate);
        Storage.storePlayer(proPlayer);
        return proPlayer;
    }

    /**
     * Opdaterer sammenhængen mellem spiller og deltagelse så de
     * linker til hinanden
     * Precondition: spiller != null og deltagelse != null
     */
    public static void updateSpillerDeltagelse(Spiller player, Deltagelse participation){
        player.Participating(participation);
    }

    //---------------------------Unrelated--------------------------

    public static void createSomeObjects(){
        Spiller jane = createPlayer("Jane Jensen", 1999);
        Spiller lene = createPlayer("Lene Hansen", 2000);
        Spiller mette = createPlayer("Mette Petersen", 1999);

        Spiller sofia = createProPlayer("Sofia Kjeldsen", 1999, 50);
        Spiller maria = createProPlayer("Maria Nielsen", 2000, 55);

        Kamp herning = createMatch("Herning", LocalDate.of(2015, 1,26), LocalTime.of(10, 30));
        Kamp ikast = createMatch("Ikast", LocalDate.of(2015, 1,27), LocalTime.of(13, 30));

        Deltagelse p1 = herning.createParticipation(true, "Moster Oda's fødselsdag");
        Deltagelse p2 = herning.createParticipation(false, "");
        Deltagelse p3 = herning.createParticipation(false, "");
        Deltagelse p4 = herning.createParticipation(false, "");
        Deltagelse p5 = herning.createParticipation(false, "");
        updateSpillerDeltagelse(jane, p1);
        updateSpillerDeltagelse(lene, p2);
        updateSpillerDeltagelse(mette, p3);
        updateSpillerDeltagelse(sofia, p4);
        updateSpillerDeltagelse(maria, p5);

        Deltagelse p6 = ikast.createParticipation(false, "");
        Deltagelse p7 = ikast.createParticipation(false, "");
        Deltagelse p8 = ikast.createParticipation(false, "");
        Deltagelse p9 = ikast.createParticipation(true, "Dårlig form");
        Deltagelse p10 = ikast.createParticipation(false, "");
        updateSpillerDeltagelse(jane, p6);
        updateSpillerDeltagelse(lene, p7);
        updateSpillerDeltagelse(mette, p8);
        updateSpillerDeltagelse(sofia, p9);
        updateSpillerDeltagelse(maria, p10);


    }
}
