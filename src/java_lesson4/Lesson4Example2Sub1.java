package java_lesson4;

public class Lesson4Example2Sub1 {

    static String studNo, studName;
    static float midGrd, finGrd, aveGrd;
    //cls_Grades compGrd = new cls_Grades();
    Lesson4Example2Sub2 compGrd = new Lesson4Example2Sub2();

    public void studNumber(String sno)
    {
        studNo = sno;
    }

    public void studName(String sna)
    {
        studName = sna;
    }

    public void method_ComputeGrades(float mid, float fin)
    {
        compGrd.midGrade(mid);
        midGrd = compGrd.finGrade();
        compGrd.finGrade(fin);
        finGrd = compGrd.finGrade();
    }

    public void method_Outputs()
    {
        System.out.println("Student Number: " + studNo);
        System.out.println("Student Name: " + studName);
        System.out.println("Average Grade: " + compGrd.aveGrade());
    }

}
