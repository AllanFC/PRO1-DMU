package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp {
    private String place;
    private LocalDate date;
    private LocalTime time;

    private final ArrayList<Detagelse> participations = new ArrayList<>();

    public Kamp(String place, LocalDate date, LocalTime time) {
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public ArrayList<Detagelse> getParticipation() {
        return new ArrayList<>(participations);
    }

    public void createParticipation(boolean canceled, String reason, Spiller player){
        Detagelse participation = new Detagelse(canceled, reason, player);
        participations.add(participation);
    }
}
