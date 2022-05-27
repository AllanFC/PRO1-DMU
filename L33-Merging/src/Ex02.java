import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] s1 = {2,4,6,8,10,12,14};
        int[] s2 = {1,2,4,5,6,9,12,17};

        System.out.println(Arrays.toString(sharedNumbers(s1, s2)));

    }

    public static int[] sharedNumbers (int[] s1, int[] s2){

        int[] result = new int[s1.length];
        int i1 = 0;
        int i2 = 0;
        int counter = 0;
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] < (s2[i2])) {
                i1++;
            }
            else if(s1[i1] > (s2[i2])){
                i2++;
            } else{
                result[counter] = s1[i1];
                i1++;
                i2++;
                counter++;
            }
        }
        int[] resultfitted = new int[counter];
        for(int i = 0; i < counter; i++){
            resultfitted[i] = result[i];
        }
        return resultfitted;
    }
}
