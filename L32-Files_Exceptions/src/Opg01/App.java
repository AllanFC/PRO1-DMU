package Opg01;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        File in = new File("L32-Files_Exceptions/src/Opg01/numbers.txt");

        try (Scanner sc = new Scanner(in)){
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                System.out.println(number*2);
            }
        } catch(FileNotFoundException ex){
            System.out.println("File not found");
            System.out.println("Technical message: " + ex);
        }
    }

}
