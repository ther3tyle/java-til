package io.dsub.homework.day02;

/**
 * 링카운터 출력기
 *
 * 크기가 4인 링카운터는 아래와 같이 동작한다.
 *
 * 0b0001 -> 0b0010 -> 0b0100 -> 0b1000 -> 0b0001 ...
 *
 * 즉, 링카운터는 하나의 비트만 1의 값을 가지며 1의 위치가 N번마다 반복되는 형태로 동작한다.
 *
 * 링카운터의 크기 numBits와카운트된 횟수 numCount를 이용하여
 * 현재 링카운터의 값을 10진수로 출력하는 프로그램을 작성하시오.
 */

public class RingCounter {
    public static void main(String[] args) {
        int numBits = 12;
        int numCount = 19;

        int res = count(12, 19);
        System.out.println(res);
    }

    private static int count(int numBits, int numCount) {
        int max = 1;

        while (numBits > 1) {
            max *= 2;
            numBits--;
        }

        int val = 1;

        while (numCount > 0) {
            val <<= 1;
            val = val > max ? 1 : val;
            numCount--;
        }

        return val;
    }
}
