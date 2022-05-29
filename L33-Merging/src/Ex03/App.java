package Ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>(List.of(
                new Customer("Mads", "Jørgensen", 39),
                new Customer("Nikolaj", "Hansen", 31),
                new Customer("Pia", "Rasmussen", 41),
                new Customer("John", "Andersen", 35)));
        Collections.sort(customers);
        Customer[] badCustomers = {new Customer("Troels", "Johansen", 39),
                new Customer("Karsten", "Jakobsen", 31),
                new Customer("Pia", "Rasmussen", 41),
                new Customer("John", "Andersen", 35)};
        Arrays.sort(badCustomers);

        System.out.println(goodCustomers(customers, badCustomers));
    }

    /**
     * Return a sorted ArrayList containing all customers
     * from l1 that are not in l2.
     * Pre: l1 and l2 are sorted and l2 has no empty
     * entries.
     */
    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2){
        ArrayList<Customer> goodCustomers = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) < 0) {
                i1++;
            }
            else if(l1.get(i1).compareTo(l2[i2]) > 0){
                i2++;
            } else{
                goodCustomers.add(l1.get(i1));
                i1++;
                i2++;
            }
        }
        return goodCustomers;
    }
}
