package hands_on_activities;

import java.util.Scanner;

public class MidtermsProgramWriting {
    String empNum, empName;
    int hours;
    double rate, deductions, grossPay, netPay;

    public MidtermsProgramWriting() {
    }

    public MidtermsProgramWriting(String empNum, String empName, int hours, double rate) {
        this.empNum = empNum;
        this.empName = empName;
        this.hours = hours;
        this.rate = rate;
        System.out.println("Employee Number: " + this.empNum);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Hours Worked: " + this.hours);
        System.out.println("Rate per Hour: " + this.rate);
    }

    public MidtermsProgramWriting(double deductions, double grossPay, double netPay) {
        this.deductions = deductions;
        this.grossPay = grossPay;
        this.netPay = netPay;
        System.out.println("Amount of Deductions: " + this.deductions);
        System.out.println("Gross Pay: " + this.grossPay);
        System.out.println("Net Pay: " + this.netPay);
    }

    public void inputEmployeeInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Employee Number: ");
        empNum = scanner.nextLine();
        System.out.print("Employee Name: ");
        empName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Hours Worked: ");
                hours = Integer.parseInt(scanner.nextLine());
                if (hours < 0) {
                    System.out.println("Error: Hours Worked must be positive.");
                } else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid Input! Hours Worked must be integer." + e);
            }
        }

        while (true) {
            try {
                System.out.print("Rate per Hour: ");
                rate = Double.parseDouble(scanner.nextLine());
                if (rate < 0) {
                    System.out.println("Error: Rate per Hour must be positive.");
                } else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid Input! Rate per Hour must be float." + e);
            }
        }

        scanner.close();
    }

    public void sendEmployeeInfo() {
        new MidtermsProgramWriting(empNum, empName, hours, rate);
    }

    public void inputDeductions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Amount of Deductions: ");
                deductions = Double.parseDouble(scanner.nextLine());
                if (deductions < 0) {
                    System.out.println("Error: Amount of Deductions must be positive.");
                } else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid Input! Amount of Deductions must be float." + e);
            }
        }

        grossPay = hours * rate;
        netPay = grossPay - deductions;

        new MidtermsProgramWriting(deductions, grossPay, netPay);

        scanner.close();
    }

    public static void main(String[] args) {
        MidtermsProgramWriting mid = new MidtermsProgramWriting();

        mid.inputEmployeeInfo();
        mid.inputDeductions();
        mid.sendEmployeeInfo();
    }
}