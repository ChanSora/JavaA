import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X, Y, Z, duration;
        X = input.nextInt();
        Y = input.nextInt();
        Z = input.nextInt();
        duration = input.nextInt();
        int D = duration / (X * Y * Z);
        duration -= D * (X * Y * Z);
        int HH = duration / (Y * Z);
        duration -= HH * (Y * Z);
        int MM = duration / (Z);
        duration -= MM * Z;
        int SS = duration;
        System.out.printf("%d %02d:%02d:%02d\n", D, HH, MM, SS);
    }
}
