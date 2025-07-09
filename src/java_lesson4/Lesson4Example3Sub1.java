/**
 * Utility class for getting the necessary information.
 */

package java_lesson4;
public class Lesson4Example3Sub1 {
    Lesson4Example3Sub2 subjects = new Lesson4Example3Sub2();

    public void call_clsSubjects(String scode, String subj, int unit, float mid, float fin)
    {
        subjects.subjCode(scode);
        subjects.subjects(subj);
        subjects.subj_units(unit);
        subjects.midGrades(mid);
        subjects.finGrades(fin);
    }

    public void call_clsSubjects(float mid, float fin)
    {
        subjects.method_call_clsComputeAveGrade(mid, fin);
    }
}

