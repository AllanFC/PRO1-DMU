import java.util.*;

public class Exercise04 {
    public static void main(String[] args) {
        ArrayList<Integer> testArray =  new ArrayList<>(List.of(2, 7, 6, 1, 9, 3, 4));
        ArrayList<Integer> testArray1 =  new ArrayList<>(List.of(2, 7, 6, 1, 9, 3, 4));
        ArrayList<Integer> testArray2 =  new ArrayList<>(List.of(2, 7, 6, 1, 9, 3, 4));
        System.out.println("Original list: " + testArray);
        System.out.println();
        System.out.print("Switch first and last: ");
        switchFirstLast(testArray);
        System.out.println(testArray);

        System.out.println();
        System.out.print("Replace even numbers with zero: ");
        evenToZero(testArray1);
        System.out.println(testArray1);

        System.out.println();
        System.out.print("Get second highest number: ");
        System.out.println(getSecondHighest(testArray));

        System.out.println();
        System.out.print("Is this array sorted: ");
        System.out.println(isSorted(testArray));

        System.out.println();
        System.out.print("Array shift to the right: ");
        shiftToRight(testArray2);
        System.out.println(testArray2);

        System.out.println();
        System.out.print("Does this array have doublets: ");
        System.out.println(hasDoublets(testArray1));


    }

    public static void switchFirstLast(ArrayList<Integer> list){
        list.set(list.size()-1, list.set(0, list.get(list.size()-1)));
    }

    public static void evenToZero(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 == 0){
                list.set(i, 0);
            }
        }
    }

    public static int getSecondHighest(ArrayList<Integer> list){
        int secondHighest = list.get(0);
        int highest = list.get(1);
        if(secondHighest > highest){
            highest = secondHighest;
            secondHighest = list.get(1);
        }
        for(int i = 2; i < list.size(); i++){
            if(list.get(i) >= highest){
                highest = list.get(i);
            } else if (list.get(i) > secondHighest){
                secondHighest = list.get(i);
            }
        }
        return secondHighest;
    }

    public static boolean isSorted(ArrayList<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1) > list.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void shiftToRight(ArrayList<Integer> list){
        list.set(0, list.get(list.size()-1));
        for(int i = list.size()-2; i < 0; i--){
            list.set(i+1, i);
        }
    }

    public static boolean hasDoublets(ArrayList<Integer> list){
        Set<Integer> set = new HashSet<>();
        for (int e : list) {
            if (!set.add(e)) {
                return true;
            }
        }
        return false;

//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1 ; j < list.size(); j++) {
//                if (list.get(i).equals(list.get(j))) {
//                    return true;
//                }
//            }
//        }
//        return false;
    }
}


