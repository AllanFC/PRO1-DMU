import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        System.out.print("(A) ");
        int[] arrayA = new int[10];
        System.out.print(Arrays.toString(arrayA));

        System.out.println();
        System.out.println();

        System.out.print("(B) ");
        int[] arrayB = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        System.out.print(Arrays.toString(arrayB));

        System.out.println();
        System.out.println();

        System.out.print("(C) ");
        int[] arrayC = new int[10];
        for(int i = 0; i < arrayC.length; i++){
            arrayC[i] = i;
        }
        System.out.print(Arrays.toString(arrayC));

        System.out.println();
        System.out.println();

        System.out.print("(D) ");
        int[] arrayD = new int[10];
        for(int i = 0; i < arrayD.length; i++){
            arrayD[i] = 2 * i + 2;
        }
        System.out.print(Arrays.toString(arrayD));

        System.out.println();
        System.out.println();

        System.out.print("(E) ");
        double[] arrayE = new double[10];
        int j = 1;
        for(int i = 0; i < arrayE.length; i++){
            arrayE[i] = Math.pow(j, 2);
            j++;
        }
        System.out.print(Arrays.toString(arrayE));

        System.out.println();
        System.out.println();

        System.out.print("(F) ");
        int[] arrayF = new int[10];
        for(int i = 0; i < arrayF.length; i++){
            arrayF[i] = i % 2;
        }
        System.out.print(Arrays.toString(arrayF));

        System.out.println();
        System.out.println();

        System.out.print("(G) ");
        int[] arrayG = new int[10];
        int l = 0;
        for(int i = 0; i < arrayG.length; i++){
            if(l > 4){
                l = 0;
            }
            arrayG[i] = l;
            l++;
        }
        System.out.print(Arrays.toString(arrayG));

        System.out.println();
        System.out.println();

        System.out.print("(H) ");
        int[] arrayH = new int[10];
        l = 0;
        for(int i = 0; i < arrayH.length; i++){
            if(i % 2 != 0){
                l += 3;
            } else if(i > 0){
                l++;
            }
            arrayH[i] = l;

        }
        System.out.print(Arrays.toString(arrayH));

        System.out.println();
        System.out.println();

    }
}
