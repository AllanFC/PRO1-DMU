package Ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        String[] str = {"Nikolaj", "Allan","Kasper","Rasmus","Hans"};
        System.out.println(Arrays.toString(selectsortArray(str)));

        ArrayList<Customer> customers = new ArrayList<>(List.of(
                new Customer("Nikolaj", "Jensen", 39),
                new Customer("Jens", "Jensen", 19),
                new Customer("Allan", "Iversen", 21),
                new Customer("Rasmus", "BananaHammock", 26),
                new Customer("Hans", "Hansen", 22)));

        System.out.println(selectsortCustomer(customers));


    }

    public static String[] selectsortArray(String[] unsorted){
        for (int i = 0; i < unsorted.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[j].compareTo(unsorted[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                String temp = unsorted[i];
                unsorted[i] = unsorted[indexOfMin];
                unsorted[indexOfMin] = temp;
            }
        }
        return unsorted;
    }

    public static ArrayList<Customer> selectsortCustomer(ArrayList<Customer> unsorted){
        for (int i = 0; i < unsorted.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < unsorted.size(); j++) {
                if (unsorted.get(j).compareTo(unsorted.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                unsorted.set(i, unsorted.set(indexOfMin, unsorted.get(i)));
            }
        }
        return unsorted;
    }
}
