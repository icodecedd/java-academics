package java_lesson3;
import java.util.Scanner;
public class Lesson3Example1 {
    static Scanner scan = new Scanner(System.in);
    static int number, count;
    public static void main(String[] args) {
        number = inputNumber();
        factors(number);
        count = determine(number);
        primeCompo();
    }
    public static int inputNumber() // without return type, without parameter
    {
        System.out.print("Input a number: ");
        number = scan.nextInt();
        return(number);
    }
    public static void factors(int num) // without return type, with parameter
    {
        System.out.print("Factors of " + num + " are: ");
        for(int i=1; i<=num; i++)
            if(num % i == 0)
                System.out.print(i + "\t");
        System.out.println();
    }

    public static int determine(int no) // with return type, with parameter
    {	int ctr = 0;
        for(int i=2; i<no; i++)
            if(no % i == 0)
            {
                ctr = 1;
                break;
            }
        return ctr;
    }

    public static void primeCompo() // without return type, without parameter
    {
        if (count == 1)
            System.out.println("Composite Number");
        else
            System.out.println("Prime Number");
    }
}
