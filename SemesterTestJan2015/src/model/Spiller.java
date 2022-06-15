package model;

import java.util.ArrayList;

public class Spiller {
    private String name;
    private int year;
    private final ArrayList<Deltagelse> participations = new ArrayList<>();

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
    public void Participating(Deltagelse deltagelse){
        participations.add(deltagelse);
        deltagelse.player = this;
    }

    public ArrayList<Deltagelse> getParticipation() {
        return new ArrayList<>(participations);
    }

    public double kampHonorar(){
        int matchesParticipated = 0;
        for(Deltagelse e : participations){
            if(!e.isCanceled()){
                matchesParticipated++;
            }
        }
        return matchesParticipated * 10;
    }
}
