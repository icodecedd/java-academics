package exercises;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		// StringBuffer is mutable, which means it is changeable or modifiable
		// Uncomment the following lines to see StringBuffer operations in action
		/*
		StringBuffer sb = new StringBuffer("Hello");
		sb.insert(5, " World"); // Insert " World" at index 5
		sb.delete(0, 6); // Delete characters from index 0 to 6
		sb.replace(0, 0, "Hi "); // Replace specific characters in the StringBuffer
		sb.reverse(); // Reverse the given String in the StringBuffer
		int len = sb.length(); // Returns the length of the StringBuffer
		System.out.println("Length is " + len);
		*/

		// charAt method in Strings
		// This method returns the character located at the specified index/position
		/*
		String s = "Hello World";
		char ch;
		int num = 0;
		ch = s.charAt(num);
		System.out.println("Char at index " + num + " is " + ch);
		*/

		// Count the number of vowels and consonants in the given String
		Scanner scan = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String str = scan.nextLine();

		// Display the entered string
		System.out.println("Word: " + str);

		// Convert the string to lowercase and remove all spaces
		str = str.toLowerCase();
		str = str.replaceAll("\\s+", "");

		// Initialize counters for vowels and consonants
		int vowelsCount = 0, consCount = 0;

		// Loop through each character in the string
		for (int i = 0; i < str.length(); i++) {
			// Check if the character is a vowel
			if (str.charAt(i) == 'a' || 
				str.charAt(i) == 'e' || 
				str.charAt(i) == 'i' || 
				str.charAt(i) == 'o' || 
				str.charAt(i) == 'u') {
				vowelsCount++;
			} else {
				// If not a vowel, it is a consonant
				consCount++;
			}
		}

		// Display the total count of vowels and consonants
		System.out.println("Total Vowels: " + vowelsCount);
		System.out.println("Total Consonants: " + consCount);

		// Close the scanner
		scan.close();
	}
}
