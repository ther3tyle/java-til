# 제네릭 (Generics)
- 대상 객체의 타입을 입력받아서 사용하는 형식
- 미리 사용할 수 있는 타입을 명시해서 컴파일 타임에 체크 가능
    - 입력을 Object로 할 수도 있으나, 런타임에 instanceof 로 객체를 체크해야 함
    - 제네릭을 사용할 경우 이러한 과정 없이 간결하게 코드 작성을 할 수 있다.
    
### 제네릭 클래스 (Generic Class)
- 정해지지 않은 특정 클래스를 사용하기 위함
- 객체에 대해 정의하는 것 이므로, 정적인 사용은 불가능하다.

```
class MyClass<T> {} //여기서 T는 T extends Object 와 다르지 않다. 
```

#### 안정성 문제로 사용에 제고가 필요한 키워드들

> 문법상에는 오류가 없지만, 사용할 경우 문제의 소지가 있어 문법상 막아놓은 것들에 해당한다.
1. new
2. instanceof

#### 사용하고자 하는 타입에 대한 명시

A와 B를 상속받은 Type T를 정의한다고 가정할 경우 아래와 같이 명시한다.
```
<T extends A & B>
<T extends String & Cloneable>
```

### 제네릭 메서드 (Generic Method)
- 제네릭 메서드와 제네릭 클래스는 별도로 생각해야 한다. 물론, 런타임에 결정되는 동적 바인딩에 해당되기는 하다.
- 타입을 정하기 않고, 광범위하게 사용된다는 점은 동일하며, 타입 제한을 통해 더 안정적으로 코드를 작성할 수 있다.
```
public static <T> T staticMethod(T x) {
    return x;
}
public <T> T method(T x) {
    return x;
}
```

### 와일드카드(KEYWORD "?")

와일드카드(?)는 메소드 입력 타입에 제네릭이 쓰일 경우, 제네릭의 타입 변수의 범위를 제한할 수 있다.
```java
class WildFoo {}
class WildBar extends WildFoo{}
class WildGeneric<T> {}
class WildCard{
    method1_eq(WildGeneric<? extends Object> x) {} // Just as default
    method2(WildGeneric<? extends WildFoo> x) {} // WildFoo, WildBar
    method3(WildGeneric<? super WildBar> x) {} // Object, WildFoo, WildBar
}
```

# Wrapper Class
- 기본형 타입을 객체로 쓰기 위해 있는 클래스
- 기본형 타입이 허용되지 않는 문법에 기본형 타입을 쓰기 위해서 제공

TYPE | CLASS
---- | ----
byte | Byte
char | Character
short| Short
int  | Integer
long | Long
float | Float
double | Double
boolean | Boolean

### Auto-Boxing / Unboxing
- 자동으로 Wrapping 해주거나, Unwrap 하는 시리즈를 이야기한다.
```java
class Demo {
    // AUTOBOXING
    Integer autoboxing = 10;
    
    // UNBOXING
    Integer add (Integer x, Integer y) {
        return x + y; // you cannot do this in normal classes
    }

    // THIS WILL ALSO WORK WITH WRAPPER CLASSES
    <T> void bypass(T t) {
        System.out.println(">> BYPASS " + t);
    }
}
```

> 사칙 연산이 가능한 클래스를 작성할 수 없는 이유

ans: C++ 에서는 정적 메소드에 대한 오버라이드가 가능하지만, 자바에서는 의도적으로 고슬링이 그 가능성에 대해 배제했고, 따라서 같은 방식으로 새롭게 구현해내는 것 은 아주 번거롭고 좋지 못한 작업에 해당한다. 굳이 하고 싶다면 javac 를 살펴보면 된다.

