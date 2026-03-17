import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int val = 0, i = 1; i <= n;) {
            val++;
            if (val % 7 == 0) continue;
            if (val / 10 == 7) continue;
            if (val % 10 == 7) continue;
            System.out.printf("%d%c", val, i == n ? '\n' : ' ');
            if (val == 100) val = 0;
            i++;
        }
    }
}
