package io.dsub.homework.day03;

import java.util.Arrays;
import java.util.Stack;

/**
 * 369게임+
 * <p>
 * 369게임에 참여했을 때, 내가 외쳐야 하는 숫자나 동작을 순서대로 출력하시오.
 * <p>
 * 규칙
 * 1. 3, 6, 9, 5가 포함되지 않은 숫자는 숫자를 외친다. (2!)
 * 2. 숫자에 포함된 3, 6, 9의 개수 만큼 박수를 친다. (짝!)
 * 3. 숫자에 포함된 5의 개수 만큼 발을 구른다. (쿵!)
 * 4. 박수와 발구르기의 순서는 관계 없으나, 반드시 번갈아 수행한다.
 * <p>
 * 예시
 * 2   -> 2!
 * 33  -> 짝!짝!
 * 553 -> 쿵!짝!쿵! (짝!쿵!쿵!x)
 * 47  -> 47!
 * <p>
 * 인자
 * gameLength: 게임이 종료되는 데 걸리는 턴 수
 * numPeople: 게임에 참여하는 인원 수
 * myTurn: 내가 숫자를 외치는 순번
 */

public class ThreeSixNineAdvanced {
    public static void main(String[] args) {
        int gameLength = 1000;
        int numPeople = 12;
        int myTurn = 1;
        // write codes here
        solver(gameLength, numPeople, myTurn);
    }

    private static void solver(int gameLength, int numPeople, int myTurn) {
        for (int i = myTurn; i < gameLength; i += numPeople) {
            int numClap = 0, numRoll = 0;
            int cpNum = i;
            while (cpNum > 0) {
                int sDigit = cpNum % 10;
                cpNum /= 10;
                if (sDigit % 3 == 0 && sDigit != 0) {
                    numClap++;
                } else if (sDigit == 5) {
                    numRoll++;
                }
            }
            if (numClap + numRoll == 0) {
                System.out.println(i + "!");
            } else {
                while (numClap > 0 || numRoll > 0) {
                    if (numClap > numRoll) {
                        System.out.print("짝!");
                        if (numRoll > 0) System.out.print("쿵");
                    } else {
                        System.out.print("쿵!");
                        if (numClap > 0) System.out.print("짝!");
                    }
                    numClap--;
                    numRoll--;
                }
                System.out.println();
            }
        }
    }
}
