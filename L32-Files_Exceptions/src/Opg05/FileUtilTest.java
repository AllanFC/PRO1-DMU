package Opg05;

import java.io.IOException;

public class FileUtilTest {
    public static void main(String[] args) {
        FileUtil fu = new FileUtil("L32-Files_Exceptions/src/Opg05");

        System.out.println(fu.max("Number10.txt"));
        System.out.println(fu.min("Number10.txt"));
        try {
            System.out.println(fu.average("Number10.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
