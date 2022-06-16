package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;

    //Composition Vagt 1 -> 0..* Antal
    private ArrayList<Antal> amountOfFunctions = new ArrayList<>();

    //Association Vagt 0..* <--> 0..* Medarbejder
    ArrayList<Medarbejder> workers = new ArrayList<>(); //OBS package visible

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }
    public String getTidFraFormatted(){
        return tidFra.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }
    public String getTidTilFormatted(){
        return tidTil.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    public ArrayList<Antal> getAmountOfFunctions() {
        return new ArrayList<>(amountOfFunctions);
    }

    public ArrayList<Medarbejder> getWorkers() {
        return workers;
    }

    public void antalFunktioner(int antal, Funktion funktion){
        Antal amount = new Antal(antal, funktion);
        amountOfFunctions.add(amount);
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer){
        Medarbejder worker = null;
        int i = 0;
        while (worker == null && i < workers.size()) {
            Medarbejder k = workers.get(i);
            if (k.getAnkomstTid().equals(tidspunkt) && k.getAntalTimerPrDag() == antalTimer)
                worker = k;
            else
                i++;
        }

        return worker;
    }

    public int beregnTimeforbrug(){
        int amountOfWorkers = workers.size();
        int shiftDuration = (int) tidFra.until(tidTil, ChronoUnit.HOURS);
        return amountOfWorkers * shiftDuration;
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion){
        int amount = 0;
        for(Medarbejder e : workers){
            if(e.getFunctions().contains(funktion)){
                amount++;
            }
        }
        return amount;
    }

    public Medarbejder[] skalAdviseresOmMødetid(){
        ArrayList<Medarbejder> ceoTime = new ArrayList<>();
        for(Medarbejder e : workers){
            if(!tidFra.toLocalTime().equals(e.getAnkomstTid())){
                ceoTime.add(e);
            }
        }
        int counter = 0;
        Medarbejder[] ceoWorkers = new Medarbejder[ceoTime.size()];
        for(Medarbejder e : ceoTime){
            ceoWorkers[counter] = e;
            counter++;
        }
        return ceoWorkers;
    }

    public String status(){
        String resource = "";
        int i = 0;
        while (resource.equals("") && i < amountOfFunctions.size()) {
            Antal k = amountOfFunctions.get(i);
            if (k.getAntal() <= antalMedarbejdereMedFunktion(k.getFunction())){
                resource = "Ressourcer tildelt";
                i++;
            } else {
                resource = "Manglende resourcer";
            }
        }

        return resource;
    }


    @Override
    public String toString() {
        return navn;
    }
}
