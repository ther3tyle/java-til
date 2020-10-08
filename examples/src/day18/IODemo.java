package day18;

import java.io.Serializable;

public class IODemo {
    public static void main(String[] args) {

        // 객체 직렬화를 위한 인터페이스 - Serializable
        // Heap 내용의 멤버 변수 등을 참조하여 어떤 데이터인지 확인할 수 있으므로
        // 읽어온 노드를 통해 필요한 구간들에 대해 직렬화를 할 수 있다.
        // 이렇게 일렬로 만든 데이터를 다시 객체화 하는 것 을 Deserialize(역직렬화) 라고 한다.
        class Foo implements Serializable {
            // 객체의 클래스 버전 관리
            // 객체를 저장할 때, 불러올 때 같은지를 체크합니다
            // serialVersionUID 가 일치하지 않으면 실패합니다.
            // 즉 클래스 업데이트가 존재하는 경우에는 반드시 업데이트 해주어야 합니다.
            static final long serialVersionUID = 1L;
        }
    }
}
