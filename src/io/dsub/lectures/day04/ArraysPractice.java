package io.dsub.lectures.day04;

import java.util.Arrays;

/**
 * Array 연습
 */
public class ArraysPractice {
    public static void main(String[] args) {
        int[] integers = {4, 2, 112, 32, 5, 23, -213, 5, 34, 2 - 5, 234, 43, -32};

        // 1. 위 배열에서 최대값을 찾는 프로그램을 작성하시오
        int max = Integer.MIN_VALUE;
        for (int i : integers)
            max = max < i ? i : max;
        System.out.printf("integers: %s\n>> 최대값 %d\n\n", Arrays.toString(integers), max);

        // 2. 위 배열에서 두번째로 큰 값을 찾는 프로그램을 작성하시오
        max = Integer.MIN_VALUE;
        int secondMax = max;
        for (int i : integers) {
            if (max < i) {
                secondMax = max;
                max = i;
            }
        }
        System.out.printf("integers: %s\n>> 최대값 %-8d 두번째 최대값 %d\n\n", Arrays.toString(integers), max, secondMax);

        integers = new int[]{3, 6, 3, 2345, 13, 231, 4213, 5, 1, 5135213, 4, 214, 124, 21, 4321, 432, 14, 231, 53, 12, 5312, 531, 4, 14};
        max = Integer.MIN_VALUE;
        int left = 0, right = integers.length - 1;
        while (left <= right) {
            int larger = max;
            if (larger < integers[left]) larger = integers[left];
            if (max != larger) {
                secondMax = max;
                max = larger;
            }
            if (larger < integers[right]) larger = integers[right];
            if (max != larger) {
                secondMax = max;
                max = larger;
            }
            left++;
            right--;
        }
        System.out.printf("integers: %s\n>> 최대값 %-8d 두번째 최대값 %d\n\n", Arrays.toString(integers), max, secondMax);
    }
}
