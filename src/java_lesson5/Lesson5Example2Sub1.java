package java_lesson5;

public class Lesson5Example2Sub1 {
    int emp_id,emp_age;
    String emp_dept;
    Lesson5Example2Sub1(int id_no, int age, String dept)//accepts 3 arguments
    {  emp_id = id_no;
        emp_age = age;
        emp_dept = dept;
    }

    public int getId()
    {  return emp_id;}

    public int getAge()
    {  return emp_age;}

    public String getDept()
    {  return emp_dept;}

}
