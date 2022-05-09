package Ex03;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Mechanic("Eric", "Fantasivej 10", "2017", 160),
                new Mechanic("Hans", "Fantasivej 11", "2015", 170),
                new Foreman("Bob", "Fantasivej 12", "2004", 180, "2016", 2500),
                new Mechanic("Carsten", "Fantasivej 13", "2016", 165),
                new Survoyer("Lars" , "Fantasivej 15", "2010",170),
                new WorkingBoy("Vladimir", "Fantasivej 13", 60)));

        totalWeeklySalary(employees);

    }

    public static void totalWeeklySalary(ArrayList<Employee> employees){
        double sum = 0;
        for(Employee e : employees){
            System.out.println(e.getName() + " weekly salary: " + e.weeklySalary());
            sum += e.weeklySalary();
        }
        System.out.println();
        System.out.println("Total weekly payout: " + sum);
    }
}
