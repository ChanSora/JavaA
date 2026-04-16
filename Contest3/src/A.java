import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] a = new int[n][m];
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
            Desktop.openWindow(windows[id], a);
        }
        for (int i = 1; i <= k; i++) {
            int r = input.nextInt();
            int c = input.nextInt();
            if (a[r][c] == 0) continue;
            Desktop.click(r, c, windows, a);
        Desktop.printScreen(a);
    }
}
    static class Desktop {
        public static void openWindow(Window w, int[][] mat) {
            int r1 = w.r1();
            int c1 = w.c1();
            int r2 = w.r2();
            int c2 = w.c2();
            int id = w.id();

            for (int j = r1; j <= r2; j++) {
                for (int l = c1; l <= c2; l++) {
                    if (j >= 0 && j <= mat[0].length && l >= 0 && l <= mat[0].length) {
                        mat[j][l] = id;
                    }
                }
            }

        }

        public static void click(int r, int c, Window[] wins, int[][] mat) {
            if (mat[r][c] == 0) return;
            Window w = null;
            for (Window win : wins) {
                if (win != null && win.id() == mat[r][c]) {
                    w = win;
                    break;
                }
            }
            if (w == null) return;
            openWindow(w, mat);
        }
        public static void printScreen(int[][] m) {
            for (int[] row : m) {
                for (int j = 0; j < row.length; j++) {
                    System.out.print(row[j] + (j == row.length - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
    }

    record Window(int r1, int c1, int r2, int c2, int id) {}
}