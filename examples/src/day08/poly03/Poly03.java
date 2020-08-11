package day08.poly03;

/**
 * 공변 반환 타입 (Covariant return type)
 * 오버라이딩에 관해서는 정확히 둘이 같은 리턴 타입이 아니더라도, 충족되는 해당 클래스를 반환하는 메소드로 만들 수 있다.
 */

class Foo {
    public Object getInstance() {
        return this;
    }
}

class Bar extends Foo {
    @Override
    public Bar getInstance() { // 오버라이딩 이지만 리턴 타입이 달라질 수 있다.
        return this;
    }
}

public class Poly03 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        // 같은 주소를 말한다.
        System.out.printf("case A Loc: %s\tcase B Loc: %s\n",bar.getInstance().getInstance(), bar);
        System.out.println(bar.getInstance().getInstance() == bar);
    }
}
