package java_lesson3;

public class Lesson3Example5 {
    public long method_OverLoad(int no1, int no2)
    {
        return((long) no1 * no2);
    }

    public void method_OverLoad(int[] no)
    {
        float quo = (float)no[0] / no[1];
        System.out.println("Quotient: " + quo);
    }
}
