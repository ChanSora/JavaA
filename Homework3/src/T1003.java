import java.util.Scanner;
public class T1003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] a = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                a[i][j] = input.nextInt();
                sum += a[i][j];
            }
            a[i][m] = sum / m;
        }
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i][j];
            }
            a[n][j] = sum / n;
        }
        for (int j = 0; j <= m; j++) {
            for (int i = 0; i <= n; i++) {
                if (j == m && i == n) break;
                System.out.printf("%d%c", a[i][j], i == n ? '\n' : ' ');
            }
        }
    }
}
