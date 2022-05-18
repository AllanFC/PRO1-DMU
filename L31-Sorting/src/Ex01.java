import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>(List.of("Nikolaj", "Allan","Kasper","Rasmus","Hans"));
        System.out.println(bubbleSort(strings));
    }

    public static ArrayList<String> bubbleSort(ArrayList<String> unsorted){
        ArrayList<String> sorted = new ArrayList<>(unsorted);
        for (int i = sorted.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sorted.get(j).compareTo(sorted.get(j+1)) > 0) {
                    sorted.set(j, sorted.set(j + 1, sorted.get(j)));
                }
            }
        }
        return sorted;
    }
}
