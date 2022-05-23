package exceptions;

import java.util.Scanner;

// exception in getInt() an in main; both caught in main
public class ParseInt3 {

	public static void main(String[] args) {
		try {
			int num = getInt();
			System.out.println(num);
			int a = 12 / num;
			System.out.println(a);
		} catch (NumberFormatException ex) {
			System.out.println("Not a number");
		} catch (ArithmeticException ex) {
			System.out.println("Error: Division by zero.");
		}

		System.out.println("SLUT");
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
