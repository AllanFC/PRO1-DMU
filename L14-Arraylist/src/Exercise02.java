import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise02 {

    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum1() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);

        // Test of sum() method: correct sum is 61.
        System.out.println("Sum: " + sum(ints));

        // Test of minimum() method: correct minimum is -16.
        System.out.println("Minimum: " + minimum(ints));

        // Test of maximum() method: correct maximum is 45.
        System.out.println("Maximum: " + maximum(ints));

        // Test of average() method: correct average is 7.625.
        System.out.println("Average: " + average(ints));

        // Test of zeroes() method: correct number of zeroes is 2.
        System.out.println("Zeros: " + zeroes(ints));

        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println("Evens: " + evens(ints));
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    /**
     * Return the sum of all numbers in the list.
     * Return 0, if the list is empty.
     */
    public static int sum(ArrayList<Integer> list){
        if(list.isEmpty()){
            return 0;
        }
        int sum = 0;
        for(int e : list){
            sum += e;
        }
        return sum;
    }

    /**
     * Return the minimum of all numbers in the list.
     * Pre: The list is not empty.
     */
    public static int minimum(ArrayList<Integer> list){
        if(list.isEmpty()){
            return 0;
        }
        int minimum = list.get(0);
        for(int e : list){
            if(e < minimum){
                minimum = e;
            }
        }
        return minimum;
    }

    /**
     * Return the maximum of all numbers in the list.
     * Pre: The list is not empty.
     */
    public static int maximum(ArrayList<Integer> list){
        if(list.isEmpty()){
            return 0;
        }
        int maximum = list.get(0);
        for(int e : list){
            if(e > maximum){
                maximum = e;
            }
        }
        return maximum;
    }

    /**
     * Return the average of the numbers in the list.
     * Pre: The list is not empty.
     */
    public static double average(ArrayList<Integer> list){
        if(list.isEmpty()){
            return 0;
        }
        return (double) sum(list) / list.size();
    }

    /** Return the number of zeros in the list. */
    public static int zeroes(ArrayList<Integer> list){
        int zero = 0;
        for(int e : list){
            if(e == 0){
                zero++;
            }
        }
        return zero;
    }

    /** Return a new list containing the even numbers in the list. */
    public static ArrayList<Integer> evens(ArrayList<Integer> list){
        ArrayList<Integer> even = new ArrayList<>();
        for(int e : list){
            if(e % 2 == 0){
                even.add(e);
            }
        }
        return even;
    }
}
