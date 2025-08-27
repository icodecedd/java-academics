package hands_on_activities;

import java.util.Scanner;

public class Lesson5Activity2 {
    static Scanner scanner = new Scanner(System.in);
    static Lesson5Activity1 activity1 = new Lesson5Activity1();
    static String empNo, empNa;
    static String timeIn, timeOut;
    static String[] employees;
    static String[] time;
    static String timesIn, timesOut;
    static int hours1, hours2;
    static int minutes1, minutes2;
    static int[] finalTimeIn;
    static int[] finalTimeOut;
    static double rateHour;
    static double grossPay;

    public static void main(String[] args) {

        System.out.print("Employee Number: ");
        empNo = scanner.nextLine();
        System.out.print("Employee Name: ");
        empNa = scanner.nextLine();
        System.out.print("Time-in: ");
        timeIn = scanner.nextLine();
        System.out.print("Time-out: ");
        timeOut = scanner.nextLine();
        System.out.print("Rate per Hour: ");
        rateHour = scanner.nextDouble();

        activity1.setEmployee(empNo, empNa);
        activity1.setTime(timeIn, timeOut);
        activity1.setRatePerHour(rateHour);
        employees = activity1.getEmployee();
        time = activity1.getTime();
        timesIn = time[0];
        timesOut = time[1];
        hours1 = Integer.parseInt(timesIn.substring(0, 2));
        minutes1 = Integer.parseInt(timesIn.substring(2, 4));
        hours2 = Integer.parseInt(timesOut.substring(0, 2));
        minutes2 = Integer.parseInt(timeOut.substring(2,4));
        boolean a =  hours1 >= 0 && hours1 <= 23 && minutes1 >= 0 && minutes1 <= 59;
        boolean b = hours2 >= 0 && hours2 <= 23 && minutes2 >= 0 && minutes2 <= 59;
        finalTimeIn = activity1.convertTime(hours1, minutes1);
        finalTimeOut = activity1.convertTime(hours2, minutes2);
        String period1 = (hours1 < 12) ? "AM" : "PM";
        String period2 = (hours2 < 12) ? "AM" : "PM";
        int totalTimes = activity1.computeTime(hours1, hours2);
        grossPay = activity1.computeGrossPay(rateHour, totalTimes);

        if (a && b) {
            if (hours2 > hours1) {
                System.out.println("Output: ");
                System.out.println("Employee Number: " + employees[0]);
                System.out.println("Employee Name: " + employees[1]);
                System.out.printf("Time-in: %d:%02d %s", finalTimeIn[0], finalTimeIn[1], period1);
                System.out.printf("\nTime-out: %d:%02d %s", finalTimeOut[0], finalTimeOut[1], period2);
                System.out.println("\nNumber of Hours: " + totalTimes);
                System.out.printf("Gross Pay: %.2f", grossPay);
            }
            else {
                System.out.println("Invalid Inputs");
            }
        }
        else {
            System.out.println("Invalid Inputs");
        }
        scanner.close();
    }
}
