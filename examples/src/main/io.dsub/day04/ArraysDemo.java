package main.io.dsub.day04;

import java.util.Arrays;

/**
 * 배열(Array)
 * 배열의 특성
 * - 하나의 변수로 여러개의 값을 다룰 수 있다.
 * - 동일 자료 형만 다룰 수 있다.
 * - 한번 생성한 배열의 크기는 변하지 않는다.
 * - 배열에 속한 값은 메모리에 연속으로 위치한다.
 */

public class ArraysDemo {
    public static void main(String[] args) {
        int intVal;
        int[] integers;
        // int cStyleIntegers[];

        long[] longs;
        char[] chars;
        String[] strings;

        // 배열의 생성과 초기화
        integers = new int[10];
        int[] integers2 = new int[10];
        int val = 10;
        Arrays.fill(integers2, val);
        System.out.println(integers2[5]);

        // 값을 넣을 때 순차적으로 할 필요 없음

        int[] integers3 = new int[]{5, 2, 3, 6, 12, 4};
        // ArrayIndexOutOfBoundsException 오류 발생
        // System.out.println(integers3[6]);

        int[] integers5 = {1, 4, 5, 23, 0}; // new int 빼도 초기화 가능

        float[] floats = new float[5];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = (float) (i * 0.25);
        }

        System.out.println(Arrays.toString(floats));
        System.out.print("for (int i = 0; i < floats.length; i++)\n\t");
        for (int i = 0; i < floats.length; i++)
            System.out.print(floats[i] + " ");
        System.out.println();

        // Enhanced for, for each
        System.out.print("for (float f : floats)\n\t");
        for (float f : floats)
            System.out.print(f + " ");
        System.out.println();

        // 배열의 크기를 변경
        int[] src = {1, 2, 3, 4, 5};
        int[] dst = new int[10];
        System.out.print("for (int i = 0; i < src.length; i++)\n>> ");
        for (int i = 0; i < src.length; i++)
            dst[i] = src[i];

        for (int integer : src)
            System.out.print(integer + " ");
        System.out.println();

        System.out.print("System.arraycopy(src2, 0, dst, 0, src2.length);\n>> ");
        int[] src2 = {1, 2, 3, 4, 5};
        int[] dst2 = new int[10];
        System.arraycopy(src2, 0, dst, 0, src2.length);

        for (int integer : src2)
            System.out.print(integer + " ");
        System.out.println();

    }

    private static int[] append (int[] src, int item) {
        int[] dst = new int[src.length + 1];
        System.arraycopy(src, 0, dst, 0, src.length);
        dst[dst.length - 1] = item;
        return dst;
    }
}
