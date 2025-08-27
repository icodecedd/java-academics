package exercises;

import java.util.*;

public class TimeConversion {

	// Scanner object to take user input
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int hours, sec, minutes, seconds;

		// Prompt the user to input the number of seconds
		System.out.print("Input Number of seconds: ");
		sec = scan.nextInt();

		// Calculate the number of hours
		hours = sec / 3600; // Corrected divisor to 3600 (seconds in an hour)
		sec -= hours * 3600; // Subtract the hours in seconds from the total seconds

		// Calculate the number of minutes
		minutes = sec / 60; // Calculate minutes from remaining seconds
		seconds = sec - (minutes * 60); // Calculate remaining seconds

		// Display the results
		System.out.println("Number of Hours: " + hours);
		System.out.println("Number of Minutes: " + minutes);
		System.out.println("Number of Seconds: " + seconds);
	}
}
