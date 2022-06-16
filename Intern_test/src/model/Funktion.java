package model;

import java.util.ArrayList;

public class Funktion {
    private String navn;

    //Association Funktion 0..* <--> 0..* Medarbejder
    ArrayList<Medarbejder> workers = new ArrayList<>();

    public Funktion(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Medarbejder> getWorkers() {
        return workers;
    }
}
