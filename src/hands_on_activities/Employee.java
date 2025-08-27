package hands_on_activities;

import java.util.Scanner;

public class Employee {
    int empNum;
    String empName;
    char deptCode;
    String deptName;
    static Scanner scan = new Scanner(System.in);

    //2nd Constructor
    String empStatus, empPosition;
    float empSalary;

    public Employee(int empNum, String empName, char deptCode, String deptName) {
        this.empNum = empNum;
        this.empName = empName;
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    void Employee2(String empStatus, String empPosition, float empSalary) {
        this.empStatus = empStatus;
        this.empPosition = empPosition;
        this.empSalary = empSalary;
    }

    void printEmployees() {
        System.out.println("Employee Number    : " + this.empNum);
        System.out.println("Employee Name      : " + this.empName);
        System.out.println("Department Code    : " + this.deptCode);
        System.out.println("Department Name    : " + this.deptName);
        System.out.println("Employment Status  : " + this.empStatus);
        System.out.println("Employment Position: " + this.empPosition);
        System.out.println("Basic Salary       : " + this.empSalary);
        System.out.println();
    }

    static void inputEmployee(Employee[] employees) {
        int empNum;
        String empName;
        char deptCode;
        String deptName;
        String empStatus;
        String empPosition;
        float empSalary;
        char ans = 'y';
        int count = 0;
        int deptCodeA = 0, deptCodeB = 0, deptCodeC = 0;
        int empStatPerm = 0, empStatProb = 0, empStatCon = 0;
        boolean isFound = false;

        System.out.println("Employee Records:\n");

        while (ans == 'y' && count < 100) {
            while (true) {
                try {
                    System.out.print("Employee Number: ");
                    empNum = Integer.parseInt(scan.nextLine().trim());
                    if (empNum > 0)
                        break;
                    System.out.println("Error: Employee Number must be positive.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid Input! Employee Number must be integer.");
                }
            }
            while (true) {
                System.out.print("Employee Name: ");
                empName = scan.nextLine().trim();
                if (!empName.isEmpty())
                    break;
                System.out.println("Error: Employee Name cannot be empty.");
            }

            while (true) {
                String temp;
                System.out.print("Department Code: ");
                temp = scan.nextLine().trim().toUpperCase();
                if (temp.length() == 1 && !Character.isDigit(temp.charAt(0))) {
                    deptCode = temp.charAt(0);
                    if (deptCode >= 'A' && deptCode <= 'C') {
                        if (deptCode == 'A') deptCodeA++;
                        else if (deptCode == 'B') deptCodeB++;
                        else deptCodeC++;
                        break;
                    }
                    System.out.println("Error: Department Code must be between 'a' and 'z'.");
                }
            }

            while (true) {
                System.out.print("Department Name: ");
                deptName = scan.nextLine().trim();
                if (!deptName.isEmpty())
                    break;
                System.out.println("Error: Department Name cannot be empty.");
            }

            while (true) {
                String[] statusCompare = {"Permanent", "Probationary", "Contractual"};
                System.out.print("Employment Status: ");
                empStatus = scan.nextLine().trim();
                for (String s : statusCompare) {
                    if (empStatus.equalsIgnoreCase(s)) {
                        isFound = true;
                        break;
                    }
                }
                if (!empStatus.isEmpty() && isFound) {
                    if (empStatus.equalsIgnoreCase("Permanent")) empStatPerm++;
                    else if (empStatus.equalsIgnoreCase("Probationary")) empStatProb++;
                    else if (empStatus.equalsIgnoreCase("Contractual")) empStatCon++;
                    break;
                }
                System.out.println("Error: Employment Status cannot be empty.");
            }

            while (true) {
                System.out.print("Employment Position: ");
                empPosition = scan.nextLine().trim();
                if (!empPosition.isEmpty()) break;
                System.out.println("Error: Employment Position cannot be empty.");
            }

            while (true) {
                try {
                    System.out.print("Basic Salary: ");
                    empSalary = Float.parseFloat(scan.nextLine().trim());
                    if (empSalary > 0)
                        break;
                    System.out.println("Error: Employee Salary must be positive.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid Input! Employee Salary must be float.");
                }
            }

            while (true) {
                System.out.print("Continue? [y/n]: ");
                ans = scan.nextLine().trim().toLowerCase().charAt(0);
                System.out.println();
                if (ans == 'y' || ans == 'n')
                    break;
                System.out.println("Error: Choose between 'y' and 'n'.");
            }
            employees[count] = new Employee(empNum, empName, deptCode, deptName);
            employees[count].Employee2(empStatus, empPosition, empSalary);
            count++;
        }

        System.out.println("List of All Employees:\n");
        for (Employee emp : employees) {
            if (emp != null)
                emp.printEmployees();
        }

        System.out.println("Number of Employees per Department:\n");
        System.out.println("Department A: " + deptCodeA);
        System.out.println("Department A: " + deptCodeB);
        System.out.println("Department A: " + deptCodeC);
        System.out.println();
        System.out.println("Number of Employees per Status:\n");
        System.out.println("Status Permanent: " + empStatPerm);
        System.out.println("Status Probation: " + empStatProb);
        System.out.println("Status Contractual: " + empStatCon);
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[100];
        inputEmployee(employees);
    }
}