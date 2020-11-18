package io.dsub.day08.poly02;

/**
 * 멤버 변수의 재정의는 선언된 객체의 타입을 따른다. (문법적으로 본다)
 * 메소드 오버라이딩은 메모리상의 객체 타입을 따른다. (실제 객체로 본다)
 * (가상 메소드 호출, Virtual method call)
 *
 * Foo 에서의 methodA 는 문법상의 필요에 의해 만들어진 것 으로 실질적인 구현은 전혀 의미가 없음을 알 수 있다.
 * 애초에 작성하지 않았다면 Foo 는 Bar 가 가진 메소드를 캐스팅 후 사용 할 수 없었을 것 이다.
 * 이러한 특성에 의해, abstract method 를 구현하고 사용하는 것 과 methodA 를 재정의하고 사용하는 것은
 * 같은 Virtual method call 에 해당한다고 볼 수 있다.
 *
 * Static, non-static 관계 없이 (즉 멤버 변수 및 정적 변수 둘 다) 변수들은 전부 선언된 클래스에서의 정의를 따르게 된다.
 */

class Foo {
    public String x = "super";
    public void methodA() {
        System.out.println("Super Method");
    }
}

class Bar extends Foo {
    public String x = "sub";
    @Override
    public void methodA() {
        System.out.println("Sub Method");
    }
}

public class Poly02 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        Foo foo = (Foo)bar;

        System.out.println(bar.x);
        bar.methodA();

        System.out.println(foo.x);
        foo.methodA();
    }
}
