package exercises;

import java.util.Scanner;

public class GenWeightedAve {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Display welcome message
        System.out.println("─────────────────────────");
        System.out.println("Welcome to GWA Calculator");
        System.out.println("─────────────────────────");

        // Prompt user for the number of subjects
        System.out.print("Number of Subjects: ");
        int numSubjects = scan.nextInt();
        System.out.println();

        // Initialize variable to store the total of all grades
        double totalGenAve = 0.0;

        // Loop through each subject to get grades
        for (int count = 1; count <= numSubjects; count++) {
            System.out.printf("Subject Grade [%d]: ", count);
            totalGenAve += scan.nextDouble(); // Add each grade to the total
        }

        // Calculate and display the General Weighted Average
        System.out.printf("Gen. Weighted Average: %.2f", totalGenAve / numSubjects);

        // Close the scanner to release resources
        scan.close();
    }
}
