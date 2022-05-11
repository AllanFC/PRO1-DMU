package Ex04;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<shape> shapes = new ArrayList<>(List.of(
                new Circle(10, 10, 10),
                new Eclipse(30, 30, 20, 10),
                new Square(70, 70, 10),
                new Rectangle(100, 100, 10, 20)));

        figursToString(shapes);
        System.out.println();
        System.out.printf("Total area: %.2f\n", calcTotalArea(shapes));
        parallelShift(shapes, 10);
        figursToString(shapes);

    }

    public static void figursToString(ArrayList<shape> shapes){
        for(shape e : shapes){
            System.out.println(e.toString());
            System.out.printf("  Area: %.2f\n",e.area());
        }
    }

    public static double calcTotalArea(ArrayList<shape> shapes){
        double sum = 0;
        for(shape e : shapes){
            sum += e.area();
        }
        return sum;
    }

    public static void parallelShift(ArrayList<shape> shapes, int amount){
        for(shape e : shapes){
            e.movexPos(amount);
            e.moveyPos(amount);
        }
    }
}
