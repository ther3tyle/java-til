package day04;

/**
 * 행렬의 곱 계산하기
 *
 * 두 행렬의 곱을 구하는 프로그램을 작성하시오.
 * 행렬의 곱을 계산한 후에 행렬 형태로 출력하시오.
 *
 *
 * 인자
 * matA: N x M 행렬
 * matB: M x K 행렬
 */

public class MatMul {
    public static void main(String[] args) {
        int[][] matA = {{1, 2, 3}, {4, 5, 2}};
        int[][] matB = {{5, 2}, {6, 2}, {1, 0}};
        int[][] matC = new int[2][2];

        // write codes here
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matB[0].length; j++) {
                for (int k = 0; k < matA[0].length; k++) {
                    matC[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }

        System.out.print(">> PRINT\n");
        for (int[] entry : matC) {
            System.out.print("\t");
            for (int i : entry) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
