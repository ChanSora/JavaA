import java.util.Scanner;
public class Main {
    static public void main(String[] args) {
        int[] arr = new int[101];
        int n;
        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 0) {
            arr[n]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.printf("%d occurs %d time%s", i, arr[i], arr[i] == 1 ? "\n" : "s\n");
            }
        }
    }
}
