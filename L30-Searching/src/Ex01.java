import java.lang.reflect.Array;

public class Ex01 {
    public static void main(String[] args) {
        int[] numbers = {2,4,68,44,8,6,4};

        System.out.println(unevenSearch(numbers));
    }

    public static boolean unevenSearch(int[] array){
        boolean uneven = false;
        int i = 0;
        while(!uneven && i < array.length){
            int k = array[i];
            if(k % 2 != 0){
                uneven = true;
            }else{
                i++;
            }
        }
        return uneven;
    }
}
