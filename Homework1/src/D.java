import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class D {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> greatop = new HashSet<>();
        greatop.add("*");
        greatop.add("/");
        greatop.add("%");
        int type = input.nextInt();
        if (type == 1) {
            String a = input.next();
            String op = input.next();
            String b = input.next();
            int ans = calculate(a, op, b);
            System.out.println(ans == -1 ? "Error: Division by zero" : ans);
        } else {
            String a = input.next();
            String op1 = input.next();
            String b = input.next();
            String op2 = input.next();
            String c = input.next();
            if (greatop.contains(op2) && !greatop.contains(op1)) {
                int ans = calculate(b, op2, c);
                if (ans == -1) {
                    System.out.println("Error: Division by zero");
                    return;
                }
                ans = calculate(a, op1, String.valueOf(ans));
                System.out.println(ans == -1 ? "Error: Division by zero" : ans);
            } else {
                int ans = calculate(a, op1, b);
                if (ans == -1) {
                    System.out.println("Error: Division by zero");
                    return;
                }
                ans = calculate(String.valueOf(ans), op2, c);
                System.out.println(ans == -1 ? "Error: Division by zero" : ans);
            }
        }
    }
    static int calculate(String a, String op, String b) {
        return switch (op) {
            case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
            case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
            case "*" -> Integer.parseInt(a) * Integer.parseInt(b);
            case "/" -> Integer.parseInt(b) == 0 ? -1 : Integer.parseInt(a) / Integer.parseInt(b);
            case "%" -> Integer.parseInt(b) == 0 ? -1 : Integer.parseInt(a) % Integer.parseInt(b);
            default -> -1;
        };
    }
}
