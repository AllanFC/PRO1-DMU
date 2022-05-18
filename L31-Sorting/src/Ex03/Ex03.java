package Ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        String[] str = {"Nikolaj", "Allan","Kasper","Rasmus","Hans"};
        System.out.println(Arrays.toString(insertionsortArray(str)));

        ArrayList<Customer> customers = new ArrayList<>(List.of(
                new Customer("Nikolaj", "Jensen", 39),
                new Customer("Jens", "Jensen", 19),
                new Customer("Allan", "Iversen", 21),
                new Customer("Rasmus", "BananaHammock", 26),
                new Customer("Hans", "Hansen", 22)));

        System.out.println(insertionsortCustomer(customers));


    }

    public static String[] insertionsortArray(String[] unsorted){
        for (int i = 1; i < unsorted.length; i++) {
            String temp = unsorted[i];
            int j = i;
            while (j > 0 && temp.compareTo(unsorted[j-1]) < 0) {
                unsorted[j] = unsorted[j-1];
                j--;
            }
            unsorted[j] = temp;
        }
        return unsorted;
    }

    public static ArrayList<Customer> insertionsortCustomer(ArrayList<Customer> unsorted){
        for (int i = 1; i < unsorted.size(); i++) {
            Customer temp = unsorted.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(unsorted.get(j-1)) < 0) {
                unsorted.set(j,unsorted.get(j-1));
                j--;
            }
            unsorted.set(j,temp);
        }
        return unsorted;
    }
}
