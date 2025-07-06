package java_lesson3;
import java.util.Scanner;
public class Lesson3Example6 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        Lesson3Example5 over = new Lesson3Example5(); // creates object over for Lesson4Example6
        int no1, no2;
        System.out.println("Number 1: ");
        no1 = scan.nextInt();
        System.out.println("Number 2: ");
        no2 = scan.nextInt();
        long prod = over.method_OverLoad(no1, no2);
        System.out.println("Product: " + prod);
        int[] val = {no1, no2};
        over.method_OverLoad(val);
    }
}
