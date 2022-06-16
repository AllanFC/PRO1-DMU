package model;

public class Antal {
    private int antal;

    //Solo direction association Antal 0..* -> 1 Funktion
    private Funktion function;

    Antal(int antal, Funktion function) { //OBS Package visible
        this.antal = antal;
        this.function = function;
    }

    public int getAntal() {
        return antal;
    }

    public Funktion getFunction() {
        return function;
    }

}
