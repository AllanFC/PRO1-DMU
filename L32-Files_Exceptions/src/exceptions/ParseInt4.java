package exceptions;

import java.util.Scanner;

// exception in getInt(), throws MyFormatException; caught in main()
public class ParseInt4 {

    public static void main(String[] args) {
        try {
            int num = ParseInt4.getInt();
            System.out.println(num);
        } catch (MyFormatException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Caused by: " + ex.getCause());
        }
    }

    public static int getInt() throws MyFormatException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Type an integer: ");
            String strNumber = scanner.nextLine();
            int n = 0;
            try {
                n = Integer.parseInt(strNumber);
            } catch (NumberFormatException ex) {
                throw new MyFormatException("Illegal number string", ex);
            }
            return n;
        }
    }
}
