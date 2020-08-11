package day09.interfaces.arithmetics;

public class Calculator {
    private final ArithmeticOperator op;

    public Calculator(ArithmeticOperator op) {
        this.op = op;
    }

    public int operate(int x, int y) {
        return op.operate(x, y);
    }

    public long operate(long x, long y) {
        return op.operate(x, y);
    }

    public double operate(double x, double y) {
        return op.operate(x, y);
    }
}
