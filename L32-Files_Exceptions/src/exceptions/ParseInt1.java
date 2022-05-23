package exceptions;

import java.util.Scanner;

// exception in main(); caught in main()
public class ParseInt1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Type an integer: ");
			String strNumber = scanner.nextLine();
			try {
				int n = Integer.parseInt(strNumber);
				System.out.println(n);
			} catch (NumberFormatException ex) {
				System.out.println("Error: Not an integer.");
				System.out.println("Technical message: " + ex);
			}
			System.out.println("Efter catch");
		}
	}
}
