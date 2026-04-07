import java.util.Scanner;

public class A {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int w, h, a, b, r;
        w = input.nextInt();
        h = input.nextInt();
        a = input.nextInt();
        b = input.nextInt();
        r = input.nextInt();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.printf("%d%c", check(j, i, a, b, r), j == w - 1 ? '\n' : ' ');
            }
        }
    }
    static int check(int x, int y, int a, int b, int r) {
        return ((x - a) * (x - a) +  (y - b) * (y - b) <= r * r) ? 1 : 0;
    }
}
