import java.awt.*;

public class Main {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(600, 600);
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(0.5, 0, 0.5);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.5, 0, 0.45);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.5, 0, 0.4);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(0.5, 0, 0.35);
        StdDraw.setPenColor(new Color(0,255,255));
        StdDraw.filledCircle(0.5, 0, 0.3);
        StdDraw.setPenColor(new Color(0,0,255));
        StdDraw.filledCircle(0.5, 0, 0.25);
        StdDraw.setPenColor(new Color(139,0,255));
        StdDraw.filledCircle(0.5, 0, 0.2);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(0.5, 0, 0.15);
        
        StdDraw.show();
    }
}
