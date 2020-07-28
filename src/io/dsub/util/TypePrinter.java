package io.dsub.util;

public final class TypePrinter<T> {

    public static void main(String[] args) {
        print();
    }
    private TypePrinter() {
    }

    public static void print() {
        System.out.println("byte");
        System.out.printf("\tByte: %2d | Min: %20d | Max: %20d | Range %-20d ... %20d\n", Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.println("short");
        System.out.printf("\tByte: %2d | Min: %20d | Max: %20d | Range %-20d ... %20d\n", Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE, Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.println("integer");
        System.out.printf("\tByte: %2d | Min: %20d | Max: %20d | Range %-20d ... %20d\n", Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("long");
        System.out.printf("\tByte: %2d | Min: %20d | Max: %20d | Range %-20d ... %20d\n", Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("float");
        System.out.printf("\tByte: %2d | Min: %10.14e | Max: %10.14e\n", Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.println("double");
        System.out.printf("\tByte: %2d | Min: %10.13e | Max: %10.13e\n", Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.println("char");
        System.out.printf("\tByte: %2d | Min: %20d | Max: %20d\n", Character.BYTES, (int)Character.MIN_VALUE, (int)Character.MAX_VALUE);
        System.out.println("\nprint 15 in dec, hex and oct");
        System.out.printf("\t%d 0x%x 0X%X 0%o\n", 15, 15, 15, 15);
    }
}
