import java.util.Scanner;
public class T1002_opt {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] h; int n, ans = 0;
        h = new int[101];
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            h[i] = input.nextInt();
        }
        int j, k, lmax, rmax;
        j = 1; k = n; lmax = 0; rmax = 0;
        while (j < k) {
            if (h[j] <= h[k]) {
                if (h[j] >= lmax) lmax = h[j];
                ans += lmax - h[j];
                j++;
            } else {
                if (h[k] >= rmax) rmax = h[k];
                ans += rmax - h[k];
                k--;
            }
        }
        System.out.println(ans);
    }
}
