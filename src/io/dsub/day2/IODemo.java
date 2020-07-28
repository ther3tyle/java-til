package io.dsub.day2;

import java.nio.file.NoSuchFileException;

/**
 * 자료 입출력
 * 출력 print println printf, Formatting
 * 입력 keyboard 입력 받기
 */

public class IODemo {
    public static void main(String[] args) {
        System.out.printf("%.6f is for floating number types\n", Math.PI);
        System.out.printf("%d 0x%x 0X%X 0%o\n", 15, 15, 15, 15);
        System.out.printf("%e\n", 14.423);
        System.out.printf("%c %c\n", 45, '\u0042');
        System.out.printf("%n");


        // Decimal
        System.out.printf("%5d.\n", 10);
        System.out.printf("%-5d.\n", 10);
        System.out.printf("%05d\n", 234);
        System.out.printf("%3d\n", 104294); // 3 칸을 최소한의 요구사항으로 두었을 뿐임. 실제로 전체 표기됨.

        // Floating Number
        System.out.printf("%5.4f\n", 152323.456228);
        System.out.printf("%11.4f.\n", 332.33484);
        System.out.printf("%-11.4f.\n", 332.33484);

        int[][] table = {{3,1,2,5,3,1,4}, {4,8,6,4,5,7,2,4}, {3,1,2,4,5,6,3,6}, {4,2,3,4,5,3,4,5}, {3,6,5,4,4,2,3,4}, {4,3,2,6,7,4,4,3}, {6,4,6,3,4,5,2,3}, {3,2,5,7,7,4,3,4}};
        printTable(table, 2);
    }

    public static void printTable(int[][] table) {
        printTable(table, 0);
    }

    public static void printTable(int[][] table, int extraMargin) {
        int defMargin = 2;
        extraMargin = extraMargin < 0 ? -extraMargin : extraMargin;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < defMargin + extraMargin; i++) {
            sb.append(" ");
        }
        String sMargin  = sb.toString();
        sb.delete(0, sb.length());

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                sb.append(table[i][j]);
                if (j <  table.length - 2) {
                    sb.append(sMargin);
                }
            }
            System.out.printf("%s\n", sb.toString());
            sb.delete(0, sb.length());
            for (int k = 0; k < extraMargin - 1; k++) {
                System.out.println();
            }
        }
    }
}
