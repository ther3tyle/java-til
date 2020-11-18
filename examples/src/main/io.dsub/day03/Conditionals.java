package io.dsub.day03;

public class Conditionals {

    /**
     * 조건문 - 조건에 따라서 코드의 실행 흐름을 결정한다.
     * if 계열
     * switch 계열
     * <p>
     * [branch 문] - 기계어 수준에서 부르는 조건 실행문.
     */

    public static void main(String[] args) {
        String sNum = "510225-2055132";
        char c = sNum.charAt(7);
        System.out.println(c);

        if ((c - '0') % 2 > 0) {
            System.out.println("남자입니다");
        } else {
            System.out.println("여자입니다");
        }

        int x = 6;
        System.out.println(x % 2 == 0 ? "짝수입니다\n" : "홀수입니다\n");

        int score = 2;
        char grade;

        if (score >= 9) grade = 'A';
        else if (score >= 7) grade = 'B';
        else if (score >= 5) grade = 'C';
        else if (score >= 3) grade = 'D';
        else grade = 'F';
        System.out.println(grade);


        /**
         * NESTED *IF* STATEMENT
         */

        score = 90;
        boolean isLate = true;
        // late 인 경우 하나 낮은 등급을 주기로 했다.
        if (grade >= 90) {
            grade = 'A';
            if (isLate) grade++;
        } else if (grade >= 80) {
            grade = 'B';
            if (isLate) grade++;
        } else if (grade >= 70) {
            grade = 'C';
            if (isLate) grade++;
        } else if (grade >= 60) {
            grade = 'D';
            if (isLate) grade = 'F';
        } else {
            grade = 'F';
        }

        // switch ~ case statement
        // boolean 에 한정되지 않는다.
        // case 는 범위가 될 수 없으며 case 도 값이어야 한다.
        // break 없는 경우 fall-through
        char charVal = 'A';
        switch (charVal) {
            case 'A':
                System.out.println("훌륭합니다!");
                break;
            case 'B':
                System.out.println("멋집니다!");
                break;
            case 'C': // 'C'와 'D'는 결과를 공유한다.
            case 'D':
                System.out.println("많이 노력하세요");
                break;
            case 'F':
                System.out.println("다음엔 잘하세요");
                break;
            default:
                System.out.println("잘못된 값이 입력되었습니다.");
        }

    }

}
