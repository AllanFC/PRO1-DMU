package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime ankomstTid;

    //Association Medarbejder 0..* <--> 0..* Vagt
    private ArrayList<Vagt> shifts = new ArrayList<>();

    //Association Medarbejder 0..* <--> 0..* Funktion
    private ArrayList<Funktion> functions = new ArrayList<>(); //OBS package visible

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime ankomstTid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.ankomstTid = ankomstTid;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getAnkomstTid() {
        return ankomstTid;
    }

    public ArrayList<Vagt> getShifts() {
        return new ArrayList<>(shifts);
    }

    public ArrayList<Funktion> getFunctions() {
        return new ArrayList<>(functions);
    }


//    public void addShift(Vagt shift){
//        shifts.add(shift);
//        shift.workers.add(this);
//    }

    public void addShift(Vagt shift) throws RuntimeException{
        for(Vagt e : shifts){
            if(shift.getTidFra().isBefore(e.getTidFra()) && shift.getTidTil().isAfter(e.getTidFra())){
                throw new RuntimeException("" + shift.getNavn() +
                        " cannot be added because of overlap with " + e.getNavn());
            } else if(shift.getTidFra().isBefore(e.getTidTil()) && shift.getTidTil().isAfter(e.getTidTil())){
                throw new RuntimeException("" + shift.getNavn() +
                        " cannot be added because of overlap with " + e.getNavn());
            } else if(shift.getTidFra().equals(e.getTidFra())){
                throw new RuntimeException("" + shift.getNavn() +
                        " cannot be added because of overlap with " + e.getNavn());
            }
        }
        shifts.add(shift);
        shift.workers.add(this);
    }

    public void addFunction(Funktion function){
        functions.add(function);
        function.workers.add(this);
    }

    @Override
    public String toString() {
        return "" + navn + ", " + "Normal ankomst: " + ankomstTid.toString();
    }
}
