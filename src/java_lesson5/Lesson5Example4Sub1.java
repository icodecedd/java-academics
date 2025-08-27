package java_lesson5;

public class Lesson5Example4Sub1 {
    String studNum, studName;
    Lesson5Example4Sub2 cys = new Lesson5Example4Sub2(); //multithreading
    //set() and get() methods of constructors
    public void setStudNum(String sno)
    {
        studNum = sno;
    }
    public String getStudNum()
    {
        return studNum;
    }

    public void setStudName(String sna)
    {
        studName = sna;
    }
    public String getStudName()
    {
        return studName;
    }

    // constructor methods
    public void method_SetCourseYrSec(String crs, int yr, int sec)
    {
        cys.setCourse(crs);
        cys.setYear(yr);
        cys.setSection(sec);
        method_getCourseYearSec();
    }

    public void method_getCourseYearSec()
    {
        String course;
        int year, section;
        course = cys.getCourse();
        year = cys.getYear();
        section = cys.getSection();
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
        System.out.println("Section: " + section);
    }

}
