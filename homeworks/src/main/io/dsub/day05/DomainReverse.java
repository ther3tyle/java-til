package main.io.dsub.day05;

/**
 * 도메인 뒤집기
 * <p>
 * 주어진 홈페이지 주소를 .을 기준으로 각각 뒤집어 출력하시오.
 * <p>
 * ex) www.google.com -> www.elgoog.moc
 * <p>
 * 인자
 * string: 홈페이지 주소
 */

public class DomainReverse {
    public static void main(String[] args) {
        String string = "www.google.com";
        // write codes here
        System.out.println(printReverse(string));
    }

    private static String printReverse(String s) {
        StringBuilder sb = new StringBuilder();
        int head = s.startsWith("www.") ? 4 : 0;
        int tail = s.length();

        for (int i = head; i < tail; i++) {
            if (s.charAt(i) == '.') {
                tail = i;
                break;
            }
        }

        sb.append(s, head, tail).reverse();

        if (head == 4) {
            sb.insert(0, s.substring(0, 4));
        }

        sb.append(s.substring(tail));
        return sb.toString();
    }
}
