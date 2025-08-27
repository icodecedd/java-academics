package exercises;

import java.util.Scanner;
import java.lang.Math;

public class BodyMassIndex {

	public static void main(String[] args) {
		
		// Create a Scanner object for user input
		Scanner scanner = new Scanner(System.in);
		
		// Prompt user to input height in meters
		System.out.print("Enter Height [m]: ");
		double height = scanner.nextDouble();
		
		// Prompt user to input weight in kilograms
		System.out.print("Enter Weight [kg]: ");
		double weight = scanner.nextDouble();
		
		// Compute the Body Mass Index (BMI)
		double bodyMassIndex = weight / Math.pow(height, 2);
		System.out.printf("Body Mass Index: %.2f\n", bodyMassIndex);
		
		// Evaluate BMI and provide remarks and suggestions
		if (bodyMassIndex <= 18.5) {
			System.out.println("Remarks: Underweight");
			System.out.println("Must Do: You need to gain weight");
		} else if (bodyMassIndex <= 24.9) {
			System.out.println("Remarks: Normal");
			System.out.println("Must Do: Keep it up");
		} else if (bodyMassIndex <= 29.9) {
			System.out.println("Remarks: Overweight");
			System.out.println("Must Do: You need to lose weight");
		} else if (bodyMassIndex <= 34.9) {
			System.out.println("Remarks: Obese Class 1");
			System.out.println("Must Do: You need to lose weight");
		} else if (bodyMassIndex <= 39.9) {
			System.out.println("Remarks: Obese Class 2");
			System.out.println("Must Do: You need to lose weight");
		} else {
			System.out.println("Remarks: Morbid Obesity");
			System.out.println("Must Do: You need to lose weight");
		}
		
		// Close the scanner to release resources
		scanner.close();
	}
}
