package hands_on_activities;

public class HandsOnActivityInheritance extends HandsOnActivityMain {

    // a method to ask input and check if the number is Valid
    public static void inputNumber() {
        System.out.print("Input: ");
        number = scanner.nextInt();
        if (number >= 100 && number <=999)
            isValid = "true";
        else
            isValid = "false";
        numberString = Integer.toString(number);
    }

    // this is the main method for this class
    public static void main(String[] args) {
        // this use inheritance to inherit the 2nd method of HandsOnActivityMain
        inputNumber();
        HandsOnActivityMain.reverseNumber();

        // this use inheritance to inherit the 3rd method of HandsOnActivityMain
        String status = HandsOnActivityMain.reverseNumber(number);
        System.out.println("\nOutput: " + status);
    }
}
