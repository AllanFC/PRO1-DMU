package model;

import java.util.ArrayList;

public class Frivillig {
    private final String navn;
    private final String mobil;
    private final int maksAntalTimer;

    // associering 1 --> 0..* Vagt
    final ArrayList<Vagt> vagter = new ArrayList<>(); // OBS: package visible

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    //-------------------------------------------------------------------------

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    //-------------------------------------------------------------------------

    // Del af S6 (8 p)
    public int ledigeTimer() {
        int ledigeTimer = maksAntalTimer;
        for (Vagt vagt : vagter) {
            ledigeTimer -= vagt.getTimer();
        }
        return ledigeTimer;
    }
    //-------------------------------------------------------------------------

    // Del af S8 (13 p)
    public String gaveBeskrivelse() {
        if (vagter.size() > 0)
            return navn + "\t" + "1";
        else
            return navn + "\t" + "0";
    }

    //-------------------------------------------------------------------------

    // til brug i gui
    @Override
    public String toString() {
        return navn + " " + mobil + ", maks. " + maksAntalTimer + " timer";
    }
}
