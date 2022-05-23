package DemoFiles.readlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextLinesApp {

	public static void main(String[] args) {
		System.out.println("User Directory = " + System.getProperty("user.dir"));

		File in = new File("L32 Files and Exceptions/src/readlines/Test.txt"); // use "/" or "\\", not "\"
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
			System.out.println(19*19);

		} catch (FileNotFoundException ex) {
			System.out.println("Sorry! An unexpected error has occurred.");
			System.out.println("Technical message: " + ex.getMessage());
		}
	}

}
