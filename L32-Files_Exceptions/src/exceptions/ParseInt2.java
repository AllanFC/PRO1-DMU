package exceptions;

import java.util.Scanner;

// exception in getInt(); caught in main()
public class ParseInt2 {

    public static void main(String[] args) {
        try {
            int num = getInt();
            System.out.println(num);
        } catch (Exception ex) {
            System.out.println("Sorry. Unexpected internal error.");
            ex.printStackTrace();
        }
    }

    public static int getInt() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Type an integer: ");
            String strNumber = scanner.nextLine();
            int n = Integer.parseInt(strNumber);
            return n;
        }
    }
}
