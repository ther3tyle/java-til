# Method
##### 메소드란?

>객체가 하는 동작(행위)을 정의하는 작업을 수행하는 코드의 집합, 나열
>
>코드의 중복을 방지, 유지보수성을 향상, 코드의 가독성을 향상

```java
class Foo {
    int value;
}
class Bar {
    // Instance Method, Method
    // int = Return Type (출력의 자료형)
    public int add(int x, int y /* Method Params */) {
        return x + y; // Return Value (반환값)
    }
    
    // 선언(Declaration): ~ 한 것 이 있다 (실질적인 구현 X)
    // 정의(Definition): 선언 + 구현(초기화) 
    // 따라서 구현이 되어있다면 정의가 되어있다.
   
    // Static Method, Class Method
    public static void classMethod() { // void means no return value
        System.out.println("클래스 메소드 호출");
        // return; is redundant
    }   
}
```
##### KEYPOINT
> Declaration: 구현되지 않은 '것'에 대한 선언 ( i.e. int x; )
>
> Definition:  선언되었고 구현된 (혹은 초기화 된) 것 ( i.e. int y = 10; )

선언된 메소드는 구현되어있어야 할 의무가 없다. 메소드의 정의는 정의된 메소드라는 다른 말로 빗대어 볼 때
완성된 메소드의 개념으로 생각해볼 수 있다. 따라서, 구현이 되었다는 관념은 정의된 메소드에 부합한다.

Class Method와 Instance Method는 Class, Instance Variable과 같이 클래스, 
혹은 인스턴스 각각에 맞는 접근 방식이 권고된다.

아래는 더 자세한 코드 예시이다.
```java
public class Person {
    static String korWord = "사람"; // Class member variable (static member variable)
    boolean isHungry = true; // Instance member variable
    
    // Class method
    public static void describe() {
        // You cannot use instance variable here
        // Use static variable instead as below!
        System.out.println(korWord + "입니다.");
    }   
    
    // Instance method
    public void eat() {
        this.isHungry = false;
    }   
}

public class Methods {
    public static void classMethod() {
        System.out.println("Called class method");
    }
    
    public void instanceMethod() {
        System.out.println("Called instance method");
    }   

    public static void main(String[] args){
        Bar.classMethod();
        Bar bar = new Bar();
        System.out.println(bar.add(1, 2)); // prints 3
        
        // bar.classMethod(); // is NOT recommended
        
        // Person = Variable Type of Class Person
        // p1 = variable name
        // new Person(); = new Class Instance!
        Person p1 = new Person();
        Person p2 = new Person();
        
        p1.eat(); // an instance of Person class(p1) called eat method
        System.out.println(p1.isHungry); // prints false
        System.out.println(p2.isHungry); // prints true

        Person.describe(); // prints 사람입니다.
    
        classMethod(); // call class method within same class;
        Methods.classMethod(); // can also call with its class
        Methods m = new Methods();
        m.instanceMethod(); // instance method
    }
}
```
위와 같이, 인스턴스 메소드는 대부분 객체의 속성을 변화시키는 케이스가 많다. 반면, 클래스 메소드는
인스턴스와는 별개의 메소드로서 각 인스턴스의 속성과는 관련이 없다.

### Call By Value, Call By Reference
##### KEYPOINT
> Value: 메서드 블럭에 '값'이 복사되어 들어가게 된다 (Primitive)
> 
> Reference: 참조값이 복사되어 들어가므로 같은 참조를 하게 된다
>

```java
public class Methods {
    
    // Call By Value
    public static void swapPrimitive(int x, int y) {
        // int x, y are primitive type. Hence values are 
        // copied then tossed into this block.
        //
        // There is no relationship between these x, y and their caller
        int tmp = x;
        x = y;
        y = tmp;
    }
    
    public static void swapReference(Foo x, Foo y) {
        // Foo -> class, class = reference type variable
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }
    
    
    public static int sumAll(int... params /* multiple params -> as an array */) {
        int sum = 0;
        for (int i : params) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        swapPrimitive(x, y);
        System.out.println(x + ", " + y); // prints 10, 20

        int tmp = x;
        x = y;
        y = x;
        System.out.println(x + ", " + y); // prints 20, 10
    
        Foo f1 = new Foo();
        Foo f2 = new Foo();
        
        f1.value = 10;
        f2.value = 20;
        swapRefenrence(f1, f2);
        System.out.println(f1.value + ", " + f2.value); // prints 20, 10
        
        System.out.println(sumAll(2,5,2,10,6,-2)); // prints 23
    }
}
```
### Method Overloading

##### KEYPOINT
>같은 이름을 가질 것

>아래는 모두 오버로딩 가능하다 
>1. Return type
>2. Parameter type
>3. Parameter count
>4. Logic to handle parameter

```java
public class Demo {
    public static int sumAll(int... params) { // variadic args, variable arg.
        int sum = 0;
        for (int value : params) {
            sum += value;
        }
        return sum;
    }
    
    // Method Overloading
    // Same name, different input parameter type
    // May even have different count of parameters
    public static float sumAll(float... params) {
            float sum = 0;
            for (float value : params) {
                sum += value;
            }
            return sum;
    }

    public static void main(String[] args){
        System.out.println(sumAll(2,5,2,10,6,-2)); // prints 23
        System.out.println(sumAll(2.2f,0.2f, 0.2f)); // prints 2.600001
    }
}
```
### Constructor

#### 생성자의 종류
> 기본 생성자(Default constructor)

기본 생성자는 별도로 생성할 필요가 없지만, 개별적으로 생성자를 만든 경우에는 제공되지 않는다. 

> 비어있는 생성자(Empty Constructor)

원할 경우 패러미터가 없는 생성자를 만들고 로직을 구현할 수 있다.

> 패머리터 생성자(Parameterized Constructor)

패러미터가 존재하는 생성자

---
##### KEYPOINT
1. 생성자도 오버로딩할 수 있다.
2. 기본 생성자는 항상 비어있으며, 별도의 생성자를 만들 경우 제공되지 않는다.
3. 생성자에는 리턴 타입이 존재하지 않으며 적지도 않는다.



```java
public class Constructor {
    int x;
    int y;
    String z;
    // public Constructor() {} // 기본 생성자로, 구현하지 않아도 알아서 생긴다.
    public Constructor() {
        this(10, 0, "");
    }
    
/* 
*   Used in singleton pattern
    private Constructor() {...}
*/

    // parameterized constructor
    public Constructor(String s) {
        this.x = 1; 
        this.y = 2;
        this.z = s;
    }
    public Constructor(int x, int y, String z) {
        this.x = x; // this.x points to instance(member) variable x of this class
        this.y = y;
        this.z = z;
    }   
    public Constructor(int x, int y) {
        this(a, b, ""); // MUST, ALWAYS placed on first line, ONLY ONCE.
    } 
}

class ConstructorTest {
    public static void main(String[] args){
        Constructor c = new Constructor();
        System.out.println(c.x + ", " + c.y + ", " + c.z); // prints 10,0,
        // String is a class, hence initialized as null;
        // null -> no reference
        c = new Constructor("Hello World");   
        System.out.println(c.x + ", " + c.y + ", " + c.z); // prints 1, 2, Hello World
        
        c = new Constructor(10, 20);
        System.out.println(c.x + ", " + c.y + ", " + c.z); // prints 10, 20, 

    }
}
```

### Getter and Setter

Getter, Setter
멤버 변수를 간접적으로 다룰 수 있게 해주는 메소드
멤버 변수의 캡슐화(Encapsulation)에 도움이 됨
        -> 정보의 은닉/보호
        
멤버 변수의 값을 제한해야 할 때 유용
```java
public class MyClass {

    // instance variables
    int x, y;
    String z;
    float w;
    
    // constructor -> default constructor is gone
    public MyClass(int x, int y, String z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public MyClass() {}   
    
    // getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x > 0 && x <= 1000) {
            this.x = x;
        } else {
            System.out.println("x should be 1 <= x <= 1000 >> input was " + x);   
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}

class MainTest {
    public static void main(String[] args){
        Main m = new Main();
        
        // 권장되지 않는 방식
        m.x = 10;
        System.out.println(m.x);
    
        // 권장되는 방식 (Getter, Setter)
        m.setX(20);
        System.out.println(m.getX());
        
        m.setX(200000000);
        System.out.println(m.getX());
    }
}
```

### Initializer Block
##### 초기화블록

---

##### KEYPOINT
1. Static Initializer 는 객체화와 관계 없이 반드시 실행된다.
2. Initializer 는 클래스가 객체화 될 때 마다 해당 객체에 대해 실행된다.
3. 두 Initializer 는 위에서 아래로 실행된다.
4. 두 Initializer 는 존재하는 갯수 만큼 실행된다.

 
```java
public class Main {
    static int classVar;
    int instanceVar;
    
    // static initializer -> 정적 초기화 블록
    static {
        System.out.println("static initializer block 1");
        classVar = 20;
    }
    // initializer -> for instantiation
    {
        System.out.println("initializer block");
        instanceVar = 30;
        classVar = 50;
    }
}

class MainTest {
    public static void main(String[] args){
        System.out.println(Main.classVar);
        Main main = new Main();
        System.out.println(main.instanceVar);
        System.out.println(Main.classVar);
    }
}

```
