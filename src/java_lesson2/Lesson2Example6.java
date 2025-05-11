package java_lesson2;

import java.util.*;

public class Lesson2Example6 {
	
	// Panagram is a string that contains all the letters of the alphabet
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Sentence: ");
        String msg = scan.nextLine().toLowerCase(); // Convert to lowercase for case insensitivity

        boolean[] alphabet = new boolean[26]; // Array to track letters a-z
        int count = 0;

        for (char ch : msg.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a'; // Convert letter to index (0-25)
                if (!alphabet[index]) { // If letter is not counted yet
                    alphabet[index] = true;
                    count++; // Count unique letters
                }
            }
        }

        if (count == 26)
            System.out.println("Sentence is a Pangram!");
        else
            System.out.println("Sentence is NOT a Pangram!");


	}

}
