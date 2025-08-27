package java_lesson5;

public class Lesson5Example2Main {
    public static void main(String[] args)
    {
        Lesson5Example2Sub1 employee1 = new Lesson5Example2Sub1(1234,25,"Payroll");
        System.out.println("Employee ID : " + employee1.getId());
        System.out.println("Age : "+ employee1.getAge());
        System.out.println("Department : " + employee1.getDept()+"\n");

        Lesson5Example2Sub1 employee2 = new Lesson5Example2Sub1(5678,30,"Human Resources");
        System.out.println("Employee ID : " + employee2.getId());
        System.out.println("Age : "+ employee2.getAge());
        System.out.println("Department : " + employee2.getDept());
    }

}
