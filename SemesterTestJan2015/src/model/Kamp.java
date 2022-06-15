package model;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp>{
    private String place;
    private LocalDate date;
    private LocalTime time;

    private final ArrayList<Deltagelse> participations = new ArrayList<>();

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

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public ArrayList<Deltagelse> getParticipation() {
        return new ArrayList<>(participations);
    }

    public Deltagelse createParticipation(boolean canceled, String reason){
        Deltagelse participation = new Deltagelse(canceled, reason);
        participations.add(participation);
        return participation;
    }

    public ArrayList<String> afbud(){
        ArrayList<String> afbud = new ArrayList<>();
        for(Deltagelse e : participations){
            if(e.isCanceled()){
                afbud.add(e.toString());
            }
        }
        return afbud;
    }

    public void spillerHonorar(String tekstFil){
        File matches = new File("SemesterTestJan2015/src/storage/" + tekstFil + ".txt");

        try(PrintWriter writer = new PrintWriter(matches)){
            for(Deltagelse e : participations){
                if(!e.isCanceled()){
                    writer.printf("%s\t%.2f \n", e.player.getName(), e.player.kampHonorar());
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found dummy");
        }
    }

    @Override
    public int compareTo(Kamp match) {
        int biggest;
        if(date.compareTo(match.date) == 0){
            if(time.compareTo(match.time) == 0){
                biggest = place.compareTo(match.place);
            }else{
                biggest = time.compareTo(match.time);
            }
        }else {
            biggest = date.compareTo(match.date);
        }
        return biggest;
    }

    @Override
    public String toString() {
        return place + "\t" + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\t" + time.toString();
    }
}
