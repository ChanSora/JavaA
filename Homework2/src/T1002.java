import java.util.Scanner;
public class T1002 {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] h; int n, maxheight = 0, ans = 0;
        h = new int[101];
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            h[i] = input.nextInt();
            maxheight = Math.max(maxheight, h[i]);
        }
        if (maxheight == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= maxheight; i++) {
            int j, k;
            j = 1;
            while (j <= n) {
                while (h[j] < i) j++;
                k = j + 1;
                while (h[k] < i && k <= n) k++;
                if (k == n + 1) break;
                ans += k - j - 1;
                j = k;
            }
        }
        System.out.println(ans);
    }
}
