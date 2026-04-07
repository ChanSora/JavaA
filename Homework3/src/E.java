import java.util.Scanner;
public class E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] a = new int[n + 1][m + 1];
        int w = input.nextInt();
        Window[] windows = new Window[w + 1];
        int k = input.nextInt();
        for (int i = 1; i <= w; i++) {
            int r1 = input.nextInt();
            int c1 = input.nextInt();
            int r2 = input.nextInt();
            int c2 = input.nextInt();
            int id = input.nextInt();
            windows[id] = new Window(r1, c1, r2, c2, id);
            for (int j = r1; j <= r2; j++) {
                for (int l = c1; l <= c2; l++) {
                    a[j][l] = id;
                }
            }
        }
        for (int i = 1; i <= k; i++) {
            int r = input.nextInt();
            int c = input.nextInt();
            if (a[r][c] == 0) continue;
            int r1 = windows[a[r][c]].r1;
            int c1 = windows[a[r][c]].c1;
            int r2 = windows[a[r][c]].r2;
            int c2 = windows[a[r][c]].c2;
            int id = windows[a[r][c]].id;
//            System.out.printf("%d %d %d %d %d\n", r1, c1, r2, c2, id);
            for (int j = r1; j <= r2; j++) {
                for (int l = c1; l <= c2; l++) {
                    a[j][l] = id;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d%c", a[i][j], j == m - 1 ? '\n' : ' ');
            }
        }
    }
    static class Window {
        int r1, c1, r2, c2, id;
        Window(int r1, int c1, int r2, int c2, int id) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.id = id;
        }
    }
}
