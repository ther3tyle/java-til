package io.dsub.lectures.day06;

/**
 * 클래스에 대한 설명. 이 클래스는 자바독 클래스로서 자바독을 공부하기 위해...
 * 일반적으로 사용에 대한 내용만 작성을 합니다.
 * 정확히 어떻게 구현이 되었는지보단 사용에 대한 내용을 설명하는 데에 집중한 것 입니다.
 * @author ther3tyle.
 */
public class JavaDocs {

    /**
     * 멤버 변수에 대한 설명을 적을 수 있어요.
     */
    int memberInt;

    /**
     * 또 다른 멤버 변수에도 설명을 적을 수 있어요.
     */
    String memberString;

    /**
     * 메소드에 대한 설명을 여기에 적습니다.
     * @param s 패러미터 s 에 대한 설명을 적습니다.
     * @return 리턴 값에 대한 설명은 여기에 적습니다.
     */
    public int methodA(String s) {
        return s.length();
    }

    /**
     * 생성자에 대한 설명을 적습니다.
     * @param memberInt 첫번째 패러미터에 대한 설명을 적습니다.
     * @param memberString 두번째 패러미터에 대한 설명을 적습니다.0
     */
    public JavaDocs(int memberInt, String memberString) {
        this.memberInt = memberInt;
        this.memberString = memberString;
    }

    public static void main(String[] args) {
        JavaDocs j = new JavaDocs(1, "string");
        j.methodA("hello");
    }
}
