package io.dsub.homework.day03;

import java.util.ArrayList;
import java.util.List;
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
        int myTurn = 3;
        // write codes here
        solutionOne(gameLength, numPeople, myTurn);
        solutionTwo(gameLength, numPeople, myTurn);
    }

    public static void solutionOne(int gameLength, int numPeople, int myTurn) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = myTurn; i < gameLength; i += numPeople) {

            char[] chars = String.valueOf(i).toCharArray();

            for (int j = chars.length - 1; j >= 0; j--) {
                int num = chars[j] - 48;
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '!') {
                    if ((num % 3 == 0 && num != 0) || num == 5)
                        sb.insert(1, "!");
                }

                if ((num % 3 == 0 && num != 0 || num == 5)) {
                    if (num % 3 == 0) sb.insert(0, "짝!");
                    if (num == 5) sb.insert(0, "쿵!");
                    continue;
                }

                if (sb.length() > 0 && (sb.charAt(0) == '쿵' || sb.charAt(0) == '짝')) {
                    sb.insert(0, "!").insert(0, num);
                    continue;
                }

                sb.insert(0, num);
            }
            if (sb.charAt(sb.length() - 1) != '!') sb.append("!");
            list.add(sb.toString());
            sb.delete(0, sb.length());
        }

        for (String s : list) System.out.println(s);
    }


    public static void solutionTwo(int gameLength, int numPeople, int myTurn) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = myTurn; i < gameLength; i += numPeople) {
            int cpNum = i;
            while (cpNum != 0) {
                int num = cpNum % 10;
                cpNum /= 10;
                numStack.push(num);
            }
            numStack.push(-1);
        }

        boolean isEnd = false;

        while (!numStack.isEmpty()) {
            int num = numStack.pop();

            if (numStack.isEmpty() && sb.length() == 0) {
                if (num % 3 == 0 && num != 0) sb.append("짝!");
                else if (num == 5) sb.append("쿵!");
                else if (num != -1) sb.append(num).append("!");

                strStack.push(sb.toString());
                continue;
            } else {
                int peek = numStack.peek();
                if (peek % 3 == 0 && peek != 0) {
                    isEnd = true;
                } else if (peek == -1 || peek == 5) {
                    isEnd = true;
                }
            }

            if (num < 0) {
                if (sb.length() == 0) continue;
                strStack.push(sb.toString());
                sb.delete(0, sb.length());
            }

            if (num % 3 == 0 && num != 0) sb.append("짝");
            else if (num == 5) sb.append("쿵");
            else if (num != -1) sb.append(num);

            if (isEnd && sb.length() > 0) {
                isEnd = false;
                sb.append("!");
            }
        }

        while (strStack.isEmpty())
            System.out.println(strStack.pop());
    }
}
