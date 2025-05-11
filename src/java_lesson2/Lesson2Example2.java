package java_lesson2;
import java.util.*;
public class Lesson2Example2 {
	// shows some of the string methods
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		char [] msg = {'i', ' ', 'm', 'i', 's', 's', ' ', 'y', 'o', 'u'};
		System.out.print("String 1: ");
		String str1 = scan.nextLine();
		System.out.print("String 2: ");
		String str2 = scan.nextLine();
		
		String str3 = str1 + str2;
		String str4 = str1.concat(str2);
		String str5 = new String(msg);
		
		System.out.println("String 3: " + str3);
		System.out.println("String 4: " + str4);
		System.out.println("String 5: " + str5);
		
		int len = str5.length();
		System.out.println("Length of String 5: " + len);
		char kar1 = str4.charAt(10);
		
		System.out.println("Character at index 10: " + kar1);
		String str6 = str3.substring(5);
		System.out.println("Substring of String 3: " + str6);
		
		int index = str5.indexOf("ss");
		System.out.println("Index of 'ss\': " + index);
		int ind = str3.lastIndexOf('a');
		System.out.println("Last index of 'a\': " + ind);
		
		System.out.print("St1: ");
		String st1 = scan.nextLine();
		System.out.print("St2: ");
		String st2 = scan.nextLine();
		
		boolean bool1 = st1.equals(st2);
		boolean bool2 = st1.equalsIgnoreCase(st2);
		System.out.println("Boolean 1: " + bool1);
		System.out.println("Boolean 2: " + bool2);
		
		String str7 = str3.toUpperCase();
		String str8 = str5.toLowerCase();
		
		System.out.println("String 7: " + str7);
		System.out.println("String 8: " + str8);
		
		int comp1 = st1.compareTo(st2);
		int comp2 = st1.compareToIgnoreCase(st2);
		
		System.out.println("Comp 1: " + comp1);
		System.out.println("Comp 2: " + comp2);
		System.out.print("St3: ");
		String st3 = scan.nextLine();
		System.out.println("Trim St3: " + st3.trim());
		System.out.println("Replace 'e\': " + st3.replace('e', '*'));
		
		char[] kar2 = new char[st1.length()];
		kar2 = st1.toCharArray();
		System.out.print("Array of Characters: ");
		for (int i=0; i<st1.length(); i++)
			System.out.print(kar2[i]);
		System.out.println("\nString contains 'you\': " + str5.contains("you"));
		
	}


}
