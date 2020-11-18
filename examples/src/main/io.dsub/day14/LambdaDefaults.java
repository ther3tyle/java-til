package io.dsub.day14;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambda default method / constructor
 *
 * - what if you would like to reuse the pre-implemented stuffs
 *
 *
 */
public class LambdaDefaults {
    public static void main(String[] args) {
        // className::instanceMethod
        String[] strings = {"fast", "campus", "best", "academy"};
        Arrays.sort(strings, String::compareTo);
        System.out.println(Arrays.toString(strings));

        // className::classMethod
        Function<String, Integer> func = Integer::parseInt;
        BiFunction<String, String, Integer> compare = String::compareTo;

        String s = "String";
        Predicate<String> prd = s::equals;
        System.out.println(prd.test("String"));
        System.out.println(prd.test("String1"));
    }
}
