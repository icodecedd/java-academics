package java_lesson5;

import java.util.*;

public class Lesson5Example6Main {
    static Scanner scan = new Scanner(System.in);
    static String studNum, studName;
    static float mGrd, fGrd;
    static float midGrd, finGrd;

    public static void main(String[] args) {

        method_Inputs();
        method_Outputs();

    }
    private static void method_Outputs()
    {
        float average;
        Lesson5Example5Main.method_OutputInfo(studNum, studName);
        Lesson5Example6Sub1 grades = new Lesson5Example6Sub1(midGrd, finGrd);
        mGrd = grades.getMidGrd();
        fGrd = grades.getFinGrd();
        average = grades.method_ComputeGrade();
        System.out.println("Average: " + average);

    }
    private static void method_Inputs()
    {
        studNum = Lesson5Example5Main.method_InputStudNum();
        studName = Lesson5Example5Main.method_InputStudName();
        System.out.print("Midterm Grade: ");
        midGrd = scan.nextFloat();
        System.out.print("Final Grade: ");
        finGrd = scan.nextFloat();
    }

}
