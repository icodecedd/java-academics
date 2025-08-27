package java_lesson5;

import java.util.Scanner;

public class Lesson5Example5Main {
    static Scanner scan = new Scanner(System.in);
    static String course;
    static int year, sect;

    public static void main(String[] args) {
        String snum, sname;

        snum = method_InputStudNum();
        sname = method_InputStudName();
        method_InputCourseYrSec();
        method_OutputInfo(snum, sname);
        method_GetCrsYrSec();
    }


    private static void method_GetCrsYrSec()
    {
        Lesson5Example5Sub1 stud = new Lesson5Example5Sub1(course,year,sect);
        String crs;
        int yr, sec;
        crs = stud.getCourse();
        yr = stud.getYear();
        sec = stud.getSection();
        System.out.println("Course: " + crs);
        System.out.println("Year: " + yr);
        System.out.println("Section: " + sec);
    }


    public static String method_InputStudNum()
    {
        System.out.print("Student Number: ");
        String sno = scan.nextLine();
        return sno;
    }

    public static String method_InputStudName()
    {
        System.out.print("Student Name: ");
        String sna = scan.nextLine();
        return sna;
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

    public static void method_OutputInfo(String snum, String sname)
    {
        Lesson5Example5Sub1 stud = new Lesson5Example5Sub1(snum, sname);
        System.out.println("\nStudent Number: " + stud.getStudNum());
        System.out.println("Student Name: " + stud.getStudName());
    }

}
