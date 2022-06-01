package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

// S5 (6 p)
public abstract class Controller {

    public static Festival opretFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.storeFestival(festival);
        return festival;
    }

    public static Frivillig opretFrivillig(String name, String mobil, int maksAntalTimer) {
        Frivillig frivillig = new Frivillig(name, mobil, maksAntalTimer);
        Storage.storeFrivillig(frivillig);
        return frivillig;
    }

    public static FrivilligForening opretFrivilligForening(
            String navn, String mobil, int maksAntalTimer,
            String foreningsNavn, int antalFrivillige) {
        FrivilligForening frivilligForening = new FrivilligForening(
                navn, mobil, maksAntalTimer,
                foreningsNavn, antalFrivillige);
        Storage.storeFrivillig(frivilligForening);
        return frivilligForening;
    }

    public static Job opretJob(
            String kode, String beskrivelse, LocalDate dato,
            int timeHonorar, int antalTimer, Festival festival) {
        return festival.opretJob(kode, beskrivelse, dato, timeHonorar, antalTimer);
    }

    public static void initStorage() {
        Festival northside = opretFestival("Northside",
                LocalDate.of(2020, 6, 4),
                LocalDate.of(2020, 6, 6));

        opretFrivillig("Jane Jensen", "12345677", 20);
        opretFrivillig("Lone Hansen", "78787878", 25);
        opretFrivillig("Anders Mikkelsen", "55555555", 10);

        opretFrivilligForening(
                "Christian Madsen", "23232323", 100,
                "Erhversakademi Aarhus", 40);

        LocalDate juni4 = LocalDate.of(2020, 6, 4);
        for (int i = 1; i <= 3; i++) {
            opretJob("T" + i, "Rengøring af toilet",
                    juni4,
                    100, 5, northside);
        }
        for (int i = 4; i <= 6; i++) {
            opretJob("T" + i, "Rengøring af toilet",
                    juni4.plus(1, ChronoUnit.DAYS),
                    100, 5, northside);
        }
        for (int i = 7; i <= 9; i++) {
            opretJob("T" + i, "Rengøring af toilet",
                    juni4.plus(2, ChronoUnit.DAYS),
                    100, 5, northside);
        }
    }

    //-------------------------------------------------------------------------

    // S7 (6 p)
    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {
        if (frivillig.ledigeTimer() < timer || job.ikkeBesatteTimer() < timer) {
            throw new RuntimeException("Vagten kan ikke oprettes med timetallet: " + timer);
        }

        return job.opretVagt(timer, frivillig);
    }

    //-------------------------------------------------------------------------

    // S9 (7 p)
    public static boolean findFrivillig(ArrayList<String> liste, String navn) {
        int left = 0;
        int right = liste.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            String s = liste.get(middle);
            String t = s.substring(0, s.indexOf("\t"));
            if (t.compareTo(navn) == 0) {
                return true;
            } else if (t.compareTo(navn) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
