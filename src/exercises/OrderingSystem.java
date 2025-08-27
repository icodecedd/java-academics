package exercises;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderingSystem {
    static Scanner scan = new Scanner(System.in);
    static double total = 0;
    static double finalTotal = 0;

    // List of available items with their prices
    static String[] availableItems = {
            "Ice Cream ----- ₱20.00",
            "Burger -------- ₱35.00",
            "Fries --------- ₱30.00",
            "Sandwich ------ ₱25.00",
            "Tacos --------- ₱40.00",
            "Pizza --------- ₱50.00",
            "Drinks -------- ₱15.00"
    };

    // Displays the kiosk header and initializes the receipt file
    public static void headerKiosk() {
        System.out.println("-----Welcome to Kiosk-----");
        for (int item = 0; item < availableItems.length; item++) {
            System.out.printf("(%d) %s\n", item + 1, availableItems[item]);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt"))) {
            writer.write(
                    """
                            :================================================:
                                             CUSTOMER RECEIPT
                            :================================================:
                             Code         Item         Quantity       Price/₱
                            --------------------------------------------------
                            """);
        } catch (IOException e) {
            System.out.println("Failed to save receipt. Please try again.");
        }
    }

    // Takes the user's order and validates the input
    public static int[] takeOrder(String[] availableItems) {
        int numItem;
        while (true) {
            try {
                System.out.print("\nEnter Item Number: ");
                numItem = scan.nextInt();
                if (numItem <= 0 || numItem > availableItems.length) {
                    System.out.println("Invalid Input. Please try again.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please try again.");
                scan.next(); // Clear invalid input
            }
        }

        int numQuantity;
        while (true) {
            try {
                System.out.print("Enter Quantity: ");
                numQuantity = scan.nextInt();
                if (numQuantity <= 0) {
                    System.out.println("Invalid Input. Please try again.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please try again.");
                scan.next(); // Clear invalid input
            }
        }

        return new int[]{numItem, numQuantity};
    }

    // Calculates the total cost for the selected item and updates the receipt
    public static String calculateTotal(int numItems, int numQuantity) {
        double[] itemPrices = {20.00, 35.00, 30.00, 25.00, 40.00, 50.00, 15.00};
        String[] codeName = {"0598", "2345", "1002", "4652", "7485", "9876", "8765"};
        String[] itemName = {"Ice Cream", "Burger", "Fries", "Sandwich", "Tacos", "Pizza", "Drinks"};

        total = itemPrices[numItems - 1] * numQuantity;
        finalTotal += total;

        System.out.printf("Total cost: ₱%.2f\n", total);

        return String.format(" %-9s %-9s          %02d           %.2f\n",
                codeName[numItems - 1], itemName[numItems - 1], numQuantity, itemPrices[numItems - 1]);
    }

    // Appends the receipt details to the receipt file
    public static void printReceipt(String receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt", true))) {
            writer.write(receipt);
            System.out.println("Transaction complete. Receipt saved.");
        } catch (IOException e) {
            System.out.println("Failed to save receipt. Please try again.");
        }
    }

    // Handles the payment process and calculates change
    public static void kioskPayment() {
        double payment;
        System.out.printf("\nSub Total: %.2f", finalTotal);

        while (true) {
            System.out.print("\nEnter Payment: ");
            payment = scan.nextDouble();
            if (payment < finalTotal) {
                System.out.println("Insufficient Funds. Please try again.");
            } else {
                break;
            }
        }

        double changeAmount = payment - finalTotal;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt", true))) {
            String paymentString = String.format("\nPayment:    %.2f", payment);
            String changeString = String.format("\nChange:     %.2f", changeAmount);

            writer.write(paymentString);
            writer.write(changeString);
            writer.write("\n:================================================:");

            System.out.print("Payment successful! Thank you for shopping with us!");
        } catch (IOException e) {
            System.out.println("Failed to save receipt. Please try again.");
        }
    }

    // Main method to run the ordering system
    public static void main(String[] args) {
        headerKiosk();

        while (true) {
            int[] orderDetails = takeOrder(availableItems);
            int numItems = orderDetails[0];
            int numQuantity = orderDetails[1];

            String receipt = calculateTotal(numItems, numQuantity);
            printReceipt(receipt);

            System.out.print("Do you want to add more items? (Y/N): ");
            char answer = scan.next().charAt(0);

            if (answer == 'Y' || answer == 'y') {
                continue;
            } else if (answer == 'N' || answer == 'n') {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt", true))) {
                    String totalString = String.format("  Total:    %.2f", finalTotal);
                    writer.write("\n--------------------------------------------------\n");
                    writer.write(totalString);
                } catch (IOException e) {
                    System.out.println("Failed to save receipt. Please try again.");
                }

                kioskPayment();
                break;
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        }

        scan.close();
    }
}
