package main.io.dsub.day05;

/**
 * 문자열 (String)
 * <p>
 * 문자열은 내부적으로 클래스로 구성되어 있다
 * 내부에는 문자의 배열로 된 데이터가 있다 (char[])
 * <p>
 * 한번 만든 문자열은 변하지 않는다 (불변성 = Immutable)
 * <p>
 * 문자열 편집은 String 대신 StringBuilder, Buffer 등을 사용한다
 */

public class StringDemo {
    public static void main(String[] args) {
        String separator = "-+-+-+-";

        // 문자열의 생성
        String s1 = "문자열 생성 방법";
        String s2 = new String("문자열 생성 방법 2"); // 클래스 생성자. 권장하지 않는 방법.

        String s3 = "abcde";
        String s4 = "abcde";
        String s5 = new String("abcde");

        System.out.println("-+-+-+- Comparison -+-+-+-");
        System.out.println("compare by memory");
        System.out.println(s3 == s4); // 문자열을 곧바로 생성할 경우 상수 풀에서 찾아 사용
        System.out.println(s3 == s5); // 문자열을 클래스로 생성할 경우 새로운 값을 생성
        System.out.println("compare by value");
        System.out.println(s3.equals(s4));
        System.out.println(s3.equals(s5));

        System.out.println("\n-+-+-+- String Methods -+-+-+-");
        String s = "This is a string";
        System.out.printf("s.length(): %d, s.charAt(5): %c, s.indexOf('a'): %d\n", s.length(), s.charAt(5), s.indexOf('a'));
        System.out.printf("s.equalsIngoreCase(\"this IS A STRING\": %b, s.replace('i', 't'): %s, s.substring(3, 9): %s\n", s.equalsIgnoreCase("this IS A STRING"), s.replace('i', 't'), s.substring(3, 9));
        System.out.println(" wwefw ".trim()); // 양 옆의 공백을 제거하는 메소드

        System.out.println("\n-+-+-+- String toCharArray() -+-+-+-");
        char[] chars =s.toCharArray();
        for (char c : chars)
            System.out.print(c);
        System.out.println();

        System.out.println("\n-+-+-+- String repeat() -+-+-+-");
        System.out.println("*".repeat(10));
    }
}
