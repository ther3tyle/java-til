package day14;

import java.util.Comparator;
import java.util.function.*;

/**
 * Operator
 * - in, out type must be the same
 * - if to map the type, use Function
 *
 * BinaryOperator interface method
 * - minBy, maxBy: takes Comparator then returns min, max
 */

public class OperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<String> repeater = s -> s.repeat(5);
        System.out.println(repeater.apply("hellWorld"));

        BinaryOperator<String> binOp = (a, b) -> a + b;
        System.out.println(binOp.apply("hell", "World"));

        IntUnaryOperator addTen = a -> a + 10;
        System.out.println(addTen.applyAsInt(13));

        IntBinaryOperator summation = Integer::sum;
        System.out.println(summation.applyAsInt(45, 82));



        BinaryOperator<String> minBy = BinaryOperator.minBy((o1, o2) -> o1.length() > o2.length() ? 1 : -1);
        BinaryOperator<String> maxBy = BinaryOperator.maxBy((o1, o2) -> o1.length() > o2.length() ? 1 : -1);

        System.out.println(minBy.apply("hell", "world"));
        System.out.println(maxBy.apply("hell", "world"));
    }
}
