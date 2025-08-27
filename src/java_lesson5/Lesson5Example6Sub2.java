package java_lesson5;

public class Lesson5Example6Sub2 {
    float average;
    public void setAverage(float ave)
    {
        average = ave;
    }

    public float getAverage()
    {
        return average;
    }

    public float method_Compute(float mid, float fin)
    {
        average = (float)(mid + fin) / 2;
        return average;
    }

}
