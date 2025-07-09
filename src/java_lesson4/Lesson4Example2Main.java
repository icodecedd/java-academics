package java_lesson4;
import java.util.Scanner;
public class Lesson4Example2Main {

    static Scanner scan = new Scanner(System.in);
    static Lesson4Example2Sub1 multi = new Lesson4Example2Sub1();
    static String studNum, studName;
    static float midGrade, finGrade, aveGrade;
    public static void main(String[] args) {
        method_inputNumName();
        method_inputGrades();
        method_Multithread();
    }

    private static void method_Multithread() {
        multi.studNumber(studNum);
        multi.studName(studName);
        multi.method_ComputeGrades(midGrade, finGrade);
        multi.method_Outputs();
    }


    private static void method_inputGrades() {
        System.out.print("Midterm Grade: ");
        midGrade = scan.nextFloat();
        System.out.print("Final Grade: ");
        finGrade = scan.nextFloat();
    }


    public static void method_inputNumName()
    {
        System.out.print("Student Number: ");
        studNum = scan.nextLine();
        System.out.print("Student Name: ");
        studName = scan.nextLine();
    }

}
