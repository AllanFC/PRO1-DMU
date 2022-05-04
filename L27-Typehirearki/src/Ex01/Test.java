package Ex01;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Mechanic> mechanics = new ArrayList<>(List.of(
                new Mechanic("Eric", "Fantasivej 10", "2017", 160),
                new Mechanic("Hans", "Fantasivej 11", "2015", 170),
                new Foreman("Bob", "Fantasivej 12", "2004", 180, "2016", 2500),
                new Mechanic("Carsten", "Fantasivej 13", "2016", 165),
                new Survoyer("Lars" , "Fantasivej 15", "2010",170)));

        totalWeeklySalary(mechanics);

    }

    public static void totalWeeklySalary(ArrayList<Mechanic> mechanics){
        double sum = 0;
        for(Mechanic e : mechanics){
            System.out.println(e.getName() + " weekly salary: " + e.weeklySalary());
            sum += e.weeklySalary();
        }
        System.out.println("Total weekly payout: " + sum);
    }
}
