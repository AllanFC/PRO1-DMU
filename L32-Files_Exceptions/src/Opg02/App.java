package Opg02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File in = new File("L32-Files_Exceptions/src/Opg01/numbers.txt");
        ArrayList<Integer> numbers = new ArrayList<>();

        try (Scanner sc = new Scanner(in)){
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                numbers.add(number);
            }
        } catch(FileNotFoundException ex){
            System.out.println("File not found");
            System.out.println("Technical message: " + ex);
        }
        for(int i = numbers.size()-1; i >= 0; i--){
            System.out.print(numbers.get(i) + " ");
        }
    }
}
