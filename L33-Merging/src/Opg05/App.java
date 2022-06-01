package Opg05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>(List.of(
                new Customer("Nikolaj", "Jensen", 39),
                new Customer("Jens", "Jensen", 19),
                new Customer("Allan", "Iversen", 21),
                new Customer("Rasmus", "BananaHammock", 26),
                new Customer("Hans", "Hansen", 22)));

        Collections.sort(customers);

        insertCustomer(customers, new Customer("Erik", "Delvi", 47));
        System.out.println(customers);
    }

    /**
     * Indsætter kunde i kunder.
     * Pre: kunder er sorteret
     */
    public static void insertCustomer(ArrayList<Customer> customers, Customer customer){
        int i = 0;
        boolean foundPlace = false;
        while (!foundPlace && i < customers.size()) {
            Customer k = customers.get(i);
            if (k.compareTo(customer) > 0){
                customers.add(i,customer);
                foundPlace = true;
            }
            else{
                i++;
            }
        }
        if(!foundPlace){
            customers.add(customer);
        }
    }
}
