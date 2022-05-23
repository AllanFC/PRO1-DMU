package Opg05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    private String filePath;

    public FileUtil(String filePath){
        this.filePath = filePath;
    }

    public int max(String fileName){
        int max = 0;
        File in = new File(filePath + "/" + fileName + ".txt");
        try(Scanner scanner = new Scanner(in)){
            max = scanner.nextInt();
            while(scanner.hasNextInt()){
                int d = scanner.nextInt();
                if(d > max){
                    max = d;
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("Hej jeg er en fejl");
        }
        return max;
    }

    public int min(String fileName){
        int min = 0;
        File in = new File(filePath + "/" + fileName + ".txt");
        try(Scanner scanner = new Scanner(in)){
            min = scanner.nextInt();
            while(scanner.hasNextInt()){
                int d = scanner.nextInt();
                if(d < min){
                    min = d;
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("Hej jeg er en fejl");
        }
        return min;
    }

    public double average(String fileName) throws IOException{
        double sum = 0;
        int counter = 0;
        File in = new File(filePath + "/" + fileName + ".txt");
        try(Scanner scanner = new Scanner(in)){
            while(scanner.hasNextInt()){
                int d = scanner.nextInt();
                sum += d;
                counter++;
            }
        } catch(IOException ex){
            throw new IOException("Hej jeg er en fejl");
        }
        return sum / counter;
    }
}
