package examplePrograms.lesson1;

import java.io.*;

public class Lesson1BufferedReader {

    public static void main(String[] args) throws IOException {
        String firstname, lastname;
        int age;
        double weight;

        BufferedReader buffread = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter firstname: ");
        firstname = buffread.readLine();

        System.out.print("Enter lastname: ");
        lastname = buffread.readLine();

        System.out.print("Enter age: ");
        age = Integer.parseInt(buffread.readLine());

        System.out.print("Enter weight: ");
        weight = Double.parseDouble(buffread.readLine());

        System.out.println("Your Name is: " + firstname + " " + lastname);
        System.out.println("Your Age is: " + age);
        System.out.println("Your Weight is: " + weight);
    }
}
