import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        num = input.nextInt();
        if (num == 0) {
            System.out.println("Zero");
        } else if (num < 0) {
            if (num % 2 != 0) {
                System.out.println("Negative Odd");
            } else {
                System.out.println("Negative Even");
            }
        } else {
            if (num % 2 != 0) {
                System.out.println("Positive Odd");
            } else {
                System.out.println("Positive Even");
            }
        }
    }

}
