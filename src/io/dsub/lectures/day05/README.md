# 객체 지향 프로그래밍 (Object Oriented Programming; OOP)
## 객체 지향 프로그래밍이란

- 컴퓨터 프로그래밍 패러다임 중 하나
- 프로그램을 명령어의 목록으로 보는 시각(절차 지향)에서 벗어나, 독립된 단위인 객체의 모임으로 파악
- 각각의 객체는 메세지를 주고 받고 데이터를 처리 (협력)

## 객체 지향의 기본 구성 요소
- 클래스(Class)
    - 같은 종류의 집단에 속하는 속성과 행위를 정의한 것
        - 같은 종류의 집단: 같은 클래스에 속하는 여러 청사진들이 존재할 수 있음
        - 속성: 클래스에 속한 데이터 (혹은 상태)
        - 행위: 속성을 다루는 행위 또는 방식 (메소드를 통해 정의)
    - 클래스는 다른 클래스 또는 외부 요소와 독립적으로 디자인해야 함
- 객체(Object)
    - 클래스의 인스턴스로 실제로 메모리상에 할당된 것
    - 자신 공유의 속성을 가지며 클래스에 정의된 행위를 수행 
    > 실체이기 때문에 실질적인 행위를 수행할 수 있다고 보는 것
- 메소드(Method)
    - 클래스로부터 생성된 객체를 사용하는 방법
    - 메소드는 한 객체의 속성을 조작하는 데에 사용

## 객체 지향의 특징
- OOP is A.P.I.E
    - Abstraction(추상화): 자료 표현을 추상적으로 나타ㅐ는 추상 자료형을 사용한다.
    - Polymorphism(다형성): 오버로딩과 오버라이딩을 하여 하나의 메소드명으로 다양한 동작을 구현할 수 있다.
    - Inheritance(상속): 부모 클래스로부터 속성과 메소드를 상속받아 사용할 수 있다.
    - Encapsulation(캡슐화): 사용자에게 불필요한 정보를 은닉/보호해야 한다. 

---
# OOP Examples

## Instantiation of a class
```java
/**
 * Class - Blueprint for an object instantiation
 * Object - instance of a Class, an instance of a Class
 */

class Car {         //  use Pascal Case in general
    int speed = 0;  //  Member variable, Attribute, Field -> dictated by context

    void move() {   //  Method (a member func)
        speed = 10; //  Implementation of an action that affects attribute(s)
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Car carOne = new Car(); // An instantiation with new keyword; used auto-generated constructor
        System.out.printf("carOne.speed: %d\n", carOne.speed); // Access an attribute by dot notation
        carOne.move(); // Method call
        System.out.printf("carOne.move();\ncarOne.speed: %d\n", carOne.speed);

        Car carTwo = new Car(); // Another instantiation of a class Car
        System.out.printf("carTwo.speed: %d\n", carTwo.speed); //

        Car carThree = carOne; // variable carThree references same instance from carOne
        System.out.printf("Car carThree = carOne;\ncarThree.speed:%d\n", carThree.speed);
        carThree.speed = 5;
        System.out.printf("carThree.speed = 5\ncarOne.speed: %d\n", carOne.speed);
    }
}
```
## Memory structure
```java
/**
 * Class and Instance Memory Structure
 * - Class Area (a.k.a. method area, code area, static area)
 *      - field, method, type information AND constant pool
 * - Stack Area
 *      - local variables within method call (temporary)
 * - Heap area
 *      - object instantiation with new keyword
 *      - this is where the garbage collection(GC) works
 *        >> JVM automatically handles the unused memory assignments
 */

public class MemoryStructure { // Class Area
    
    int x, y; // Heap Area
    String string = "String!"; // Heap Area ("String!" will be generated in constant pool)

    public void method(int value) { // Class Area
        char c = 'w'; // Stack Area
    }
}
```

## Variables of a Class
```java
/**
 * Variables
 *
 * Variables used in class
 *      - Class member variables (aka. Static variables, Class variables)
 *      - Instance member variable (aka. Member variable, Attribute ...)
 *      - Local variable
 *      - Local parameter variable (arguments)
 */
public class Variables {
    static int classVar; // class member variable; static variable
    int instanceVar; // class instance variable, field, attribute

    public void method(int paramVar) { // local parameter variable
        System.out.printf("paramVar: %d\n", paramVar);
        int localVar; // local variable
        // System.out.println(localVar) -> throws exception as it is NOT initialized!
        localVar = 10;
        System.out.printf("localVar: %d\n", localVar);
        {
            localVar = 30; // child block can access to a variable from an upper level
            int localVar2 = 20; // local variable
        }
        // System.out.println(localVar) =
        // localVar2  = 40; // cannot access; life cycle is done for localVar2 (in block)
    }
}
```
## Zero Values of Instance Variables
