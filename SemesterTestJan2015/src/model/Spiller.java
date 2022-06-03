package model;

import java.util.ArrayList;

public class Spiller {
    private String name;
    private int year;
    private final ArrayList<Detagelse> participations = new ArrayList<>();

    public Spiller(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Detagelse> getParticipation() {
        return new ArrayList<>(participations);
    }

    public double kampHonorar(){
        int gamesParticipated = 0;
        for(Detagelse e : participations){
            if(!e.isCanceled()){
                gamesParticipated++;
            }
        }
        return gamesParticipated * 10;
    }
}
