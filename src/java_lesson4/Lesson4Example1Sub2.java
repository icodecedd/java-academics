/**
 * Utility class for managing student grades.
 */

package java_lesson4;
public class Lesson4Example1Sub2 {

    float midgrd, fingrd;
    public void midGrade(float mg)
    {
        midgrd = mg;
    }

    public float midGrade()
    {
        return midgrd;
    }

    public void finGrade(float fg)
    {
        fingrd = fg;
    }

    public float finGrade()
    {
        return fingrd;
    }

    public float aveGrade()
    {
        return((midgrd + fingrd) / 2);
    }

}
