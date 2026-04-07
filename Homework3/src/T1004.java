import java.util.Scanner;
public class T1004 {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] a = new int[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 10000000;
        dp[1][0] = dp[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
//                System.out.printf("%d%c", dp[i][j], j == n ? '\n' : ' ');
            }
        }
        System.out.println(dp[m][n]);
    }
}

