package java_lesson1;

import java.util.*;

public class Lesson1Scanner {
	
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		
		String firstname, lastname;
		int age;
		double weight;
		System.out.print("Enter firstname and lastname separated by space: ");
		firstname = console.next();
		lastname = console.nextLine();
		System.out.print("Enter age and weight separated by space: ");
	    age = console.nextInt();
	    weight = console.nextDouble();
	    System.out.println("Your Name is: " + firstname + " " + lastname);
	    System.out.println("Your Age is: " + age);
	    System.out.println("Your Weight is: " + weight);


	}

}
