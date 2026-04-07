class Calculator {
    static int cal(int a, String op, int b) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("/")) {
            return b == 0 ? Integer.MAX_VALUE : a / b;
        } else if (op.equals("%")) {
            return b == 0 ? Integer.MAX_VALUE : a % b;
        } else return Integer.MAX_VALUE;
    }
}
