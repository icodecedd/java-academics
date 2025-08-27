package exercises;

import javax.swing.JOptionPane;

public class CalculatorGui {
    public static void main(String[] args) {
        // Prompt the user to select an operator
        String operator = JOptionPane.showInputDialog(
            "Welcome to Calculator Simulator\nAvailable Operators: +, -, *, /"
        );

        // Prompt the user to enter the first number
        double number1 = Double.parseDouble(
            JOptionPane.showInputDialog("Enter First Number")
        );

        // Prompt the user to enter the second number
        double number2 = Double.parseDouble(
            JOptionPane.showInputDialog("Enter Second Number")
        );

        double result = 0; // Variable to store the result

        // Perform the calculation based on the selected operator
        switch (operator) {
            case "+" -> result = number1 + number2; // Addition
            case "-" -> result = number1 - number2; // Subtraction
            case "*" -> result = number1 * number2; // Multiplication
            case "/" -> {
                // Handle division, ensuring the second number is not zero
                if (number2 == 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Please make sure the Second Number is not 0",
                        "Calculator Simulator",
                        JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    result = number1 / number2; // Division
                }
            }
            default -> {
                // Handle invalid operator input
                JOptionPane.showMessageDialog(
                    null,
                    "Invalid Operator! Please use +, -, *, or /",
                    "Calculator Simulator",
                    JOptionPane.ERROR_MESSAGE
                );
                return; // Exit the program if the operator is invalid
            }
        }

        // Display the result to the user
        JOptionPane.showMessageDialog(
            null,
            "Result: " + result,
            "Calculator Simulator",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
