package day02;

import java.util.Scanner;

/**
 * 입력받아 처리하기
 *
 * 3개의 정수를 입력받아, 그 중 최대값을 출력하고자 한다.
 * 이를 수행하는 프로그램을 작성하시오.
 *
 */

public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE, count = 3;

        while (count-- > 0) {
            System.out.print("Enter a number: ");
            int input = sc.nextInt();
            max = Math.max(max, input);
            System.out.println();
        }

        System.out.printf("Result >> %d\n", max);
    }
}
