package io.dsub.day09.interfaces.arithmetics;

public class Runner {
    public static void run(ArithmeticOperator op, int x, int y) {
        System.out.println(op.operate(x, y));
    }
    public static void run(ArithmeticOperator op, long x, long y) {
        System.out.println(op.operate(x, y));
    }
    public static void run(ArithmeticOperator op, double x, double y) {
        System.out.println(op.operate(x, y));
    }
}
