class MyTriangle {
    static boolean isValid(double a, double b, double c) {
        return !(a + b <= c || a + c <= b || b + c <= a);
    }
    static double perimeter(double a, double b, double c) {
        return a + b + c;
    }
    static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    static double area(double a, double h) {
        return 0.5 * a * h;
    }
    static double area(double a, double b, int theta) {
        return 0.5 * a * b * Math.sin(1.0 * theta / 180.0 * Math.PI);
    }
}
