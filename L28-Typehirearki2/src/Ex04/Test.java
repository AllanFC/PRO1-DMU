package Ex04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Figur> figurs = new ArrayList<>(List.of(
                new Circle(10, 10, 10),
                new Eclipse(30, 30, 20, 10),
                new Square(70, 70, 10),
                new Rectangle(100, 100, 10, 20)));

        figursToString(figurs);
        System.out.println();
        System.out.printf("Total area: %.2f\n", calcTotalArea(figurs));
        parallelShift(figurs, 10);
        figursToString(figurs);

    }

    public static void figursToString(ArrayList<Figur> figurs){
        for(Figur e : figurs){
            System.out.println(e.toString());
            System.out.printf("  Area: %.2f\n",e.area());
        }
    }

    public static double calcTotalArea(ArrayList<Figur> figurs){
        double sum = 0;
        for(Figur e : figurs){
            sum += e.area();
        }
        return sum;
    }

    public static void parallelShift(ArrayList<Figur> figurs, int amount){
        for(Figur e : figurs){
            e.movexPos(amount);
            e.moveyPos(amount);
        }
    }
}
