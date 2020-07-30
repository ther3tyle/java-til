package io.dsub.homework.day03;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        int seqLength = 100;
        makeFibString(seqLength);
        // write codes here
    }

    private static void makeFibString(int n) {
        BigInteger[] tail = new BigInteger[n + 1];
        fib(n, tail);

        for (BigInteger i : tail) {
            System.out.printf("%3d, ", i);
        }
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
