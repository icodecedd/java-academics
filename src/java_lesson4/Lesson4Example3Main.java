/**
 * Main class for managing student subjects and grades.
 * <p>
 * This program allows users to input student details (student number and name)
 * along with subjects, units, and grades (midterm and final). It then calculates
 * and displays the general average.
 * </p>
 *
 * This class interacts with:
 * - Lesson5Example3Sub1 - Handles subject-related operations
 * - Lesson5Example3Sub2 - Manages grade computation
 */

package java_lesson4;
import java.util.Scanner;
public class Lesson4Example3Main {

    static Scanner scan = new Scanner(System.in);
    static Lesson4Example3Sub1 objCls2 = new Lesson4Example3Sub1();
    static Lesson4Example3Sub2 objSubjects = new Lesson4Example3Sub2();
    static int[] units = new int[5];
    static String[] subj_code = new String[5];
    static String[] subj = new String[5];
    static float[] midtermgrd = new float[5];
    static float[] finalgrd = new float[5];
    static int i;

    public static void main(String[] args) {
        String studNum, studName;

        studNum = method_InputStudNum();
        studName = method_InputStudName();
        method_InputSubjCode();
        method_callClassSubjectsNumber(studNum);
        method_callClassSubjectsName(studName);
        objSubjects.method_call_clsComputeGenAve();
        objSubjects.methodOutputs();
    }

    private static void method_InputSubjCode()
    {
        for(i=0; i<5; i++)
        {
            System.out.print("Subject Code: ");
            subj_code[i] = scan.nextLine();
            method_InputSubjects();
            objCls2.call_clsSubjects(subj_code[i], subj[i], units[i], midtermgrd[i], finalgrd[i]);
            objCls2.call_clsSubjects(midtermgrd[i], finalgrd[i]);
        }
    }


    private static void method_InputSubjects()
    {
        System.out.print("Subject Description: ");
        subj[i] = scan.nextLine();
        method_InputUnits();
    }


    private static void method_InputUnits()
    {
        System.out.print("Number of Units: ");
        units[i] = scan.nextInt();
        method_InputGrades();
    }


    private static void method_InputGrades()
    {
        System.out.print("Midterm Grade: ");
        midtermgrd[i] = scan.nextFloat();
        System.out.print("Final Grade: ");
        finalgrd[i] = scan.nextFloat();
        scan.nextLine();
    }


    private static void method_callClassSubjectsName(String sna)
    {
        objSubjects.studName(sna);
    }


    private static String method_InputStudName()
    {
        String sna;
        System.out.print("Student Name: ");
        sna = scan.nextLine();
        return sna;
    }


    private static void method_callClassSubjectsNumber(String sno)
    {
        objSubjects.studNumber(sno);
    }


    public static String method_InputStudNum()
    {
        String sno;
        System.out.print("Student Number: ");
        sno = scan.nextLine();
        return sno;
    }



}
