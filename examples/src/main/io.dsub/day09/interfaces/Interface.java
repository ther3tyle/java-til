package io.dsub.day09.interfaces;

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
 * - default 메소드는 항상 public 이다
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

public class Interface {
    public static void main(String[] args) {
        FooTwo fooTwo = new FooTwo();
        fooTwo.abstractMethod();
        fooTwo.defaultMethod();

        FooThree fooThree = new FooThree();
        fooThree.abstractMethod();
        fooThree.defaultMethod();

        IBar.staticMethod();
    }
}
