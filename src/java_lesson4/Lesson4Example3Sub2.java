/**
 * Utility class for returning the subject code, code,
 * units, midterm and final grades, etc.
 */

package java_lesson4;
public class Lesson4Example3Sub2 {
    String subj_code, studNo;
    String subj, studName;
    static int units, i=0, tot_units=0;
    float midGrade, finGrade;
    float aveGrade;
    static float[] average = new float[5];
    float genAve;
    Lesson4Example3Sub3 compAveGrd = new Lesson4Example3Sub3();

    public void subjCode(String scode)
    {
        subj_code = scode;
    }

    public void subjects(String subjs)
    {
        subj = subjs;
    }

    public void subj_units(int unit)
    {
        units = unit;
    }

    public void midGrades(float mid)
    {
        midGrade = mid;
    }

    public void finGrades(float fin)
    {
        finGrade = fin;
    }
    public void method_call_clsComputeAveGrade(float mid, float fin)
    {
        aveGrade = compAveGrd.method_call_clsComputeAveGrade(midGrade, finGrade);
        System.out.println("Average: " + aveGrade);
        float aver = aveGrade * units;
        method_aveGrade(aver);
        i++;
        tot_units += units;
    }

    private void method_aveGrade(float ave)
    {
        average[i] = ave;
    }


    public void method_call_clsComputeGenAve()
    {
        genAve = compAveGrd.computeGenAve(average, tot_units);
    }

    public void studNumber(String sno)
    {
        studNo = sno;
    }

    public void studName(String sna)
    {
        studName = sna;
    }

    public void methodOutputs()
    {
        System.out.println("Student Number: " + studNo);
        System.out.println("Student Name: " + studName);
        System.out.println("General Average: " + genAve);
    }
}

