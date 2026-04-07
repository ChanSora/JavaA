import java.util.Scanner;
public class C {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n], suf = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                suf[i] = a[i];
                continue;
            }
            suf[i] = Math.min(a[i], suf[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, a[i] - suf[i]);
        }
        System.out.println(ans);
    }
}
