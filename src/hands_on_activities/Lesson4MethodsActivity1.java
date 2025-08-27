package hands_on_activities;

import java.util.Scanner;

public class Lesson4MethodsActivity1 {
    static Scanner scan = new Scanner(System.in);
    static String name;
    static double distance = 0;
    static char type;
    static double totalFare = 0;
    static double discount = 0;
    static String typeName;
    static double totFare = 0;

    public static void inputInfo() {
        System.out.print("Passenger Name: ");
        name = scan.nextLine();
        System.out.print("Distance: ");
        distance = scan.nextDouble();
        System.out.print("Type: ");
        type = scan.next().charAt(0);
    }

    public static double calcFare(double distance) {
        if (distance > 2) {
            if (distance%2 == 0)
                totalFare = (distance - 2) * 7.50 + 60;
            else
                totalFare = ((int) distance - 2 + 1) * 7.50 + 60;
        }
        else
            totalFare = 60;
        return (totalFare);
    }

    public static void officialReceipt(double distance, double totFare, char type) {
        if (type == 'S' || type == 's') {
            discount = totFare * 0.20;
            typeName = "Senior";
        }
        else if (type == 'P' || type == 'p') {
            discount = totFare * 0.15;
            typeName = "PWD";
        }
        else if (type == 'T' || type == 't') {
            discount = totFare * 0.10;
            typeName = "Student";
        }
        else if (type == 'R' || type == 'r'){
            discount = 0;
            typeName = "Regular";
        }
        else
            System.out.println("Invalid Input: [S, P, T, R]");
        double finalFare = totFare - discount;

        System.out.println("\nOfficial Receipt\n");
        System.out.println("Passenger Name: " + name);
        System.out.println("Type of Passenger: " + typeName);
        System.out.printf("Total Fare: %.2f\n", totFare);
        System.out.printf("Discount: %.2f\n", discount);
        System.out.printf("Total Amount: %.2f", finalFare);
    }
}