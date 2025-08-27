package hands_on_activities;

public class Lesson4MethodsActivity2 extends Lesson4MethodsActivity1 {
    public static void main(String[] args) {
        Lesson4MethodsActivity1.inputInfo();
        Lesson4MethodsActivity1.totFare = Lesson4MethodsActivity1.calcFare(distance);
        Lesson4MethodsActivity1.officialReceipt(distance, totFare, type);
    }
}
