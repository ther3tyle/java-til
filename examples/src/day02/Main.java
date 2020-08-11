package day02;

public class Main {
    public static void main(String[] args) {
        // Real Numbers
        System.out.printf("%s\n\tByte: %d Min %1.1e, Max %1.1e\n", "float", Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE);
        // Float.MIN_VALUE = resolution (the least which we could compare)
        System.out.printf("%s\n\tByte: %d Min %1.1e, Max %1.1e\n", "double", Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE);

        float floatVal = 1.4234f;
        float floatVal2 = (float)1.4234;

        double doubleVal = 104.42512341245;

        // 대소문자 둘 다 사용 가능하다.
        double doubleVal2 = 1.423e8;
        double doubleVal3 = 1.425E8;

        // 문자형
        System.out.println("char"); // short 과 같은 2바이트지만 unsigned 이다.
        System.out.printf("\tByte: %d Range: 2^16 - 1 Min %d, Max %d\n", Character.BYTES, (int)Character.MIN_VALUE, (int)Character.MAX_VALUE);

        char charVal = 'A';
        System.out.printf("char 'A' is %d and (char)65 is %c ", (int)charVal, (char)65);

        // UNICODE
        System.out.printf("in unicode, %c%c0041 is %c", '\\', 'u', '\u0041'); // 41 -> 65 (base 16)

        boolean isTrue = true;
        boolean isFalse = false;
        // true == 1, false == 0 은 작동하지 않는다. boolean 리터럴은 별도로 존재한다.

        System.out.println("String");
        String s = "This is a new string";
        System.out.printf("\t%s ", s);
        int a = 30;
        System.out.printf("%d\n", a);

        // Type Casting
        System.out.printf("Casting\n\t(int)100.9 = %d\n", (int)100.9);
        System.out.print("\tup casting: 범위가 작은 쪽 -> 범위가 큰 쪽, 정밀도가 낮은 쪽 -> 정밀도가 큰 쪽\n"); // IMPORTANT

        // Up Casting
        byte byteVal = Byte.MAX_VALUE;
        int intVal = byteVal;
        long longVal = intVal;
        floatVal = longVal; // long to float. float is 4 byte, long is 8 byte -> range of float > range of long
        doubleVal = floatVal;

        // Down Casting
        longVal = 104244L;
        intVal = (int) longVal; // down casting is not automatic
        byteVal = (byte) intVal;
        System.out.printf("intVal: %d, byteVal: %d\n", intVal, byteVal);

        charVal = 4123;
        byteVal = (byte) charVal;
        System.out.println(byteVal);

        /**
         * Short Circuit 보강 수업
         */

        // 일반적인 &
        a = 0;
        int b = 0;
        System.out.println(a > 0 & b > 0);
        System.out.println(a++ > 0 & b++ > 0);
        System.out.println(a + ", " + b);

        // Short Circuit &&
        a = 0;
        b = 0;
        System.out.println(a++ > 0 && b++ > 0); // a > 0 가 이미 false 를 보여주므로 b++ 를 처리하지 않았다.
        System.out.println(a + ", " + b);

        // || 는 첫번째가 참이면 뒤를 계산하지 않는다.
        // && 는 첫번째가 거짓이면 뒤를 계산하지 않는다.
    }
}
