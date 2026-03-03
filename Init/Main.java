public class Main {
    public static void main(String[] args) {
         System.out.println("Hello, VS Code!");
         // 打印乘法表
         printMultiplicationTable(9);
    }

    public static void printMultiplicationTable(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-2d ", j, i, i * j);
            }
            System.out.println();
        }
    }
}
