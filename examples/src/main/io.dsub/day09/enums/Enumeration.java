package main.io.dsub.day09.enums;

/**
 * 열거형(Enumeration)
 * enum 키워드로 사용
 * 내부적인 구현은 enum -> java.lang.Enum 클래스를 상속
 * enum은 다른 클래스를 상속하지 않음
 *
 * 열거형은 다른 클래스를 상속하지 못하지만 인터페이스 구현은 가능하다.
 * 열거형 타입에는 열거형 상수와 null 값 할당 가능
 */

public class Enumeration {
    public static void main(String[] args) {
        for (Job value : Job.values()) {
            jobResponse(value);
        }
    }

    private static void jobResponse(Job job) {
        switch(job) {
            case STUDENT:
                System.out.print("Hello");
                break;
            case MARKETING:
                System.out.print("Marketer");
                break;
            case DEVELOPER:
                System.out.print("syscall");
                break;
            case CHIEF:
                System.out.print("Chieftain");
                break;
            case CHIEF_EXECUTIVE_OFFICER:
                System.out.print("Ahoy Captain");
                break;
            default:
                System.out.print("What are you?");
                break;
        }
        System.out.printf(" %s\n", job.getName());
    }
}
