package Opg03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        fletAlleHeltal("fil1.txt", "fil2.txt","merged.txt");
    }

    /**
     * Lav en sorteret fil i fileNameNy, der indeholder alle
     * heltal fra fileName1 og fileName2 (MAX_VALUE skal ikke i
     * resultatet).
     * Pre: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy){
        File fil1 = new File("L33-Merging/src/Opg3/" + fileName1);
        File fil2 = new File("L33-Merging/src/Opg3/" + fileName2);
        File mergedfile = new File("L33-Merging/src/Opg3/" + fileNameNy);

        try(Scanner sc1 = new Scanner(fil1);
            Scanner sc2 = new Scanner(fil2);
            PrintWriter writer = new PrintWriter(mergedfile)){

            int k1 = sc1.nextInt();
            int k2 = sc2.nextInt();
            while(sc1.hasNextInt() && sc2.hasNextInt() && k1 != Integer.MAX_VALUE && k2 != Integer.MAX_VALUE){
                if(k1 < k2){
                    writer.println(k1);
                    k1 = sc1.nextInt();
                } else {
                    writer.println(k2);
                    k2 = sc2.nextInt();
                }
            }
            while(sc1.hasNextInt() && k1 != Integer.MAX_VALUE){
                writer.println(k1);
                k1 = sc1.nextInt();
            }
            while(sc2.hasNextInt() && k2 != Integer.MAX_VALUE){
                writer.println(k2);
                k2 = sc2.nextInt();
            }

        } catch(FileNotFoundException ex){
            System.out.println("File not found dummy");
        }
    }
}
