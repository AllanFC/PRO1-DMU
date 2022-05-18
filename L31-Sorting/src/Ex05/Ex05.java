package Ex05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>(List.of(
                new Customer("Nikolaj", "Jensen", 39),
                new Customer("Jens", "Jensen", 19),
                new Customer("Allan", "Iversen", 21),
                new Customer("Rasmus", "BananaHammock", 26),
                new Customer("Hans", "Hansen", 22)));

        Collections.sort(customers);
        System.out.println(customers);
    }
}
