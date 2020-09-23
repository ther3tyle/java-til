package day14;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Suppliers do not receive any input, but returns a value.
 * As the name implies, it supplies a value.
 */
public class SupplierDemo {
    public static void main(String[] args) {

        // we may well assume if we
        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());

        // each primitive type has its PSupplier(P as type name)
        // IntSupplier, LongSupplier, DoubleSupplier
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());

        // you may imagine using it like...
        IntSupplier rollDice = () -> (int) (Math.random() * 6);
        for (int i = 0; i < 10; i++) {
            System.out.printf("rollDice %d\n", rollDice.getAsInt() + 1);
        }

        int x = 4;
        IntSupplier intSupplier = () -> x;
        System.out.println(intSupplier.getAsInt());
    }
}
