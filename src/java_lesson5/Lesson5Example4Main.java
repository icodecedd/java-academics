package java_lesson5;

import java.util.Scanner;

public class Lesson5Example4Main {
    static Scanner scan = new Scanner(System.in);
    static Lesson5Example4Sub1 student = new Lesson5Example4Sub1();
    static String course;
    static int year, sect;

    public static void main(String[] args) {
        String snum, sname;

        snum = method_InputStudNum();
        sname = method_InputStudName();
        method_InputCourseYrSec();
        method_setStudInfo(snum, sname);
        method_OutputStudInfo();
        student.method_SetCourseYrSec(course, year, sect);
    }


    private static void method_InputCourseYrSec()
    {
        System.out.print("Course: ");
        course = scan.nextLine();
        System.out.print("Year: ");
        year = scan.nextInt();
        System.out.print("Section: ");
        sect = scan.nextInt();
    }


    private static void method_setStudInfo(String snum, String sname)
    {
        student.setStudNum(snum);
        student.setStudName(sname);
    }

    private static void method_OutputStudInfo()
    {
        System.out.println("\nStudent Number: " + student.getStudNum());
        System.out.println("Student Name: " + student.getStudName());
    }


    private static String method_InputStudNum()
    {
        System.out.print("Student Number: ");
        String sno = scan.nextLine();
        return sno;
    }

    private static String method_InputStudName()
    {
        System.out.print("Student Name: ");
        String sna = scan.nextLine();
        return sna;
    }

}
