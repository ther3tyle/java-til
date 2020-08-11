# 인터페이스(Interface)

- 클래스가 사용되는 방식 / 접점만을 선언하는 클래스와 유사한 틀
- 아무런 구현이 되어 있지 않으며, 모든 메소드가 추상 메소드

### 인터페이스의 특징
- class 가 아닌 interface 키워드를 사용
- 멤버 변수는 항상 public static final 이며 생략 가능하다.
- 멤버 메소드는 항상 public abstract 이며 생략 가능하다.
- 클래스는 하나만 상속할 수 있으나, 인터페이스는 여러개를 상속받을 수 있다.
- public, default 이 사용 가능하다.
- extends 키워드가 아닌 implements 키워드를 사용한다.

### Naming Convention
- interface IFoo <- class Foo
- interface printable <- class Bar(or any)


### Inheritance Between Interfaces
- 인터페이스로 인터페이스를 상속할 경우에는 extends 키워드를 사용한다.
- 클래스 <- 클래스 상속과 달리 다중 상속이 가능하다.


# 열거형(Enumeration)

- enum 키워드로 사용
- 내부적인 구현은 enum -> java.lang.Enum 클래스를 상속
- enum은 다른 클래스를 상속하지 않음
- 열거형은 다른 클래스를 상속하지 못하지만 인터페이스 구현은 가능하다.
- 열거형 타입에는 열거형 상수와 null 값 할당 가능
- 열거형 상수는 객체이다
- 열거형 상수는 객체이기 때문에 메소드 사용이 가능하다.
- 열거형 상수의 생성자는 private 이며 enum 내에서 객체로 생성된다.
