import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex08 {
    public static void main(String[] args) {
        int[] ints = {1,3,61,7,2,12,5};
        System.out.println(swapNumber(ints, 12));
        //System.out.println(Arrays.toString(ints));


        ArrayList<Integer> list = new ArrayList<>(List.of(1,3,61,7,2,12,5));
        System.out.println(swapNumber(list, 12));
        //System.out.println(list);
    }

    public static int swapNumber(int[] array, int number){
        int index = -1;
        int i = 0;
        while(index == -1 && i < array.length){
            if(array[i] == number){
                if(i > 0) {
                    int t = array[i];
                    array[i] = array[i-1];
                    array[i-1] = t;
                    index = i - 1;
                } else {
                    index = i;
                }
            } else{
                i++;
            }
        }
        return index;
    }

    public static int swapNumber(ArrayList<Integer> list, int number){
        int index = -1;
        int id = list.indexOf(number);
        if(id > 0) {
            list.set(id, list.set(id - 1, list.get(id)));
            index = id - 1;
        }else{
            index = id;
        }

        return index;
    }
}
