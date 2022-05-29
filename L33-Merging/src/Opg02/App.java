package Opg02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println(linFileSearchPerson("personer.txt", "Thomsen"));
    }

    public static String linFileSearchPerson(String fileName, String target){
        String str = "";
        File filein = new File("L33-Merging/src/Opg2/" + fileName);
        boolean found = false;
        try (Scanner scan = new Scanner(filein)) {
            while (!found && scan.hasNext()) {
                String[] k = scan.nextLine().split(" ");
                if (k[2].equals(target)) {
                    found = true;
                    str = k[1] + " " + k[2];
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found dummy");
        }
        return str;
    }
}
