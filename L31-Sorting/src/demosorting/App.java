package demosorting;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] numbers = {11, 3, 2, 5, 17, 9, 30, 15, 2, 4, 11, 10};
        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        int[] numbers1 = {11, 3, 2, 5, 17, 9, 30, 15, 2, 4, 11, 10};
        bubbleSort(numbers1);
        System.out.println("Sorted with bubble sort:");
        System.out.println(Arrays.toString(numbers1));
        System.out.println();

        int[] numbers2 = {11, 3, 2, 5, 17, 9, 30, 15, 2, 4, 11, 10};
        selectionSort(numbers2);
        System.out.println("Sorted with selection sort:");
        System.out.println(Arrays.toString(numbers2));
        System.out.println();

        int[] numbers3 = {11, 3, 2, 5, 17, 9, 30, 15, 2, 4, 11, 10};
        insertionSort(numbers3);
        System.out.println("Sorted with insertion sort:");
        System.out.println(Arrays.toString(numbers3));
        System.out.println();

        //---------------------------------------------------------------------

        Player[] players = {
                new Player("Per", 11), new Player("Hans", 3), new Player("Ib", 2),
                new Player("Jens", 5), new Player("Pia", 17), new Player("Ulla", 9),
                new Player("Per", 30), new Player("Hans", 15), new Player("Per", 2),
                new Player("Pia", 4), new Player("Mike", 11), new Player("Ea", 10)};
        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(players));
        System.out.println();

        App.insertionSort(players);
        System.out.println("Sorted with insertion sort:");
        System.out.println(Arrays.toString(players));
        System.out.println();

        Arrays.sort(players);
        System.out.println("Sorted with Arrays.sort():");
        System.out.println(Arrays.toString(players));
        System.out.println();
    }

    //---------------------------------------------------------------------

    public static void bubbleSort(int[] arr) {
        // 'arr' consists of an unsorted part followed by a sorted part
        // 'i' is the index of the last number in the unsorted part
        for (int i = arr.length - 1; i > 0; i--) {
            // bubble the largest value in arr[0..i] up to arr[i]
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        // 'arr' consists of a sorted part followed by an unsorted part
        // 'i' is the index of the first number in the unsorted part
        for (int i = 0; i < arr.length - 1; i++) {
            // find the index of the smallest number in arr[i..arr.length-1]
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            // swap arr[indexOfMin] and arr[i]
            if (indexOfMin != i) {
                int temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        // 'arr' consists of a sorted part followed by an unsorted part
        // 'i' is the index of the first number in the unsorted part
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            // move values larger than temp in the sorted part up one position;
            // this will create an free position for temp
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // insert temp at the free position
            arr[j] = temp;
        }
    }

    //---------------------------------------------------------------------

    public static void insertionSort(Player[] arr) {
        // 'arr' consists of a sorted part followed by an unsorted part
        // 'i' is the index of the first number in the unsorted part
        for (int i = 1; i < arr.length; i++) {
            Player temp = arr[i];
            // move values larger than arr[i] in the sorted part up one position;
            // this will create an empty position for arr[i]
            int j = i;
            while (j > 0 && temp.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            // insert arr[i] at the empty position
            arr[j] = temp;
        }
    }
}