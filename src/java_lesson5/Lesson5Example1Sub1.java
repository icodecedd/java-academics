package java_lesson5;

public class Lesson5Example1Sub1 {
    String lname,fname,job;
    int age;

    Lesson5Example1Sub1()   //constructor method containing initial values
    {
        lname="Xavier";
        fname="Charles";
        job="Professor";
        age=60;
    }

    public void setLastname(String last)
    {  lname=last; }

    public String getLastname()
    {  return lname; }

    public void setFirstname(String first)
    {  fname = first; }

    public String getFirstname()
    {  return fname;}

    public void setJob(String trabaho)
    { job = trabaho; }

    public String getJob()
    { return job; }

    public void setAge(int edad)
    { age = edad; }

    public int getAge()
    { return age;}

    }
