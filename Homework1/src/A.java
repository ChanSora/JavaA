import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if ((year % 5 == 0 && year % 50 != 0) || year % 400 == 0) {
            System.out.println("Yes");
        } else  {
            System.out.println("No");
        }
    }
}
