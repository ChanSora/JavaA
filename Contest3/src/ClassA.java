class Window {
    private final int r1, c1, r2, c2, id;

    public Window(int r1, int c1, int r2, int c2, int id) {
        this.r1 = r1;
        this.c1 = c1;
        this.r2 = r2;
        this.c2 = c2;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getR1() {
        return this.r1;
    }

    public int getC1() {
        return this.c1;
    }

    public int getR2() {
        return this.r2;
    }

    public int getC2() {
        return this.c2;
    }
}

class Desktop {
    public static void openWindow(Window w, int[][] mat) {
        int r1 = w.getR1();
        int c1 = w.getC1();
        int r2 = w.getR2();
        int c2 = w.getC2();
        int id = w.getId();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
                    mat[i][j] = id;
                }
            }
        }
    }
    public static void click(int r, int c, Window[] wins, int[][] mat) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) return;
        if (mat[r][c] == 0) return;
        Window w;
        for (Window win : wins) {
            if (win != null && win.getId() == mat[r][c]) {
                w = win;
                openWindow(w, mat);
                break;
            }
        }
    }
    public static void printScreen(int[][] mat) {
        int m = mat[0].length;
        for (int[] ints : mat) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d%c", ints[j], j == (m - 1) ? '\n' : ' ');
            }
        }
    }
}

