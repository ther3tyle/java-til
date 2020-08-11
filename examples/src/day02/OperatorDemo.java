package day02;

/**
 * 연산자(Operator)
 * 연산자(Operator), 피연산자(Operand) -> 연산식(Expression)
 * 사칙 연산자: + - * /
 * 비교 연산자: > >= == <= <
 * 논리 연산자: & | ^ !
 * 증감 연산자: ++ --
 * 삼항 연산자: ?:
 * 비트 연산자: >> >>> << & | ^
 */

public class OperatorDemo {
    public static void main(String[] args) {
        int x = 10, y = 20, z;
        z = x + y;  // +: 연산자, x, y = 피연산자, x + y = expression
        System.out.println("정수형 사칙연산");
        printExpr("20 - 5", String.format("%8d", 20 - 5));
        printExpr("5 - 20", String.format("%8d", 5 - 20));
        printExpr("10 * 662", String.format("%8d", 10 * 662));
        printExpr("150 / 8", String.format("%8d", 150 / 8));
        printExpr("150 % 8", String.format("%8d", 150 % 8));
        System.out.println();

        System.out.println("실수형 사칙연산");
        printExpr("10.0 + 52.3", String.format("%8.2f", 10.0 + 52.3));
        printExpr("10.5f + 12.3", String.format("%8.2f", 10.5f + 12.3));
        printExpr("10.4 - 50", String.format("%8.2f", 10.4 - 50));
        printExpr("10.2 * 4.2", String.format("%8.2f", 10.2 * 4.2));
        printExpr("150 / 8.0", String.format("%8.2f", 150 / 8.0));
        printExpr("5.2 / 1.2", String.format("%8.2f", 5.2 / 1.2));
        printExpr("5.2 % 1.2", String.format("%8.2f", 5.2 % 1.2));

        System.out.println();
        System.out.printf("+=+=+=+ %s +=+=+=+\n", "사칙 연산의 주의사항");
        System.out.printf("%-10s // %d\n", "underflow", Integer.MIN_VALUE - 1);
        System.out.printf("%-10s // %d\n", "overflow", Integer.MAX_VALUE + 1);
        System.out.println();

        System.out.printf("+=+=+=+ %s +=+=+=+\n", "1의 보수를 통한 2진수 값의 음수, 양수 전환");
        System.out.printf("%s -> %s\n", "0b01111111111111111111111111111111", "0b10000000000000000000000000000001\n");

        System.out.printf("+=+=+=+ %s +=+=+=+\n", "실수 연산에서 주의해야할 사항");
        printExpr("(6 - 5.9) * 10", String.valueOf((6 - 5.9) * 10));
        printExpr("40 / 0.0", String.valueOf(40 / 0.0));
        printExpr("40 % 0.0", String.valueOf(40 % 0.0));

        System.out.println();

        // 대입 연산자
        z += 2;
        System.out.println("대입 연산자");
        System.out.printf("current z -> %d\n", z);
        System.out.printf("z += 2; sout(z) -> %s\n", z);

        // 비교 연산자
        System.out.println();
        int a = 1, b = 2;
        System.out.println("비교 연산자");
        System.out.printf("%b %b %b\n", a > b, a < b, a == b);


        // 논리 연산자 - 입출력이 모두 Boolean
        // a AND b : true only when A == true, B == true
        // a OR  b : true if A == true OR B == true
        // a XOR b : true only when A != B && (A == true) || (B == true)
        // NOT   a : true if A == false (단항 연산자 - Single Operand)

        System.out.println();
        System.out.printf("%s\n\t%-15s -> %-15s\n","AND(&)", "(10 < 20 & 40 >= 2)", String.valueOf(10 < 20 & 40 >= 2));
        System.out.printf("%s\n\t%-15s -> %-15s\n","OR(|)", "(40 < 20 | 20 < 40)", String.valueOf(40 < 20 | 20 < 40));
        System.out.printf("%s\n\t%-15s -> %-15s\n","XOR(^)", "true ^ true", String.valueOf(true ^ true));
        System.out.printf("%s\n\t%-15s -> %-15s\n","NOT(!)", "!true", String.valueOf(!true));

        // Short-Circuit
        // You may assume this would be slower, but that is not the case in Java.
        System.out.println("\nShort-Circuit");
        printExpr("\"b\" == \"b\"", String.valueOf("b" == "b"));
        printExpr("false || true", String.valueOf(false || true));

        // 증감 연산자
        System.out.println();
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

    private static void printExpr(String expr, String res) {
        System.out.printf("%-14s = %14s\n", expr, res);
    }
}
