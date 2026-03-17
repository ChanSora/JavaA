import java.util.Scanner;
public class quiz2 {
    public static void main(String[] args) {
        int n, sum = 0;
        Scanner input = new Scanner(System.in);
        while(true){
            n = input.nextInt();
            if (n == -1) break;
            sum += n;
        }
        System.out.println("The sum is " + sum);
    }
}
