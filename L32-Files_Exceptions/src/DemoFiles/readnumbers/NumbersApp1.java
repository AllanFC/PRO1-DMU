package DemoFiles.readnumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersApp1 {

	public static void main(String[] args) {
		File in = new File("L32 Files - Exceptions/src/readnumbers/Numbers.txt");
		try (Scanner scanner = new Scanner(in)) {
			double sum = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				line = line.replaceAll(",",".");
				System.out.println(line);
				try {
					double d = Double.parseDouble(line);
					sum += d;
				} catch (NumberFormatException ex) {
					System.out.println("Not a double.");
				}
			}
			System.out.println("Sum is " + sum);
		} catch (FileNotFoundException ex) {
			System.out.println("Sorry! An unexpected error has occurred.");
			System.out.println("Technical message: " + ex.getMessage());
		}
	}

}
