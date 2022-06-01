package Opg06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer("Nikolaj", "Jensen", 39),
                new Customer("Jens", "Jensen", 19),
                new Customer("Allan", "Iversen", 21),
                new Customer("Rasmus", "BananaHammock", 26),
                new Customer("Hans", "Hansen", 22),
                null, null};

        Arrays.sort(customers);

        insertCustomer(customers, new Customer("Erik", "Delvi", 47));
        System.out.println(Arrays.toString(customers));
    }

    /**
     * Indsætter kunde i kunder.
     * Pre: kunder er sorteret
     */
    public static void insertCustomer(Customer[] customers, Customer customer){//
        int i = 0;
        boolean foundPlace = false;
        while (i < customers.length) {
            Customer k = customers[i];
            if (k.compareTo(customer) > 0 || k.equals(null)){
                customers[i] = customer;
                foundPlace = true;
                i++;
            }
            else{
                customers[i] = k;
                i++;
            }
        }
    }
}
