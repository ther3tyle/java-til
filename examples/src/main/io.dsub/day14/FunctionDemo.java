package io.dsub.day14;

import java.util.function.*;

/**
 * Function
 * - mapping: input -> functional interface that maps to something
 */

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Character, Integer> func = c -> Character.isDigit(c) ? c - 48 : '_';
        System.out.println(func.apply('7'));

        BiFunction<String, String, Integer> biFunc = (a, b) -> a.length() + b.length();
        System.out.println(biFunc.apply("hell", "world"));

        // also has P Type (P as primitive type) interfaces as PFunction
        IntFunction<String> intFunc = String::valueOf;
        System.out.println(intFunc.apply(57656785));

        // ToP Type Function returns type P value; where types of P are
        // int, long, double primitives
        ToIntFunction<String> funcToInt = String::length;
        funcToInt.applyAsInt("hellWorld");

        // PToQFunction: P -> Q mapping
        IntToDoubleFunction intToDoubleFunc = a -> a;
    }
}