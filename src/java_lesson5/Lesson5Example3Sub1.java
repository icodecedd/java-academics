package java_lesson5;

public class Lesson5Example3Sub1 {
    int stud_no,age;
    String course;

    Lesson5Example3Sub1() //constructor with no argument
    { stud_no=999;
        age=17;
        course="Fine arts"; }

    Lesson5Example3Sub1(int stud_num) //constructor with 1 argument
    {  stud_no=stud_num;}

    Lesson5Example3Sub1(int stud_num, int stud_age)// with 2 arguments
    {  stud_no = stud_num;
        age=stud_age;}

    Lesson5Example3Sub1(int stud_num, int stud_age, String stud_course)//3 args.
    {  stud_no = stud_num;
        age=stud_age;
        course = stud_course;}

    public int getNum()
    {  return stud_no;}

    public int getAge()
    {  return age;}

    public String getCourse()
    {  return course;}

}
