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
- 인터페이스가 구현한 클래스 메서드는 상속받은 자식이 사용할 수 없다.


### Naming Convention

- interface IFoo <- class Foo
- interface printable <- class Bar(or any)


### Inheritance Between Interfaces

- 인터페이스로 인터페이스를 상속할 경우에는 extends 키워드를 사용한다.
- 클래스 <- 클래스 상속과 달리 다중 상속이 가능하다.


### Interfaces after JDK 1.8

- 인터페이스에는 default 메서드를 구현할 수 있다.
    - default 메서드는 항상 public 이다.
    - 인터페이스의 철학과 맞지 않으나 기존에 사용하던 인터페이스가 개선되어 모든 자식 메소드에 동일하게 구현되어야 하는 경우 쉽게 기능을 추가할 수 있도록 하기 위해 만들어졌다.


### Interface vs Abstract in Inheritance

- 부모와 인터페이스 양쪽이 같은 메서드를 구현하고 있는 경우 부모의 메서드를 실행하게 된다.
- 기존의 인터페이스는 구현된 메서드를 가지고 있지 않았으므로 다중 상속에 문제가 없었다. 
하지만 public abstract 가 아닌 default 메서드가 생기면서 이 규칙에 문제가 발생했다고 볼 수 있다. 
이 때, 다중 상속 시 문제를 방지하기 위해, 인터페이스보다 일반 상속이 우선시된다. 


# 열거형(Enumeration)

- enum 키워드로 사용
- 내부적인 구현은 enum -> java.lang.Enum 클래스를 상속
- enum 은 다른 클래스를 상속하지 않음
- 열거형은 다른 클래스를 상속하지 못하지만 인터페이스 구현은 가능하다.
- 열거형 타입에는 열거형 상수와 null 값 할당 가능
- 열거형 상수는 객체이다
- 열거형 상수는 객체이기 때문에 메소드 사용이 가능하다.
- 열거형 상수의 생성자는 private 이며 enum 내에서 객체로 생성된다.
