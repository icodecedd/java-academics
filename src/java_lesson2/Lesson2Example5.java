package java_lesson2;

import java.util.*;

public class Lesson2Example5 {
	
	// reverses the input string
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String word; int j=0;
		System.out.print("String: ");
		word = scan.nextLine();
		char rev[] = new char[word.length()];
		char revWord[] = new char[word.length()];
		System.out.println("Origianl String: " + word);
		rev = word.toCharArray();
		
		for(int i=rev.length-1; i>-1; i--)
		{
			revWord[j] = rev[i];
			j++;
		}
		System.out.print("Reverse String: ");
		String revString = new String(revWord); // converts array of char to String object
		System.out.println(revString);
		
		//for(int i=0; i<revWord.length; i++) // displays the array of char
			//System.out.print(revWord[i]);

	}
}
