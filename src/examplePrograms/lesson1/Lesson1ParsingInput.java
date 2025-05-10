package examplePrograms.lesson1;

public class Lesson1ParsingInput {
	
	public static void main(String[] args) {
		String firstname, lastname;
	    int age;
	    double weight;
        firstname = args[0];
	    lastname = args[1];
	    age = Integer.parseInt(args[2]);
	    weight = Double.parseDouble(args[3]);
		System.out.println("Your Name is: " + firstname + " " + lastname);
	    System.out.println("Your Age is: " + age);
	    System.out.println("Your Weight is: " + weight);

	}

}
