package main.io.dsub.day05;

/**
 * 클래스와 객체의 메모리 구조
 * - 클래스 영역 (Class area, method area, code area, static area)
 *      - field 정보, method 정보, type 정보, constant pool
 * - 스택 영역(Stack area) -> 실행 우선 순위 -> 역폴란드법과 비슷
 *      - method 호출 시 선언된 로컬 변수 (임시로 있다가 사라짐)
 * - 힙 영역(Heap area)
 *      - new 키워드로 생성된 객체
 *      - garbage collection(GC) 이 동작하는 영역
 *          더이상 사용하지 않는 메모리를 알아서 변환하는 JVM 의 기능
 */

public class MemoryStructure { // 클래스 영역
    int x, y; // 힙 영역
    String string = "String!"; // 힙 영역, "String" 은 constant pool

    public void method(int value) { // 클래스 영역
        char c = 'w'; // 스택 영역

    }
}
