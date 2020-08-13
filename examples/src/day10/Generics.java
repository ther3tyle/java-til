package day10;


// Class
class Foo {

}

// Generic Class
class GenericFoo<T> { // T = Type Parameter
    String name;
    T memberVar;

    public GenericFoo(String name, T memberVar) {
        this.name = name;
        this.memberVar = memberVar;
    }
}

// Generic Interface
interface GenericInterface<T> {

}

// Generic Class with multiple Type Parameters
class MyMap<K, V> {

}

class GenericBar<T> {
    // static T classVar; 불가능
    // static void method(T var) {}; 불가능
    T memberVar;

    // memberVar = new T(); // new 키워드 사용 불가능 (안정성 문제 발생)
    void m2 (Object obj) {
        //if (obj instanceof T) {} // not possible >> instanceof not possible
    }
}


// 제네릭 타입의 상속
class GFoo<T> {

}

interface IGFoo<D> {

}

// Generic 으로 정의된 타입에 대해 부모 제네릭의 타입을 전달할 수 있다.
class IGIFooTwo<T> extends GFoo<T> implements IGFoo<T> {

}

class ITEM<T extends Number> {

}

// 타입 패러미터는 부모 제네릭의 타입 파라미터를 모두 채워 주어야 한다.
// 추가적인 타입 파라미터도 사용할 수 있다.
class GIGFoo<T, D> extends GFoo<T> implements IGFoo<D>{

}

// 여러개를 상속을 구현한 클래스를 원할 경우 아래처럼 표현할 수 있다.
class GenericTBD<T extends String & Cloneable> {

}

// 제네릭 메소드
class GenericMethod {
    public static <T> T staticMethod(T x) {
        return x;
    }
    public <T> T method(T x) {
        return x;
    }
}
class WildFoo {}
class WildBar extends WildFoo{}
class WildGeneric<T> {}
class WildCard{
    public void method1(WildGeneric<?> x) {}
    public void method1_eq(WildGeneric<? extends Object> x) {} // Just as default
    public void method2(WildGeneric<? extends WildFoo> x) {} // WildFoo, WildBar
    public void method3(WildGeneric<? super WildBar> x) {} // Object, WildFoo, WildBar
}




public class Generics {
    public static void main(String[] args) {
        GenericFoo<String> foo = new GenericFoo<>("foo", "var");
        GenericFoo<Integer> bar = new GenericFoo<>("bar", 1);

        printType(foo.name);
        printType(bar.memberVar);

        System.out.println(GenericMethod.staticMethod("hello"));
        GenericMethod gm = new GenericMethod();

        System.out.println(gm.method(123));
        System.out.println(gm.method("HELLO"));
    };


    private static <T> void printType(T t) {
        System.out.println(t.getClass().getSimpleName());
    }


}
