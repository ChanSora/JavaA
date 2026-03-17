import java.util.Scanner;
public class quiz1 {
    public static void main(String[] args) {
        int n, sum = 0;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        while (n > 0) {
            sum += n;
            n--;
        }
        System.out.println("The sum is " + sum);
    }
}
