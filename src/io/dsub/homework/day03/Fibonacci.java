package io.dsub.homework.day03;

public class Fibonacci {
    public static void main(String[] args) {
        int seqLength = 100;
        makeFibString(seqLength);
        // write codes here
    }

    private static void makeFibString(int n) {
        int[] tail = new int[n + 1];
        fib(n, tail);

        for (int i : tail) {
            System.out.printf("%d, ", i);
        }
    }

    private static void fib(int n, int[] tail) {
        if (n == 0) {
            tail[0] = 0;
            return;
        }

        fib(n - 1, tail);

        if (n < 3) {
            if (n == 2) {
                tail[n] = 1;
            } else {
                tail[n] = n;
            }
        } else {
            tail[n] = tail[n-1] + tail[n-2];
        }

    }
}
