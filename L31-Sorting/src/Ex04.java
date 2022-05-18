import java.util.ArrayList;
import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        Random r = new Random();
        int[] ints = r.ints(1000, 1, 10000).toArray();
        for (int e : ints) {
            list1.add(e);
        }
        ArrayList<Integer> list2 = new ArrayList<>(list1);
        ArrayList<Integer> list3 = new ArrayList<>(list1);

        long bubbleTimeLong = System.nanoTime();
        bubbleSort(list1);
        double bubbleTime = (double) (System.nanoTime() - bubbleTimeLong)/1000000;
        System.out.printf("Bubblesort time ms: %.2f", bubbleTime);

        System.out.println();

        long SelectionTimeLong = System.nanoTime();
        selectionSort(list2);
        double SelectionTime = (double) (System.nanoTime() - SelectionTimeLong)/1000000;
        System.out.printf("Selectionsort time ms: %.2f", SelectionTime);

        System.out.println();

        long insertionTimeLong = System.nanoTime();
        insertionSort(list3);
        double insertionTime = (double) (System.nanoTime() - insertionTimeLong)/1000000;
        System.out.printf("Insertionsort time ms: %.2f", insertionTime);
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list){
        for (int i = list.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j+1)) {
                    list.set(j+1, list.set(j, list.get(j+1)));
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list){
        for (int i = 0; i < list.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(indexOfMin)) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                list.set(i, list.set(indexOfMin, list.get(i)));
            }
        }
        return list;
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list){
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i;
            while (j > 0 && temp < list.get(j-1)) {
                list.set(j,j-1);
                j--;
            }
            list.set(j, temp);
        }
        return list;
    }
}
