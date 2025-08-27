package exercises;

import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for student name
        System.out.print("Enter Student Name: ");
        String studName = input.nextLine();

        // Prompt user for midterm grade
        System.out.print("Enter Midterm Grade: ");
        double midtermGrade = input.nextDouble();

        // Prompt user for final grade
        System.out.print("Enter Final Grade: ");
        double finalGrade = input.nextDouble();

        // Calculate the average grade
        double averageGrade = (midtermGrade + finalGrade) / 2;

        // Determine remarks based on average grade
        String remarks;
        if (averageGrade <= 3.12) {
            remarks = "Passed";
        } else {
            remarks = "Failed";
        }

        // Display the student summary
        System.out.println("\n------Student Summary------");
        System.out.println("Student Name: " + studName);
        System.out.println("Midterm Grade: " + midtermGrade);
        System.out.println("Final Grade: " + finalGrade);
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Remarks: " + remarks);

        input.close(); 
    } // Close the scanner to release resources
}
