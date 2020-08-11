package day09.interfaces;

interface IFoo {
    public static final int MEMBER_VAR = 10;
    int MEMBER_VAR2 = 20; // public static final

    public abstract void methodA(int param);
    void methodB(int param);
}

class Foo implements IFoo {
    @Override
    public void methodA(int param) {
        System.out.println(param);
    }

    @Override
    public void methodB(int param) {
        System.out.println(param);
    }
}


interface Walkable {
    void walk();
}

interface Runnable {
    void run();
}

interface Jumpable extends Walkable, Runnable {
    void jump();
}

class Jumper implements Jumpable {
    @Override
    public void walk() {
        System.out.println("walk");
    }

    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void jump() {
        System.out.println("jump");
    }
}


/**
 * JDK 1.8 이후의 인터페이스
 * <p>
 * 인터페이스에는 default 메소드를 구현할 수 있다.
 * - default 메소드는 항상 public이다
 * - 인터페이스의 철학과 맞지 않으나 기존에 사용하던 인터페이스가 개선되어 모든 자식 메소드에 동일하게 구현되어야 하는 메소드가 생긴 경우에 쉽게 기능을 추가하기 위해 만들어짐
 */

interface IFooTwo {
    void abstractMethod();
    default void defaultMethod() {
        System.out.println("Default Method");
    }
}

class FooTwo implements IFooTwo {
    @Override
    public void abstractMethod() {
        System.out.println("abstract method implemented");
    }
}

class SuperFoo {
    public void defaultMethod() { // public 이 없을 경우 자식 클래스에서 구현 해주어야 한다.
        System.out.println("Default method in Super class");
    }
}

class FooThree extends SuperFoo implements IFooTwo {
    @Override
    public void abstractMethod() {
        System.out.println("abstract method implemented");
    }
}

interface IBar {
    static void staticMethod() {
        System.out.println("static method");
    }
}

class Bar implements IBar {

}


public class Interface {
    public static void main(String[] args) {
        FooTwo fooTwo = new FooTwo();
        fooTwo.abstractMethod();
        fooTwo.defaultMethod();

        FooThree fooThree = new FooThree();
        fooThree.abstractMethod();
        fooThree.defaultMethod();

        // 부모와 인터페이스 양쪽에 메소드가 구현되어 있는 경우 부모의 메소드를 실행하게 된다.
        // 이유는 여러군데에서 상속되었을 때 구현되어있는 메소드가 없으므로 인터페이스를 기존에는 다중 상속받을 수 있었다.
        // 하지만 public abstract 가 아닌 default 메소드가 생기면서 문제가 생긴 것 이다.
        // 이 경우 다중 상속 시 문제를 방지하기 위해, 인터페이스보다 일반 상속이 우선시된다.

        IBar.staticMethod(); // 인터페이스명으로 클래스 메소드 호출 가능
        // Bar.staticMethod(); // 구현체인 자식 클래스로는 IBar의 클래스 메소드 호출이 불가능하다.

        Jumper jumper = new Jumper();
        Jumpable jumpable = jumper;
        Runnable runnable = jumpable;
        Walkable walkable = (Walkable) runnable;

        walkable.walk();
        runnable.run();
        ((Walkable) runnable).walk();
        jumpable.jump();
    }
}
