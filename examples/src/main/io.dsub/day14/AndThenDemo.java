package main.io.dsub.day14;

import java.util.function.*;

/**
 * andThen Method
 * - implemented in Consumer, Function, Operator
 * - andThen method: A.andThen(B) -> do A then do B
 *
 * compose Method
 * - implemented in Function, Operator
 * - compose: A.compose(B) -> do B then do A
 */
public class AndThenDemo {

    public static void main(String[] args) {
        Consumer<String> c0 = s -> System.out.println("c0: " + s);
        Consumer<String> c1 = s -> System.out.println("c1: " + s);
        Consumer<String> c2 = c0.andThen(c1);
        c2.accept("HELL WORLD");

        Function<String, Integer> func1 = s -> s.length();
        Function<Integer, Boolean> func2 = v -> v == 3;
        Function<String, Boolean> func3 =  func1.andThen(func2);
        System.out.println(func3.apply("hel"));

        Function<String, Boolean> func4 = func2.compose(func1);
        System.out.println(func3.apply("hel"));

        // Even if we only use operators, there could be a function.
        // The result must be a kind of function
        BinaryOperator<String> strBinOp = (s1, s2) -> s1 + " : " + s2;
        UnaryOperator<String> strUnrOp = s -> s + "HELL";
        UnaryOperator<String> putDot=  s -> s + ".";
        BiFunction<String, String, String> combinedOp = strBinOp.andThen(strUnrOp.andThen(putDot));
        System.out.println(combinedOp.apply("Hell", "World"));

        Function<String, String> combinedTwo = strUnrOp.compose(putDot);
        System.out.println(combinedTwo.apply("hello"));
    }
}
