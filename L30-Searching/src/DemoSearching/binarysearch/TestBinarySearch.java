package DemoSearching.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBinarySearch {

    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 8, 8, 10, 11, 12, 24, 26, 30};
        System.out.println(Arrays.toString(numbers));
        int value = 8;

        int indexInArray = binarySearchArray(numbers, value);
        System.out.printf("Index of %d in the array: %d \n", value, indexInArray);
        System.out.println();

        //---------------------------------------------------------------------

        ArrayList<Kunde> kunder = new ArrayList<>(List.of(
                new Kunde("Hans", 5, 500),
                new Kunde("Jens", 4, 400),
                new Kunde("Peter", 2, 200),
                new Kunde("Pia", 3, 300),
                new Kunde("Ulla", 1, 100)
        ));
        System.out.println(kunder);
        String customerName = "Pia";

        Kunde customer = binarySearchKunde(kunder, customerName);
        System.out.printf("Kunde med navn %s i listen: %s \n", customerName, customer);
    }

    //-------------------------------------------------------------------------

    // Binary search in a sorted array of integers.
    /**
     * Return the index of the target in the array.
     * Return -1, of the target isn't found in the array.
     */
    public static int binarySearchArray(int[] arr, int target) {
        int indeks = -1;
        int left = 0;
        int right = arr.length - 1;
        while (indeks == -1 && left <= right) {
            int middle = (left + right) / 2;
            int k = arr[middle];
            if (k == target)
                indeks = middle;
            else if (k > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return indeks;
    }

    // Binary search in a sorted ArrayList<Kunde>.
    /**
     * Returns the customer with the given name.
     * Returns null, if the customer isn't found in the list.  
     */
    public static Kunde binarySearchKunde(ArrayList<Kunde> list, String name) {
        Kunde kunde = null;
        int left = 0;
        int right = list.size() - 1;
        while (kunde == null && left <= right) {
            int middle = (left + right) / 2;
            Kunde k = list.get(middle);
            if (k.getNavn().compareTo(name) == 0)
                kunde = k;
            else if (k.getNavn().compareTo(name) > 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return kunde;
    }
}
