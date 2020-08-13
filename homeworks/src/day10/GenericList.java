package day10;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;

/**
 * List<T> 제네릭 인터페이스를 구현하여 ArrayList<T> 제네릭을 완성하시오.
 * <p>
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 * <p>
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 * <p>
 * ArrayList<T>는 Object []를 이용하여 List<T>를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List<T> {
    void append(T value);

    void prepend(T value);

    void insert(int index, T value);

    void remove(int index);

    T get(int index);

    int length();
}

class ArrayList<T> implements List<T> {
    int length;
    int capacity;
    int initialCapacity;
    T[] data;

    /**
     * CONSTRUCTORS
     */

    public ArrayList() {
        this(0);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException(String.format("%d is not a valid argument.\n", capacity));
        }
        this.initialCapacity = initialCapacity;
        this.capacity = initialCapacity;
        this.data = (T[])new Object[initialCapacity];
    }

    @Override
    public void append(T value) {
        this.insert(length, value);
    }

    @Override
    public void prepend(T value) {
        this.insert(0, value);
    }

    @Override
    public void insert(int index, T value) {
        if (index - 1 > this.length)
            index = this.length;

        if (index >= this.capacity || this.isFull()) {
            this.capacity *= 2;
            T[] dataCopy = (T[])new Object[this.capacity];
            System.arraycopy(this.data, 0, dataCopy, 0, this.data.length);
            this.data = dataCopy;
        }

        int cpLength = this.length - index;
        if (cpLength < 0) {
            cpLength = 0;
        }

        System.arraycopy(this.data, 0, this.data, 0, index);
        System.arraycopy(this.data, index, this.data, index + 1, cpLength);

        this.data[index] = value;
        this.length++;
    }

    @Override
    public void remove(int index) {
        if (index < 0) index = 0;
        if (index >= this.length) index = this.length - 1;
        System.arraycopy(this.data, 0, this.data, 0, index);
        System.arraycopy(this.data, index + 1, this.data, index, this.capacity - index - 1);
        this.length--;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.capacity) {
            throw new IndexOutOfBoundsException(String.format("index must be within range 0 - %d. request: %d.\n", this.capacity - 1, index));
        }
        return this.data[index];
    }

    @Override
    public int length() {
        return this.length;
    }

    private boolean isFull() {
        return this.length == this.capacity;
    }
}


public class GenericList {
    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.length(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        for (int i = 0; i < 20; i++) {
            list.append(i);
        }
        printList(list);

        list.remove(5);
        printList(list);

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        printList(list);

        list.insert(5, 100);
        printList(list);
    }
}
