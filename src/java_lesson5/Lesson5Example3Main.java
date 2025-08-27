package java_lesson5;

public class Lesson5Example3Main {
    public static void main(String[] args)
    {
        Lesson5Example3Sub1 student1 = new Lesson5Example3Sub1();
        System.out.println("Constructor with no argument");
        System.out.println("Student number "+ student1.getNum());
        System.out.println("Age : " + student1.getAge());
        System.out.println("Course : " + student1.getCourse()+"\n");

        System.out.println("Constructor with 1 argument");
        Lesson5Example3Sub1 student2 = new Lesson5Example3Sub1(2470);
        System.out.println("Student number "+ student2.getNum());
        System.out.println("Age : " + student2.getAge());
        System.out.println("Course : " + student2.getCourse()+"\n");

        System.out.println("Constructor with 2 arguments");
        Lesson5Example3Sub1 student3 = new Lesson5Example3Sub1(2470,33);
        System.out.println("Student number "+ student3.getNum());
        System.out.println("Age : " + student3.getAge());
        System.out.println("Course : " + student3.getCourse()+"\n");

        System.out.println("Constructor with 3 arguments");
        Lesson5Example3Sub1 student4 = new Lesson5Example3Sub1(2113,25,"BSCS");
        System.out.println("Student number "+ student4.getNum());
        System.out.println("Age : " + student4.getAge());
        System.out.println("Course : " + student4.getCourse());
    }

}
