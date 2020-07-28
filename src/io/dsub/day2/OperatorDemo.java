package io.dsub.day2;

/**
 * 연산자(Operator)
 * 연산자(Operator), 피연산자(Operand) -> 연산식(Expression)
 * 사칙 연산자: + - * /
 * 비교 연산자: > >= == <= <
 * 논리 연산자:
 * 증감 연산자:
 * 삼항 연산자:
 * 비트 연산자:
 */

public class OperatorDemo {
    public static void main(String[] args) {
        int x = 10, y = 20, z;
        z = x + y;  // +: 연산자, x, y = 피연산자, x + y = expression
        // =: 연산자, z = 피연산자
        System.out.println(z);

        System.out.println("정수형 사칙연산");
        System.out.printf("%-10s = %-8d\n", "20 - 5", 20 - 5);
        System.out.printf("%-10s = %-8d\n", "5 - 20", 5 - 20);
        System.out.printf("10 * 662  = %8d\n", 10 * 662);
        System.out.printf("150 / 8   = %8d\n", 150 / 8);
        System.out.printf("150 %c 8  = %8d\n", '%', 150 % 8);
        System.out.println();

        System.out.println("실수형 사칙연산");
        System.out.printf("10.0 + 52.3 = %f\n", 10.0 + 52.3);
        System.out.printf("10.5f + 12.3 = %f\n", 10.5f + 12.3);
        System.out.printf("10.4 - 50 = %f\n", 10.4 - 50);
        System.out.printf("10.2 * 4.2 = %f\n", 10.2 * 4.2);
        System.out.printf("150 / 8.0 = %f\n", 150 / 8.0);
        System.out.printf("5.2 / 1.2 = %f\n", 5.2 / 1.2);
        System.out.printf("5.2 %c 1.2 = %f\n", '%', 5.2 % 1.2);

        System.out.println();
        System.out.println("사칙 연산의 주의사항");
        System.out.printf("%-10s // %d\n", "underflow", Integer.MIN_VALUE - 1);
        System.out.printf("%-10s // %d\n", "overflow", Integer.MAX_VALUE + 1);

        int maxVal = 0b01111111111111111111111111111111;
        int negVal = 0b10000000000000000000000000000001;
        System.out.println(maxVal + "\n");
        int minVal = 0b10000000000000000000000000000000;

        System.out.println("실수 연산에서 주의해야할 사항");
        System.out.println((6 - 5.9) * 10); // 6.0 의 정밀도 문제. 실수형 데이터의 경우에는 정수로 사용하려고 할 때 문제가 될 수 있을 것.
        System.out.println(40 / 0.0); // Infinity -> 일반적으로 Inf 에 의해 NaN 띄우는 경우가 많다.
        System.out.println(40 % 0.0); // NaN

        // 대입 연산자
        z = x + y;
        z += 10; // z = z + 10;
        z %= 2;


        // 비교 연산자
        int a = 1, b = 2;
        System.out.println("비교 연산자");
        System.out.printf("%b %b %b\n", a > b, a < b, a == b);


        // 논리 연산자 - 입출력이 모두 Boolean
        // a AND b : true only when A == true, B == true
        // a OR  b : true if A == true OR B == true
        // a XOR b : true only when A != B && (A == true) || (B == true)
        // NOT   a : true if A == false (단항 연산자 - Single Operand)

        System.out.println(10 < 20 & 40 >= 2); //AND
        System.out.println(40 < 20 | 20 < 40); //OR
        System.out.println(true ^ true); //XOR
        System.out.println(!false); //NOT

        // short-circuit
        System.out.println("b" == "b");
        System.out.println(false || true);

        // 증감 연산자
        int i = 10;
        System.out.printf("%d %d %d %d\n", i++, ++i, --i, i--); // expr eval 이후 적용 혹은 전에 적용
        // System.out.println(i++); == sout(i); i+=1;
        // System.out.println(--i); == i-=1; sout(i);

        // 삼항 연산자
        // (cond) ? (true expr) : (false expr)
        // boolean ? val : val
        System.out.println(true ? 1 : 0);
        System.out.println(false ? 1 : 0);

        x = 10;
        y = 13;
        System.out.println(x > y ? x : y); // max
        System.out.println(x < y ? x : y); // min

        // 비트 연산자
        // 정수형 연산에 사용
        printBinary(8);
        printBinary(8 << 1);
        printBinary(9);
        printBinary(9 << 1);
        printBinary(1423 >> 2);
        printBinary(1423);
        printBinary(1423 << 2);
        printBinary(-1);
        printBinary(-1 >> 1);
        printBinary(-1 >>> 1); // sign 과 무관하게 0으로 채운다
        printBinary(3 >>> 1);
        printBinary(3 >> 1);
        printBinary(1252);
        printBinary(12534);
        printBinary(1252 & 15234);
        printBinary(1252 | 15234);
        printBinary(1252 ^ 15234);
        printBinary(~1252);
        printBinary(~0);

        int val = -1;
        printBinary(val);
        val >>>= 2;
        printBinary(val);

        val = 0;
        printBinary(val);
        val |= 9;
        printBinary(val);
    }

    private static void printBinary(int number) {
        System.out.printf("0b%32s\n", Integer.toBinaryString(number));
    }
}
