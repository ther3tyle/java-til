package io.dsub.lectures.day08.examples.abstract01;

/**
 * 추상 클래스 (Abstract Class)
 * - 일부 메소드가 구현되지 않고 선언만 되어있는 클래스
 *      - 자식 클래스에서 이것을 반드시 구현하게끔 강제하는 것
 *      - 필요한 모든 클래스가 구현될 수 있도록 하여 안정성을 높임
 */

abstract class AbstractFoo {
    int x, y;
    public void method() {
        System.out.println("method");
    }

    // 이 부분은 우리가 일반적으로 알고 있는 virtual method call 과 전혀 다르지 않다. 있는 그대로 구현한다.
    public abstract void abstractMethod(); // 추상 메소드는 선언만 되고 구현은 하지 않는다 (세미콜론을 잊지 말자 - 시험에 나올 수 있다(?))
}

class Foo extends AbstractFoo {
    @Override
    public void abstractMethod() {
        System.out.println("implemented abstractMethod");
    }
}

public class Abstract01 {
    public static void main(String[] args) {
        // AbstractFoo afoo =  new AbstractFoo(); // 추상 클래스는 객체 생성을 할 수 없다. 구현이 다 되어있지 않기 때문이다.
        Foo foo = new Foo();
        foo.abstractMethod();

        AbstractFoo afoo = (AbstractFoo) foo;
        afoo.abstractMethod(); // 가상 메소드 호출

        // 추상 클래스는 객체 생성은 불가능하지만 구현된 자식 클래스의 객체는 받을 수 있다.
    }
}
