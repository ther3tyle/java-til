package day12;

/**
 * 람다식을 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * <p>
 * 주어진 interface와 실행 메소드를 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 이 테스트 방식을 이용하여 실제 알고리즘 문제를 하나 이상 풀이하시오.
 */

interface Solution<T, R> {
    R solve(T t);
}

class Algorithm<T, R> {
    boolean test(T input, R groundtruth, Solution<? super T, ? super R> solution) {
        return solution.solve(input).equals(groundtruth);
    }
}

// https://leetcode.com problem #420
class StrongPasswordChecker {
    public Integer check(String s) {
        char[] str = s.toCharArray();
        boolean isUpper = false, isLower = false, isDigit = false;
        int missingType = 3;

        for (char c : str) {
            //uppercase
            if (!isUpper && Character.isUpperCase(c)) {
                isUpper = true;
                missingType -= 1;
            }
            //lowercase
            if (!isLower && Character.isLowerCase(c)) {
                isLower = true;
                missingType -= 1;
            }
            //at least one number
            if (!isDigit && Character.isDigit(c)) {
                isDigit = true;
                missingType -= 1;
            }

        }

        int totalChangeCnt = 0, OneChangeCnt = 0, TwoChangeCnt = 0, pos = 2;
        while (pos < s.length()) {
            if (str[pos] == str[pos - 1] && str[pos - 1] == str[pos - 2] && str[pos - 2] == str[pos]) {
                int length = 2;
                while (pos < s.length() && str[pos] == str[pos - 1]) {
                    length += 1;
                    pos += 1;
                }
                totalChangeCnt += length / 3;
                if (length % 3 == 0) {
                    OneChangeCnt += 1;
                } else if (length % 3 == 1) TwoChangeCnt += 1;

            } else {
                pos = pos + 1;
            }
        }

        if (s.length() < 6)
            return Math.max(missingType, 6 - s.length());
        else if (s.length() <= 20)
            return Math.max(missingType, totalChangeCnt);
        else {
            int deleteCount = s.length() - 20;
            //System.out.println(totalChangeCnt);
            totalChangeCnt -= Math.min(deleteCount, OneChangeCnt);
            //System.out.println(totalChangeCnt);
            totalChangeCnt -= Math.min(Math.max(deleteCount - OneChangeCnt, 0), TwoChangeCnt * 2) / 2;
            //System.out.println(totalChangeCnt);
            totalChangeCnt -= Math.max(deleteCount - OneChangeCnt - 2 * TwoChangeCnt, 0) / 3;

            return deleteCount + Math.max(missingType, totalChangeCnt);
        }
    }
}

public class LambdaExpressions {
    public static void main(String[] args) {
        Algorithm<String, Integer> algorithm = new Algorithm<>();
        System.out.println(
                algorithm.test("aaabb38217dfdfddd33216222",
                        6, new StrongPasswordChecker()::check));
    }
}