package DemoFiles.writing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		File out = new File("L32 Files and Exceptions/src/writing/Output.txt");

		try (Scanner scanner = new Scanner(System.in);
				PrintWriter writer = new PrintWriter(out)) {
			System.out.println("Type a decimal number: (end with 0)");
			boolean finished = false;
			while (!finished) {
				try {
					double d = scanner.nextDouble();
					if (d == 0) {
						finished = true;
					} else {
						System.out.println("Typed in: " + d);
						System.out.println();
						writer.println(d);

					}
				} catch (InputMismatchException ex) {
					System.out.println("NOT a decimal number!");
					System.out.println();
					scanner.nextLine();
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("End of program ");
	}
}
