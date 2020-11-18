package io.dsub.day08.poly01;

/**
 * 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징
 */

class Foo {
    public void methodA() {
    }
}

class Bar extends Foo {
    public void methodB() {
    }
}

public class Poly01 {
    public static void main(String[] args) {
        Bar bar = new Bar(); // new 를 통해 새 객체를 생성 (자식 객체를 생성)
        Foo foo = (Foo) bar; // 부모 클래스 타입으로 자식 객체를 받음 (여전히 자식 객체가 힙 영역에 있다)

        foo.methodA(); // 부모에게서 물려받은 bar 에 해당하므로 부모의 클래스 메소드 사용 가능
        // 여기서 methodA의 사용은 문법적으로 가능한 것 이고, B는 문법적으로 불가능한 것 이다.
        // 실질적으로는 bar 객체가 foo에 담겨있는 것 이고, 메소드 사용은 문법적으로만 제한되어 있는 것이다.
        // foo.methodB(); // 이 경우 자식 클래스 메소드는 사용이 불가능하다

        Foo foo1 = new Foo();
        // Bar bar1 = (Bar)foo1; // 자식 클래스 타입으로 부모 객체를 받은 것 자체가 오류이나 문법상은 문제가 없다.
        // 문법 오류는 아니지만 런타임 오류가 발생한다.
        // 자식 클래스 자료형으로 객체를 보려 하지만 부모 객체 부분만 존재하기 때문에 런타임에서 오류가 발생하는 것 이다.
        // bar1.methodA(); // 문법 오류 x
        // bar1.methodB(); // 문법 오류 x

        // 힙 영역에는 계속 자식 객체가 있었기 때문에 가능한 것 이다.
        Bar bar2 = (Bar)foo;
        bar2.methodA();
        bar2.methodB();
    }
}
