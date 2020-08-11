package day03;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        int seqLength = 10000;
        // write codes here
        BigInteger[] tail;

        tail = iterativeFibString(seqLength);
//        tail = recursiveFibString(seqLength);
//        System.out.println(tail[tail.length -1]);
        System.out.printf("fibonacci on %d\n\n", tail.length -1);
        System.out.println(tail[tail.length - 1]);
    }

    private static BigInteger[] iterativeFibString(int n) {
        BigInteger[] resArr = new BigInteger[n+1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                resArr[i] = BigInteger.valueOf(i);
            } else {
                resArr[i] = resArr[i-2].add(resArr[i-1]);
            }
        }
        return resArr;
    }

    private static BigInteger[] recursiveFibString(int n) {
        BigInteger[] tail = new BigInteger[n];
        fib(n, tail);
        return tail;
    }

    private static void fib(int n, BigInteger[] tail) {
        if (n == 0) {
            tail[0] = BigInteger.ZERO;
            return;
        }

        fib(n - 1, tail);

        if (n < 3) {
            if (n == 2) {
                tail[n] = BigInteger.ONE;
            } else {
                tail[n] = BigInteger.valueOf(n);
            }
        } else {
            tail[n] = tail[n-1].add(tail[n-2]);
        }

    }
}
