import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class NumberFileGenerator {
    public static void main(String[] args) {
        int antal = 0;
        String filename = "L32-Files_Exceptions/src/Opg05/";
        try (Scanner scanner = new Scanner(System.in)) {
            while (antal <= 0) {
                try {
                    System.out.println("Filename:");
                    filename += scanner.next();
                    System.out.print("Antal tal der skal skrives i filen: ");
                            antal = scanner.nextInt();
                }
                catch (InputMismatchException ex) {
                    System.out.println("Antal skal være et positivt heltal.");
                }
            }
        }
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            Random rnd = new Random();
            for (int i = 1; i <= antal; i++) {
                int number = rnd.nextInt(10000);
                printWriter.println(number);
            }
            System.out.println("Fil med " + antal + " tal nu er lavet.");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error finding or creating file: " +
                    filename);
        }
    }
}