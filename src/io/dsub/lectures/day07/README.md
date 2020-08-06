# Inheritance (상속)

#### KEYPOINT
>어떤 클래스의 모든 멤버 변수 및 메소드를 계승하여 새로운 클래스를 생성하는 것
>
>상속 관계는 흔히 'IS-A' 관계라고 부른다.

##### 상속대상
조상 클래스, 부모 클래스, 상위 클래스, 슈퍼클래스

##### 피상속대상
자손 클래스, 자식 클래스, 하위 클래스, 서브클래스



##### 클래스 상속의 예
```java
class Person {
String name;
    public void work() {
        System.out.println("일하기");    
    }    
    public void sleep() {
        System.out.println("잠자기");
    }
}

class Developer extends Person {        
    String mainLang;
    public void writeCode() {
        System.out.println("돈 받은 만큼만 코딩하기");
    }
}

class Student extends Person {
    String major;
    public void writeCode() {
        System.out.println("밤새 코딩하기");        
    }
}

public class Main {
    public static void main(String[] args){
        Developer dev = new Developer(); // Developer 는 Person 이다 ('IS-A')    
        dev.name = "나개발";
        System.out.println(dev.name);
        dev.work();
        dev.sleep();
        dev.mainLang = "Java";    
        
        Student student = new Student(); // Developer 는 Person 이다 ('IS-A')
        System.out.println(student.major);
        student.sleep();
        student.writeCode();
    }
}
```

# Class Composition
> 클래스의 포함 관계를 의미한다. 기능적인 부분에 대해 상속과 유사하지만,
> 한 클래스가 다른 클래스의 객체를 포함하는 것 이므로
> 내부에 포함한다는 의미에서 'HAS-A' 관계로 표현된다.

##### 클래스 포함의 예시
```java
// An instance of Machine 'HAS-A' String instance.
class MainMachine {
    String model;
    boolean isBroken = false;
    public MainMachine(String model) {
        this.model = model;
    }
}

// An instance of Developer 'HAS-A' MainMachine instance.
class Developer {
    String name;
    MainMachine mainMachine;
    public Developer(MainMachine mainMachine) {
        this.mainMachine = mainMachine;        
    }         

    public void writeCode() {
        if (mainMachine.isBroken) {
            System.out.println("코딩을 할 수 없습니다");
        } else {
            System.out.println(mainMachine.model + "(으)로 코딩하기");
        }
        if (Math.random() > 0.9) {
            breakMachine();
        }
    }
    public void breakMachine() {
        mainMachine.isBroken = true;           
    }    
}

public class Main {
    public static void main(String[] args){
        MainMachine mac = new MainMachine("Macbook Pro");
        Developer dev = new Developer("너개발", mac);
        for (int i = 0; i < 10; i++) {
            dev.writeCode();
        }
    }
}
```

#Method Overriding (메소드의 재정의)
####KEYPOINT
> 다형성(Polymorphism)의 근간이 된다.

```java
class Person {
    public void writeCode() {
        System.out.println("아무 코드나 일단 적어 보았다.");
    }    
}

class Student extends Person {
    @Override // 이렇게 적어 주는 것이 관례이며 작성하지 않더라도 문법상의 오류는 아니다.
    public void writeCode() {
        System.out.println("능숙하게 코드를 작성해 보았다. 답은 틀렸다. 하지만 무언가 또 배웠다.");
    }
    public void sleep() {
        System.out.println("잘 잤다.");        
    }        
}

class Developer {
    @Override
    public void writeCode() {
        System.out.println("개발자는 귀찮아서 코딩을 하지 않았다.");                
    }    
}

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        student.writeCode(); // prints 능숙하게 코드를...

        Person person = new Person();
        person.writeCode(); // prints 아무 코드나 일단...
    
        Developer developer = new Developer();
        developer.writeCode(); // 능숙하게 코드를 작성...

        // 다형성(Polymorphism)의 구현        
        // 부모 클래스는 자료형으로 자식 클래스를 받을 수 있다.    
        Person p = (Person)dev; // 개발자를 사람으로 Casting 했다.
        p.writeCode(); // 부모 클래스 자료형이지만 오버라이드된 메소드가 동작한다.
        p = (Person) student;
        p.writeCode(); // prints 능숙하게 코드를...
        // p.sleep(); 부모 클래스는 sleep 메소드를 알지 못하므로 사용 할 수 없다.        
    }
}
```

# super keyword
> this 가 자기 자신의 객체를 참조하듯, super는 부모 객체를 참조한다.
> super.super 등 부모의 부모는 참조할 수 없다.

```java
class Foo {
    String x = "Foo";
    public Foo(String x) {
        this.x = x;            
    }    
}

class Bar extends Foo {
    String x = "Bar";
 
    // 부모 클래스에 기본 생성자를 사용하지 않는 경우 반드시 필요하다.
    public Bar(String x, String x1) {
        super(x); // this() 의 경우와 마찬가지로 반드시 가장 먼저 접근해야 한다.
        this.x = x1;            
    }

    public void method() {
        String x = "method"; // 멤버 변수명이 곂치면 재정의
        System.out.println(x); // prints method
        
        // 자기 자신의 객체에 접근            
        System.out.println(this.x); // prints Bar

        // 부모 객체에 접근
        System.out.println(super.x); // prints Foo
    }   
}
```
##### KEYPOINT
> 로컬 - 멤버 - 부모 변수 순으로 접근된다.
>
> 자식 객체를 생성하면 부모 객체를 먼저 생성한 후에 자식 객체가 생성된다.

# Packages and Imports
### Package
- Java에서 소스코드를 관리하는 방식
- 물리적 디렉토리 구분을 통해 계층적으로 구분한다.

#### Package naming convention
package 소속.프로젝트.용도

ex)

        package com.google.dev.utils

### Imports
> 다른 패키지에 선언된 패키지를 사용하기 위한 키워드

패키지에 속한 모든 패키지를 임포트 한다 (하위 패키지는 임포트 하지 않는다) [X] 권장되지 않음

        import com.example.project.utils.*; // 권장되지 않는다.

패키지에 속한 특정 클래스를 임포트 한다
        
        import java.io.InputStream;
        
같은 이름의 클래스가 사용되는 경우 패키지 명을 포함하여 사용한다
```java
import java.util.List;
        
public class Foo {
    public static void main(String[] args){
        List list = new List();
        java.awt.List list2 = new java.awt.List();        
    }    
}
```

static 멤버는 static import 하여 클래스를 생략하고 사용 가능하다 [X] 권장되지 않음

```java
import static java.lang.Math.random;
import static java.lang.System.out;

public class StaticImport {
    public static void main(String[] args){
        out.println(random());
    }    
}
```


# Modifier (제어자)
### 제어자란
- 클래스, 변수, 메소드에 부가 기능을 부여햐는 키워드
- 접근 제어자 (Access Modifier)
    - 접근할 수 있는 범위를 정하는 키워드
    - public, private, package, protected...
- 그 외 제어자 (Other modifiers)
    - 특별한 기능을 부여하는 제어자
    - static, final, abstract, synchronized
    
접근 가능한 범위를 정해 데이너 은닉/보호 (Encapsulation) 기능을 추가한다.

### Access Modifier (접근 제어자)
##### 접근 제어자별 접근 범위
제어자      | 같은 클래스 | 같은 패키지 | 다른 패키지에 속한 자식 클래스 | 전체
------|-----|-----------------|--------------------|-------------
public|O|O|O|O
protected |O|O|O|X
package   |O|O|X|X
private   |O|X|X|X

##### KEYPOINT

1. protected 는 상속받은 객체가 접근 할 수 있다는 점에 유의하자 (같은 패키지에서도 접근 됨에 주의)

2. protected 는 private 처럼 사용하지만 상속한 경우 접근이 필요할 때에 사용한다.

3. private 은 클래스의 내부 구현에 사용한다.
 
4. 일반적으로는 private 혹은 public 을 사용한다.

5. class 는 public, package 만 사용 가능하다.


# Extra
모든 클래스는 기본으로 Object 클래스를 상속받는다. 예를 들어 equals 와 같은 메서드는 모두 상속받아 사용하는 것.
```java
class Hell extends Object {private String hello = "hello";}

```
