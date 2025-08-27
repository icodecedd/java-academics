package hands_on_activities;
import java.util.Scanner;
public class HandsOnActivityMain {

    // these are the global variables used within the HandsOnActivityMain
    static Scanner scanner = new Scanner(System.in);
    static String isValid;
    static int number;
    static String numberString;
    static String status;
    static char[] numberChar;
    static int numberCube;

    // the second method that displays the reverse number
    public static void reverseNumber() {
        // this runs if the isValid condition is "true"
        if (isValid.equals("true")) {
            numberChar = numberString.toCharArray();
            System.out.print("Output: ");
            for (int i = numberString.length() - 1; i>=0; i--) {
                System.out.print(numberChar[i]);
            }
        }
        // else this statement is executed
        else {
            System.out.print("Output: Invalid");
        }
    }

    // overloading method to check if the number is a NICOMACHUS number
    public static String reverseNumber(int number) {
        // allocates a new int[] size for numberInt which is based on the numberString length
        int[] numberInt = new int[numberString.length()];

        // a for loop that converts each numberChar to numberInt
        for (int j=0; j< numberString.length(); j++) {
            numberInt[j] = numberChar[j] - '0';
        }

        // a for loop that computes for the NICOMACHUS by multiplying each number by cube (3)
        for (int k=0; k < numberString.length(); k++) {
            numberCube += numberInt[k] * numberInt[k] * numberInt[k];
        }

        // a condition that checks if the number is NICOMACHUS or NOT
        if (numberCube == number)
            return status = "NICOMACHUS";
        else
            return status = "NOT";
    }
}
