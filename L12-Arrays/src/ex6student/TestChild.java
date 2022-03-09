package ex6student;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestChild {

    public static void main(String[] args) {
        Child b1 = new Child("Emma");
        Child b2 = new Child("Oliver");

        System.out.println(b1.getName());
        System.out.println(b2.getName());

        double[] weight = {4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1, 37.3};

        for(double e : weight){
            b1.addWeight(e);
        }
        System.out.println(Arrays.toString(b1.getWeights()));
        System.out.printf("%.1f", b1.maxYearlyWeightGain());
    }

}
