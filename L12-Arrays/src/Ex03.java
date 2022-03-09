import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[] a = {4,6,7,2,3};
        int[] b = {4,6,8,2,6};
        System.out.println(Arrays.toString(sumArrays(a, b)));

        int[] c = {4,6,7,2,3};
        int[] d = {4,6,8,2,6,5,7};
        System.out.println(Arrays.toString(sumArraysUnequal(c, d)));
    }

    public static int[] sumArrays(int[] a, int[] b){
        int[] sumArray = new int[a.length];
        for(int i = 0; i < a.length; i++){
            sumArray[i] = a[i] + b[i];
        }
        return sumArray;
    }

    public static int[] sumArraysUnequal(int[] a, int[] b){
        int[] sumArray;
        if(a.length > b.length){
            sumArray = new int[a.length];
            for(int i = 0; i < a.length; i++){
                if(i < b.length){
                    sumArray[i] = b[i] + a[i];
                } else {
                    sumArray[i] = a[i];
                }
            }
        } else {
            sumArray = new int[b.length];
            for(int i = 0; i < b.length; i++){
                if(i < a.length){
                    sumArray[i] = b[i] + a[i];
                }else {
                    sumArray[i] = b[i];
                }
            }

        }
        return sumArray;
    }
}
