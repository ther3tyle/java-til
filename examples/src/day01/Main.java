package day01;

/**
 * 변수 (Variables)
 * <p>
 * 변하는 수, 수학읜 변수와 유사하다
 * 변수의 타입, 변수명 및 값의 할당
 * 변수의 선언
 * 변수의 값 할당 (Literal)
 * 변수명 규칙
 * <p>
 * 자료형 (Data-Types)
 * 1. Primitive Type
 * > int, bool, double, long, float...
 * 2. Reference Type
 * > String, [], class instance...
 */

public class Main {

    static int STATIC_VARIABLE = 10;

    public static void main(String[] args) {
        int x, y, z = 10; // x, y will not be initialized
        // int: byte, short, int, long
        System.out.printf("Byte\n\tByte: %d Range: %s Val: %d ~ %d\n", Byte.BYTES, "(2^7)-1 ~ -2^7", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("Short\n\tByte: %d, Range: %s Val: %d ~ %d\n", Short.BYTES, "(2^15)-1 ~ -2^15", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("Int\n\tByte: %d, Range: %s Val: %d ~ %d\n", Integer.BYTES, "(2^31)-1 ~ -2^31", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("Long\n\tByte: %d, Range: %s Val: %d ~ %d\n", Long.BYTES, "(2^63)-1 ~ -2^63", Long.MIN_VALUE, Long.MAX_VALUE);

        System.out.printf("\n\n");

        // Overflow
        // 32767 = 2^15 - 1 => 01111111111111111
        // 64000 will result neg, as first digit being 1
        short shortVal = (short) 64000;
        System.out.printf("shortVal: %d expected: 64000\n", shortVal);

        System.out.print("\n");
        short shortA = 10, shortB = 20;
        short shortC = (short) (shortA + shortB);
        System.out.printf("%d + %d = %d\n", shortA, shortB, shortC);

        System.out.println();
        int bigInt = Integer.MAX_VALUE;
        int biggerInt = bigInt + 1;
        System.out.printf("Overflow: %d < %d ? %b\n", bigInt, biggerInt, bigInt < biggerInt);

        long veryBigint = 1000000000000000000L;
        int cutInteger = (int)veryBigint;
        System.out.printf("%d, %d\n", veryBigint, cutInteger);

        // Binary, Octal, Decimal, Hexadecimal (2, 8, 10, 16 진수)
        System.out.println(0b1101);
        System.out.println(071);
        System.out.println(32);
        System.out.println(0xff);

        byte flag = 0b00101100; // use each bit
    }
}
