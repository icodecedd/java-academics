package java_lesson3;

public class Lesson3Example4 extends Lesson3Example1 {
    public static void main(String[] args) {
        //call the method inputNumber from the Lesson4Example1
        int number = Lesson3Example1.inputNumber(); // the method inputNumber from Lesson4Example1 abstracted
        System.out.println("Input Value is: " + number);
        Lesson3Example1.factors(number);
        Lesson3Example1.count = Lesson3Example1.determine(number);
        Lesson3Example1.primeCompo();
    }
}
