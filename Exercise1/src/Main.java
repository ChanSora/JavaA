import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Width and Height for a rectangle!");
        System.out.print("Width:");
        double width = in.nextDouble();
        System.out.print("Height:");
        double height = in.nextDouble();
        double area = width * height;
        double perimeter = 2 * (width + height);
        System.out.printf("Area of rectangle is:%.2f\n", area);
        System.out.println("Perimeter of rectangle is: " + perimeter);

    }
}