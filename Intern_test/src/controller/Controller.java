package controller;

import model.Antal;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class Controller {
    //------------------VAGT------------------
    public static Vagt createShift(String name, LocalDateTime startTime, LocalDateTime endTime){
        Vagt shift = new Vagt(name, startTime, endTime);
        Storage.storeShift(shift);
        return shift;
    }

    //------------------Medarbejder------------------
    public static Medarbejder createWorker(String name, int hoursPrDay, LocalTime arrival){
        Medarbejder worker = new Medarbejder(name, hoursPrDay, arrival);
        Storage.storeWorker(worker);
        return worker;
    }

    public static Exception takeShift(Medarbejder worker, Vagt shift){
        try {
            worker.addShift(shift);
        }catch (RuntimeException ex){
            return ex;
        }
        return null;
    }

    //------------------Funktion------------------
    public static Funktion createFunction(String name){
        Funktion function = new Funktion(name);
        Storage.storeFunction(function);
        return function;
    }

    //------------------OTHER------------------

    public static void initStorage(){
        Funktion f1 = createFunction("Filetering");
        Funktion f2 = createFunction("Grøntsager");
        Funktion f3 = createFunction("Sovs og tilbehør");
        Funktion f4 = createFunction("Buffetopfyldning");

        Medarbejder w1 = createWorker("Peter", 6, LocalTime.of(8,0));
        w1.addFunction(f2);
        w1.addFunction(f3);
        w1.addFunction(f4);
        Medarbejder w2 = createWorker("Anne", 8, LocalTime.of(8,0));
        w2.addFunction(f2);
        w2.addFunction(f3);
        w2.addFunction(f4);
        Medarbejder w3 = createWorker("Marie", 6, LocalTime.of(10,0));
        w3.addFunction(f1);
        w3.addFunction(f2);
        w3.addFunction(f4);
        Medarbejder w4 = createWorker("Torben", 8, LocalTime.of(7,0));
        w4.addFunction(f1);
        w4.addFunction(f3);

        Vagt s1 = createShift("Røgede ål til Medarbejderne",
                LocalDateTime.of(2022,6,24,8,0),
                LocalDateTime.of(2022,6,24,12,30));

        s1.antalFunktioner(2, f1);
        s1.antalFunktioner(1, f2);
        s1.antalFunktioner(1, f3);
        s1.antalFunktioner(1, f4);

        w1.addShift(s1);
        w2.addShift(s1);
        w3.addShift(s1);
    }

    public static void udskrivVagtplan(Vagt vagt, String filNavn){
        File file = new File("Intern_test/src/storage" + filNavn + ".txt");

        try (PrintWriter writer = new PrintWriter(file)){
            writer.println("-----------------------------------------------");
            writer.println("" + vagt.getTidFraFormatted() + " " + vagt.getNavn());
            writer.println("-----------------------------------------------");
            writer.println();
            for(Antal e : vagt.getAmountOfFunctions()){
                writer.printf("%s(%d, %d medarbejdere)\n",e.getFunction().getNavn(), e.getAntal(),
                        vagt.antalMedarbejdereMedFunktion(e.getFunction()));
            }
            writer.println();
            writer.print("Medarbejdere: ");
            for(Medarbejder e : vagt.getWorkers()){
                writer.print(e.getNavn() + " ");
            }
            writer.println();
            writer.println("Status: " + vagt.status());
        } catch (FileNotFoundException ex){
            System.out.println("File not found");
            System.out.println("Technical message: " + ex);
        }
    }

}
