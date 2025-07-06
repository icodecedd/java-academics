package java_lesson3;
import java.util.*;
public class Lesson3Example3 {
    static Scanner scan = new Scanner(System.in);
    static int num1, num2;
    public static void main(String[] args) {
        System.out.print("First Number: ");
        num1 = scan.nextInt();
        System.out.print("Second Number: ");
        num2 = scan.nextInt();
        method_OverLoad();
        int diff = method_OverLoad(num1);
        System.out.println("Difference: " + diff);
        long prod = method_OverLoad(num1, num2);
        System.out.println("Product: " + prod);
        int[] numbers = {num1, num2};
        method_OverLoad(numbers);

    }

    public static void method_OverLoad()
    {
        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
    }

    public static int method_OverLoad(int no)
    {
        return (no - num2);
    }

    public static long method_OverLoad(int no1, int no2)
    {
        return((long) no1 * no2);
    }

    public static void method_OverLoad(int[] no)
    {
        float quo = (float)no[0] / no[1];
        System.out.println("Quotient: " + quo);
    }
}
