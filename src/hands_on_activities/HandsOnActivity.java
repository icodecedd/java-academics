package hands_on_activities;
import java.util.Scanner;
public class HandsOnActivity {

    // these are the global variables used within the HandsOnActivity
    static Scanner scanner = new Scanner(System.in);
    static String isValid;
    static int number;
    static String numberString;
    static String status;
    static char[] numberChar;
    static int numberCube;

    // a method to ask input and check if the number is Valid
    public static void inputNumber() {
        System.out.print("Input: ");
        number = scanner.nextInt();
        // a condition that checks if the input is a 3 digit positive integer
        if (number >= 100 && number <=999)
            isValid = "true";
        else
            isValid = "false";
        // converts the (int) "number" into String "numberString"
        numberString = Integer.toString(number);
    }

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
        // this is the main method for this class
        public static void main(String[] args){
            inputNumber();
            reverseNumber();
            String status = reverseNumber(number);
            System.out.println("\nOutput: " + status);
        }
}
