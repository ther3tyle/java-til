package io.dsub.day21;


/**
 * TDD, 테스트 주도 개발 (Test-Driven Development)
 * - '실패하는' 테스트 케이스를 먼저 작성하고 그것을 통과시키는 방향으로 코드를 구현하는 방식
 * - 테스트 케이스 작성 -> 코드 구현 -> 테스트 케이스 작성.. 을 빠르게 반복한다.
 */
public class RomanConverter {
    private String roman = "";

    public int transform() {
        if (this.roman.isEmpty()) {
            throw new NullPointerException();
        }

        if (roman.contains("X")) {
            return 10;
        }

        int count = 0;

        boolean beforeV = roman.contains("V");

        for (char c : roman.toCharArray()) {
            if (c == 'I') {
                count += beforeV ? -1 : 1;
            }
            if (c == 'V') {
                beforeV = false;
                return count += 5;
            }
        }

        return count;
    }

    public String getRoman() {
        return roman;
    }

    public void setRoman(String roman) {
        this.roman = roman;
    }
}
