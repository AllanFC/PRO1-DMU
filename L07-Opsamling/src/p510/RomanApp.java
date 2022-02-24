package p510;

import java.util.Scanner;

public class RomanApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a year: ");
        Roman convert = new Roman(sc.nextInt());
        System.out.println(convert.convertToRoman());

        sc.close();
    }
}
