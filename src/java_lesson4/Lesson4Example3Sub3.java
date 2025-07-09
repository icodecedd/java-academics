/**
 * Utility class for computing the average grade and general average.
 */

package java_lesson4;
public class Lesson4Example3Sub3 {
    public float method_call_clsComputeAveGrade(float mid, float fin)
    {
        return((mid + fin) / 2);
    }

    public float computeGenAve(float[] average, int tot_units)
    {
        float genAveGrd=0;
        for(int i=0; i<5; i++)
            genAveGrd += average[i];
        return(genAveGrd / tot_units);
    }

}
