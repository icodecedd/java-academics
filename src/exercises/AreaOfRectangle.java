package exercises;

import java.util.Scanner;

public class AreaOfRectangle {
	public static void main(String[] args) {
		// Create a Scanner object for user input
		Scanner scanner = new Scanner(System.in);
		char answer = 'Y'; // Variable to control the loop

		// Loop to allow repeated calculations
		while (answer == 'Y' || answer == 'y') {        
			// Prompt user for width
			System.out.print("Enter Width: ");
			double width = scanner.nextDouble();

			// Prompt user for length
			System.out.print("Enter Length: ");
			double length = scanner.nextDouble();

			// Calculate the area of the rectangle
			double area = width * length;

			// Display the calculated area
			System.out.println("Area: " + area);

			// Ask the user if they want to use the program again
			System.out.print("Use Again [Y][N]: ");
			answer = scanner.next().charAt(0);
		}

		// Inform the user that the program is closing
		System.out.println("Closing Program...");

		// Close the scanner to release resources
		scanner.close();
	}
}
