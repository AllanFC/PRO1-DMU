package Opg03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        File out = new File("L32-Files_Exceptions/src/Opg03/Output.txt");

        try (PrintWriter writer = new PrintWriter(out)){
            for(int i = 0; i < 100; i++){
                if(i % 2 != 0){
                    writer.println(i);
                }
            }
        } catch (FileNotFoundException ex){
            System.out.println("Hej jeg er en fejl");
            System.out.println("Technical message: " + ex);
        }
    }
}
