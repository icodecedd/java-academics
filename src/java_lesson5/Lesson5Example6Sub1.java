package java_lesson5;

public class Lesson5Example6Sub1 {
    float midgrd, fingrd, ave, average;
    Lesson5Example6Sub2 compGrd = new Lesson5Example6Sub2();
    public Lesson5Example6Sub1(float mid, float fin)
    {
        midgrd = mid;
        fingrd = fin;
    }

    public float getMidGrd()
    {
        return midgrd;
    }

    public float getFinGrd()
    {
        return fingrd;
    }

    public float method_ComputeGrade()
    {
        ave = compGrd.method_Compute(midgrd, fingrd);
        compGrd.setAverage(ave);
        average = compGrd.getAverage();
        return average;
    }

}
