/**
 * Main class for managing student grades.
 * <p>
 * This program allows users to input student details (student number and name)
 * and their grades (midterm and final). It then calculates and displays
 * the average grade.
 * </p>
 *
 * This class interacts with:
 * - Lesson5Example1Sub1 (Handles student number and name)
 * - Lesson5Example1Sub2 (Handles grade-related operations)
 */

package java_lesson4;
import java.util.Scanner;

public class Lesson4Example1Main {

    static Scanner scan = new Scanner(System.in);
    static Lesson4Example1Sub1 cls_NumName = new Lesson4Example1Sub1();
    static Lesson4Example1Sub2 cls_grd= new Lesson4Example1Sub2();
    static float midGrd, finGrd;
    public static void main(String[] args) {
        String snum, sname;
        //float mid, fin;
        System.out.print("Student Number: ");
        snum = scan.nextLine();
        System.out.print("Student Name: ");
        sname = scan.nextLine();
        method_NumName(snum, sname);
        method_InputGrades();
        cls_grd.midGrade(midGrd);
        cls_grd.finGrade(finGrd);
        System.out.println("Midtrerm Grade: " + cls_grd.midGrade());
        System.out.println("Final Grade: " + cls_grd.finGrade());
        System.out.println("Average Grade: " + cls_grd.aveGrade());
    }

    public static void method_NumName(String sno, String sna)
    {	String snum, sname;
        cls_NumName.studNumber(sno);
        snum = cls_NumName.studNo();
        System.out.println("Student Name: " + snum);
        cls_NumName.studName(sna);
        sname = cls_NumName.studNa();
        System.out.println("Student Name: " + sname);
    }

    public static void method_InputGrades()
    {
        System.out.print("Midterm Grade: ");
        midGrd = scan.nextFloat();
        System.out.print("Final Grade: ");
        finGrd = scan.nextFloat();
    }
}
