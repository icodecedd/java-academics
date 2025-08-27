package hands_on_activities;

public class Lesson5Activity1 {
    static Lesson5Activity2 activity2 = new Lesson5Activity2();
    static String empNumber, empName;
    static String orasIn, orasOut;
    static int totalTime;
    static double ratePerHour;
    public void setEmployee(String empNo, String empNa) {
        empNumber = empNo;
        empName = empNa;
    }
    public String[] getEmployee(){
        return new String[]{empNumber, empName};
    }

    public void setTime(String timeIn, String timeOut) {
        orasIn = timeIn;
        orasOut = timeOut;
    }

    public String[] getTime(){
        return new String[]{orasIn, orasOut};
    }

    public int[] convertTime(int hours, int minutes) {

        if (hours == 0) {
            hours = 12;
        } else if (hours > 12) {
            hours -= 12;
        }
        return new int[]{hours, minutes};

    }
    public int computeTime(int hours1, int hours2) {
        totalTime = hours2 - hours1;
        if (totalTime > 5) {
            return totalTime - 1;
        }
        else {
            return totalTime;
        }
    }

    public void setRatePerHour(double rateHour) {
        ratePerHour = rateHour;
    }

    public double getRatePerHour() {
        return ratePerHour;

    }

    public double computeGrossPay(double rateHour, int totalTime) {
        return rateHour * totalTime;
    }


}
