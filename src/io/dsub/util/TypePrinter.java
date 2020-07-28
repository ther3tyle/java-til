package io.dsub.util;

public final class TypePrinter<T> {
    private TypePrinter() {
    }

    public void printType(Class<T> clazz) {
        System.out.println(clazz.getSimpleName());
        System.out.printf("\tByte: %2d Min: %10d Max: %10d Range %1.1e ... %1.1e\n", Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
