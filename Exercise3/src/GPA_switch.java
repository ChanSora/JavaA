import java.util.Scanner;

public class GPA_switch {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        int GPA = 0;
        switch(score / 10) {
            case 10, 9:
                GPA = 4;
                break;
            case 8:
                GPA = 3;
                break;
            case 7:
                GPA = 2;
                break;
            case 6:
                GPA = 1;
                break;
            default:
                break;
        }
        System.out.println(GPA);
    }
}
