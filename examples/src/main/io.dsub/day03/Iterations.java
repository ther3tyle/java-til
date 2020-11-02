package main.io.dsub.day03;

/**
 * 반복문 (Loops)
 * for, while, do while
 * 초기화 - 반복문을 실행하기 위해서 증감할 변수를 초기화
 * 조건식 - 반복문을 실행할 조건 (혹은 종료할 조건)
 * 실행문 - 조건식이 참(또는 거짓)일 경우 실행 할 코드
 * 증감식 - 실행문이 실행된 후에 변수를 증감하는 식
 * 증감 -> 변수의 값에 대한 증가 혹은 감소를 의미
 */

public class Iterations {
    public static void main(String[] args) {


        // 일반적인 For 문의 형태들

        for (int i = 0; i < 5; i++)
            if (i == 4) System.out.printf("%d\n", i);
            else System.out.printf("%d, ", i);

        for (int i = 0; i < 5; i += 2)
            System.out.println(i);


        for (int i = 5; i >= 0; --i)
            System.out.println(i);


        // Nested For Loops
        int cnt = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                System.out.printf("(%d, %d) -<>- %d\n", i, j, cnt++);


        for (int i = 0; i < 5; i++)
            System.out.print(i); // iter
        System.out.println(); // did not iter


        // *=*=*=*=* WHILE *=*=*=*=
        int i = 0;
        while (i < 5) {
            System.out.print(i++);
        }
        do {
            System.out.print(i++);
        } while (i < 0); // 반드시 한번 실행된 이후에 체크한다.

        // *=*=*=*= 제어문 (break, continue) *=*=*=*=
        boolean touched = false;
        for (int z = 0; z < 3; z++) {
            if (z == 2 && !touched) {
                touched = true;
                z = 0;
                continue;
            }
            if (z == 1 && touched) break;
            System.out.printf("%d ", z);
        }
        System.out.println();

        // LABEL
        cnt = 0;
        outerLoop:
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (j == 3 && k == 2) continue outerLoop; // skips the outer labeled loop
                System.out.printf("%d * %d = %d\t", j, k, j * k);

                cnt++;
                if (cnt == 11) {
                    cnt = 0;
                    System.out.print("\n");
                }
            }
        }

        

    }
}
