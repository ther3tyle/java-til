package io.dsub.day08;

/**
 * 다형성 (Polymorphism)
 *
 * - 오버로딩에 의한 다형성
 * - 오버라이딩에 의한 다형성 (= 상속에 의한 다형성)
 *
 * 다형성의 특징들
 *
 * 1. 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징
 *      - Orange 클래스로 생성된 아래의 객체는 부모 클래스 타입인 aFruit 에 의해 참조되고 있다.
 *        Fruit aFruit = new Orange();
 *
 * 2. 멤버 변수의 값은 선언된 객체의 타입을 따른다.
 *      - Orange 에서 sweetness 는 10으로 정의되어 있으나
 *        Fruit 으로 참조하였으므로 aFruit.sweetness는 1의 값을 가진다.
 *
 * 3. 메소드 오버라이딩은 메모리상의 객체 타입을 따른다.
 *      - Fruit 클래스 타입으로 참조했으나, Orange 클래스에서의 구현을 따르고 있는 것 을 알 수 있다.
 *      - 즉, 메모리상에서는 여전히 Orange 클래스이므로 비슷한 사용에 관해 유의할 필요가 있다.
 *
 * 4. 공변 반환 타입으로서 오버라이드된 메소드는 부모 클래스 대신 자신과 같은 리턴 타입을 가질 수 있다.
 *      - getSelf() 가 Orange 를 리턴 타입으로 가진 채 오버라이드 된 것이 그 예시이다.
 */

class Fruit {
    int sweetness = 1;

    public Fruit getSelf() {
        return this;
    }

    public void makeJuice() {
        System.out.println("I don't know you man...");
    }
}

class Orange extends Fruit {
    int sweetness = 10;
    @Override
    public Orange getSelf() {
        return this;
    }

    public void makeJuice() {
        System.out.println("Holy Molly Guacamole!");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Fruit aFruit = new Orange();
        System.out.println(aFruit.sweetness);
        aFruit.makeJuice();
    }
}
