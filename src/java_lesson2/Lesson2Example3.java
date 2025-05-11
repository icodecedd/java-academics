package java_lesson2;

import java.util.*;


public class Lesson2Example3 {
	
	//counts the number of occurence of vowels, consonants, digits, spaces and special characters
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String sentence;
		int vowels = 0, consonants = 0, digits = 0, specials = 0, spaces = 0;
		System.out.print("Enter Sentence: ");
		sentence = scan.nextLine();
		
		for(int i=0; i<sentence.length(); i++) {
			if((sentence.charAt(i) >= 'a') && (sentence.charAt(i) <= 'z'))
				if((sentence.charAt(i) == 'a') || (sentence.charAt(i) == 'e') || (sentence.charAt(i) == 'i') || (sentence.charAt(i) == 'o') || (sentence.charAt(i) == 'u'))
					vowels++;
				else
					consonants++;
			else if ((sentence.charAt(i) >= '0') && (sentence.charAt(i) <= '9'))
				digits++;
			else if (sentence.charAt(i) == ' ')
				spaces++;
			else
				specials++;
		}
		System.out.println();
		System.out.println("Number of Vowels: " + vowels);
		System.out.println("Number of Consonants: " + consonants);
		System.out.println("Number of Digits: " + digits);
		System.out.println("Number of Spaces: " + spaces);
		System.out.println("Number of Specials: " + specials);
		

	}
}
