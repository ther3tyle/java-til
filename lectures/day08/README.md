# Polymorphism

다형성 (Polymorphism) 이전 시간에 이어서!

- 오버로딩에 의한 다형성
- 오버라이딩에 의한 다형성 (= 상속에 의한 다형성)

다형성의 특징들

1. 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징
     - Orange 클래스로 생성된 아래의 객체는 부모 클래스 타입인 aFruit 에 의해 참조되고 있다.

2. 멤버 변수의 값은 선언된 객체의 타입을 따른다.
     - Orange 에서 sweetness 는 10으로 정의되어 있으나
       Fruit 으로 참조하였으므로 aFruit.sweetness는 1의 값을 가진다.

3. 메소드 오버라이딩은 메모리상의 객체 타입을 따른다.
     - Fruit 클래스 타입으로 참조했으나, Orange 클래스에서의 구현을 따르고 있는 것 을 알 수 있다.
     - 즉, 메모리상에서는 여전히 Orange 클래스이므로 비슷한 사용에 관해 유의할 필요가 있다.

4. 공변 반환 타입으로서 오버라이드된 메소드는 부모 클래스 대신 자신과 같은 리턴 타입을 가질 수 있다.
     - getSelf() 가 Orange 를 리턴 타입으로 가진 채 오버라이드 된 것이 그 예시이다.

```java
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
        System.out.println(aFruit.sweetness); // prints 1
        aFruit.makeJuice(); // prints Holy Molly Guacamole!
    }
}
```

# Abstract Class

##### KeyPoint
 - 추상 클래스 (Abstract Class)
 - 일부 메소드가 구현되지 않고 선언만 되어있는 클래스
    - 자식 클래스에서 이것을 반드시 구현하게끔 강제하는 것
    - 필요한 모든 클래스가 구현될 수 있도록 하여 안정성을 높임 
 - 개념보다도 실질적인 구현 예에 익숙해질 필요가 있음을 느꼈다.
    - 추상 클래스와 정의된 자식 클래스가 각각 무엇을 알고 있어야 하는지에 대한 구분점을 명확히 해야 더 깨끗한 코드를 작성할 수 있다.
    - 근본적으로 다루는 클래스의 원형이 어떤 목적을 수행하는지 잘 파악해야 한다.
    - 구체적인 구현에 대해서 만큼은 최대한 추상 클래스가 관여하지 않아야 한다.
    
Stack 이 가진 공통적인 특성을 생각하고 구현한 예시이다.
Stack 의 구현에 관해 추상 클래스는 깊게 관여하지 않았기 때문에 구현체의 코드는 더 깨끗한 상태로 유지되고 있음을 알 수 있다.

특히, ArrayStack 라고 할 떄, 배열에 관한 로직 이외에 잡다한 내용들은 구현체에 직접적인 언급이 없으므로 코드를 읽기에 더 간결한 것 을 알 수 있다.

```java
abstract class AbstractStack {
    protected int capacity;
    protected int top;

    public AbstractStack(int capacity) {
        this.capacity = capacity;
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public abstract void push(int value);
    public abstract int pop();
    public abstract int peek();
}

class ArrayStack extends AbstractStack {
    private int[] array;

    public ArrayStack(int capacity) {
        super(capacity);
        this.array = new int[capacity];
    }

    @Override
    public void push(int value) {
        if (top == capacity) {
            int[] newArray = new int[this.capacity * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.capacity);
            this.capacity *= 2;
            this.array = newArray;
        }
        array[top++] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) return -1;
        return array[--top];
    }

    @Override
    public int peek() {
        if (isEmpty()) return -1;
        return array[top - 1];
    }
}
```
