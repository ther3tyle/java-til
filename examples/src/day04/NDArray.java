package day04;

/**
 * N-D 배열 (N-D Arrays)
 * 배열이 배열을 담고 있으면 다차원 배열이라고 한다 (N-D Array)
 * 수학에서 말하는 차원의 개념과 흡사하다 (점 -> 선 -> 면 -> 공간 -> 시공간)
 */

public class NDArray {
    public static void main(String[] args) {
        int[][] ints; // Java-like
        // int[] integers[]; // hybrid
        // int integers2[][]; // old...

        ints = new int[10][5]; // 길이가 5인 배열을 담고 있는 길이가 10인 배열. 부모 차원이 앞에 온다.
        ints = new int[10][]; // 우선 각 자식 배열의 길이를 알지 못할 경우
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new int[5];
        }

        ints = new int[5][]; // 하위 차원의 길이는 달라질 수 있다.
        ints[1] = new int[30];
        ints[2] = new int[22];

        ints = new int[][]{{2, 3}, {4, 5, 6}, {5, 6, 7, 8}}; // int[3][] -> 하위 차원의 길이를 전부 다르게 한 경우
        for (int[] cArr : ints) {
            for (int i : cArr) {
                // do something
            }
        }


    }
}
