package java_lesson5;

public class Lesson5Example5Sub1 {
    String studNum, studName, course;
    int year, section;

    public Lesson5Example5Sub1(String sno, String sna) // overloading constructor
    {
        studNum = sno;
        studName = sna;
    }

    public String getStudNum()
    {
        return studNum;
    }

    public String getStudName()
    {
        return studName;
    }

    public Lesson5Example5Sub1(String crs, int yr, int sec) // overloading constructor
    {
        course = crs;
        year = yr;
        section = sec;
    }


    public String getCourse()
    {
        return course;
    }

    public int getYear()
    {
        return year;
    }

    public int getSection()
    {
        return section;
    }

}
