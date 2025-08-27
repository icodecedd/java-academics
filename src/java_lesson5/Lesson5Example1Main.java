package java_lesson5;

public class Lesson5Example1Main {
    public static void main(String[] args) {
        String lastname,firstname,work;
        int gulang;
        Lesson5Example1Sub1 student = new Lesson5Example1Sub1();
        lastname = student.getLastname();
        firstname = student.getFirstname();
        work=student.getJob();
        gulang = student.getAge();
        System.out.println("Name : " + lastname + ", " + firstname);
        System.out.println("Age : " + gulang);
        System.out.println("Job : " + work);
    }
}


