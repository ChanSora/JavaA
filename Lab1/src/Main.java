import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
//        System.out.printf("Hello and welcome%d!\n", 2);
//        System.out.println("hello world!");
//        System.out.print("hello world!\n");
//        System.out.print("  *****     *****\n");
//        System.out.print("*******************\n");
//        System.out.print(" ***************** \n");
//        System.out.print("  ***************\n");
//        System.out.print("    ***********\n");
//        System.out.print("      *******\n");
//        int a, b;
//        double c = 2.0;
//        float d = 3.0f;
//        String e = "hello world!";

//        int a = 2;
//        double b = 2;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a / 3);
//        System.out.println(b / 3);
//        System.out.println(1 / 3);
//        System.out.println(1.0 / 3);
//        System.out.println(b + 1 / 2);
//        System.out.println(a + "+" + b + "=" + a + b);
//        System.out.println(a + b + "=" + a + "+" + b);
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(a);
        MyClass c = new MyClass(a, b);
        c.print();
    }
    public static class MyClass {
        int a;
        int b;
        public MyClass(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public void print() {
            System.out.println(a);
            System.out.println(b);
        }
    }

}