import java.util.Arrays;

public class Ex07 {
    public static void main(String[] args) {
        int[] testArray = {2, 7, 6, 1, 9, 3, 4};
        System.out.println();
        System.out.println("Switch first and last:");
        System.out.println(switchFirstLast(testArray));

        System.out.println();
        System.out.println("Replace even numbers with zero:");
        System.out.println(evenToZero(testArray));

        System.out.println();
        System.out.println("Get second highest number:");
        System.out.println(getSecondHighest(testArray));

        System.out.println();
        System.out.println("Is this array sorted:");
        System.out.println(isSorted(testArray));

        System.out.println();
        System.out.println("Array shift to the right:");
        System.out.println(shiftToRight(testArray));

        System.out.println();
        System.out.println("Does this array have doublets:");
        System.out.println(hasDoublets(testArray));


    }

    public static String switchFirstLast(int[] array){
        int first = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] = first;
        return Arrays.toString(array);
    }

    public static String evenToZero(int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                array[i] = 0;
            }
        }
        return Arrays.toString(array);
    }

    public static int getSecondHighest(int[] array){
        Arrays.sort(array);
        return array[array.length-2];
    }

    public static boolean isSorted(int[] array){
        for(int i = 1; i < array.length - 1; i++){
            if(array[i-1] > array[i]){
                return false;
            }
        }
        return true;
    }

    public static String shiftToRight(int[] array){
        int last = array[array.length-1];
        for(int i = array.length-2; i > 0; i--){
            array[i+1] = array[i];
        }
        array[0] = last;
        return Arrays.toString(array);
    }

    public static boolean hasDoublets(int[] array){
        Arrays.sort(array);
        for(int i = 1; i < array.length - 1; i++){
            if(array[i-1] == array[i]){
                return true;
            }
        }
        return false;
    }
}
