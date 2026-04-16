//class Window {
//    private int r1, c1, r2, c2, id;
//
//    public Window(int r1, int c1, int r2, int c2, int id) {
//        this.r1 = r1;
//        this.c1 = c1;
//        this.r2 = r2;
//        this.c2 = c2;
//        this.id = id;
//    }
//
//    // 必须是标准的 get 开头方法
//    public int getR1() { return r1; }
//    public int getC1() { return c1; }
//    public int getR2() { return r2; }
//    public int getC2() { return c2; }
//    public int getId() { return id; }
//}
//
//class Desktop {
//
//    public static void openWindow(Window w, int[][] mat) {
//        int r1 = w.getR1();
//        int c1 = w.getC1();
//        int r2 = w.getR2();
//        int c2 = w.getC2();
//        int id = w.getId();
//
//        // 右下角包含（inclusive），增加越界保护
//        for (int i = r1; i <= r2; i++) {
//            for (int j = c1; j <= c2; j++) {
//                if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
//                    mat[i][j] = id;
//                }
//            }
//        }
//    }
//
//    public static void click(int r, int c, Window[] wins, int[][] mat) {
//        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) {
//            return;
//        }
//        int id = mat[r][c];
//        if (id == 0) {
//            return;
//        }
//
//        // 查找对应窗口（题目保证 wins 无 null，但仍安全处理）
//        for (Window w : wins) {
//            if (w != null && w.getId() == id) {
//                openWindow(w, mat);   // 置顶该窗口
//                return;
//            }
//        }
//    }
//
//    public static void printScreen(int[][] mat) {
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                System.out.print(mat[i][j]);
//                if (j < mat[0].length - 1) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}