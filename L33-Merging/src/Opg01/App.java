package Opg01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println(linFileSearch("talfil.txt", 982));
    }

    public static boolean linFileSearch(String fileName, int target){
        File filein = new File("L33-Merging/src/Opg1/" + fileName);
        boolean found = false;
        try (Scanner scan = new Scanner(filein)) {
            while (!found && scan.hasNext()) {
                int k = scan.nextInt();
                if (k == target) {
                    found = true;
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found dummy");
        }
        return found;
    }
}
