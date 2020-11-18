package io.dsub.day14;

import java.util.function.*;

/**
 * Predicate
 * - functional interface that determines a logic to be true or false
 *
 * Methods
 * and(), or(), negate(): default methods
 * isEqual(): interface method
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> pred = s -> s.length() == 4;
        System.out.println(pred.test("hellWorld"));
        System.out.println(pred.test("hell"));

        BiPredicate<String, Integer> biPred = (s, v) -> s.length() == v;
        System.out.println(biPred.test("hell", 4));
        System.out.println(biPred.test("hellWorld", 9));

        // as we all know that it would return a boolean,
        // it does not have asT (where t: type) method.
        IntPredicate intPred = x -> x == 4;
        System.out.println(intPred.test(3));
        System.out.println(intPred.test(4));

        DoublePredicate greater = x -> x > 0.5;
        DoublePredicate smaller = x -> x < 2.3;
        DoublePredicate ranged = greater.and(smaller);
        DoublePredicate orRanged = greater.or(smaller);

        System.out.println(greater.test(1.5));
        System.out.println(greater.negate().test(0.5)); // not greater
        System.out.println(ranged.test(1.5));
        System.out.println(orRanged.test(1.5));

        // generates new instance of predicate that checks if two are the same
        Predicate<String> eq = Predicate.isEqual("String");
        System.out.println(eq.test("String"));
        System.out.println(eq.test("Str"));

        // class::new
        UnaryOperator<String> fnc = String::new;

        // class[]::new
        IntFunction<String[]> stringsToInts = String[]::new;
        String[] strings = stringsToInts.apply(100);

    }
}