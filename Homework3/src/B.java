import java.util.Scanner;
public class B {
    static public void main(String[] args) {
        int[] a, b;
        int l1, l2;
        Scanner input = new Scanner(System.in);
        l1 = input.nextInt();
        a = new int[l1];
        for (int i = 0; i < l1; i++) {
            a[i] = input.nextInt();
        }
        l2 = input.nextInt();
        b = new int[l2];
        for (int i = 0; i < l2; i++) {
            b[i] = input.nextInt();
        }
        int i = 0, j = 0;
        while (i < l1 || j < l2) {
            if (i == l1) {
                System.out.printf("%d ", b[j]);
                j++;
                continue;
            }
            if (j == l2) {
                System.out.printf("%d ", a[i]);
                i++;
                continue;
            }
            if (a[i] <= b[j]) {
                System.out.printf("%d ", a[i]);
                i++;
            } else {
                System.out.printf("%d ", b[j]);
                j++;
            }
        }
    }
}
