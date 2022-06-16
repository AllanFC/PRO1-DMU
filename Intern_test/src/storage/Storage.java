package storage;

import model.Funktion;
import model.Medarbejder;
import model.Vagt;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Funktion> functions = new ArrayList<>();
    private static final ArrayList<Medarbejder> workers = new ArrayList<>();
    private static final ArrayList<Vagt> shifts = new ArrayList<>();

    public static void storeFunction(Funktion function){
        functions.add(function);
    }

    public static void storeWorker(Medarbejder worker){
        workers.add(worker);
    }

    public static void storeShift(Vagt shift){
        shifts.add(shift);
    }

    public static ArrayList<Medarbejder> getWorkers() {
        return new ArrayList<>(workers);
    }

    public static ArrayList<Vagt> getShifts() {
        return new ArrayList<>(shifts);
    }

    public static ArrayList<Funktion> getFunctions() {
        return new ArrayList<>(functions);
    }
}
