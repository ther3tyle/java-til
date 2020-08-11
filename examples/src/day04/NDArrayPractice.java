package day04;

import java.util.Optional;

/**
 * N-D Array 연습
 */
public class NDArrayPractice {

    public static void main(String[] args) {
        int[][] matA = {{1,2,3}, {3,4,5}};
        int[][] matB = {{3,4,5}, {1,4,2}};

        // 1. matA + matB를 구하고 출력하시오
        printArrays(merge(matA, matB));
        System.out.println();
        printArrays(transpose(new int[][]{{1,2,3}, {4,5,6}}));
        System.out.println();
        printArrays(arraysSum(matA, matB));
        // 2. matA를 Transpose 하고 출력하시오.
    }

    private static int[][] merge(int[][] srcA, int[][] srcB) {
        int sizeSum = srcA.length + srcB.length;
        int[][] merged = new int[sizeSum][];
        System.arraycopy(srcA, 0, merged, 0, srcA.length);
        System.arraycopy(srcB, 0, merged, srcA.length, srcB.length);
        return merged;
    }

    private static int[][] arraysSum(int[][] srcA, int[][] srcB) {
        int size = Math.max(srcA.length, srcB.length);
        int innerSize = 0;
        for (int[] inner : srcA)
            innerSize = Math.max(innerSize, inner.length);

        for (int[] inner : srcB)
            innerSize = Math.max(innerSize, inner.length);

        int[][] sum = new int[size][innerSize];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < innerSize; j++) {
                if (i < srcA.length && j < srcA[i].length) {
                    sum[i][j] += srcA[i][j];
                }
                if (i < srcB.length && j < srcB[i].length) {
                    sum[i][j] += srcB[i][j];
                }
            }
        }
        return sum;
    }

    private static int[][] transpose(int[][] src) {
        int row = 0;
        for (int[] entry : src)
            row = Math.max(row, entry.length);
        int col = src.length;
        int[][] transposed = new int[row][col];
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                transposed[j][i] = src[i][j];
            }
        }
        return transposed;
    }

    private static void printArrays(int[][] array) {
        System.out.println("Print...");
        for (int[] entry : array) {
            System.out.print("\t");
            for (int num : entry) {
                System.out.printf("%d ", num);
            }
            System.out.print("\n");
        }
    }

}
