import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class D {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Node> v = new Vector<>();
        int n = input.nextInt();
        Node border = new Node(0, get_order(n + 1,n + 1));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int val = input.nextInt();
                long order = get_order(i, j);
                if (val != 0) v.add(new Node(val, order));
                else border.order = Math.min(border.order, order);
            }
        }
        v.add(border);
        v.sort(Comparator.comparingLong(a -> a.order));
        if (border.order == 1) {
            System.out.println();
            return;
        }
        for (Node i : v) {
            if (i.data == 0) break;
            System.out.printf("%d ", i.data);
        }
    }
    static long get_order(long i, long j) {
        long ord = (i + j - 1) * (i + j - 2) / 2;
        ord += ((i + j) % 2 == 0) ? j : i;
        return ord;
    }
    static class Node {
        long data, order;

        Node(long data, long order) {
            this.data = data;
            this.order = order;
        }
    }
}
