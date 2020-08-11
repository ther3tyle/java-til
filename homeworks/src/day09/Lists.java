package day09;

import java.util.Arrays;

/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
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
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    public void append(int value);

    public void prepend(int value);

    public void insert(int index, int value);

    public void remove(int index);

    public int get(int index);

    public void length();
}

class IntArrayList implements List {

    private int capacity;
    private int length;
    private int[] data;

    public IntArrayList(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.length = 0;
    }

    @Override
    public void append(int value) {
        this.insert(length, value);
    }

    @Override
    public void prepend(int value) {
        this.insert(0, value);
    }

    @Override
    public void insert(int index, int value) {

        if (this.isFull()) this.capacity *= 2;

        while (index >= this.capacity) {
            this.capacity *= 2;
        }

        int[] dataCopy = new int[this.capacity];

        if (index == 0)
            System.arraycopy(this.data, 0, dataCopy, 1, this.length);
        else if (index >= this.data.length - 1) {
            System.arraycopy(this.data, 0, dataCopy, 0, this.length);
        } else {
            System.arraycopy(this.data, 0, dataCopy, 0, index);
            System.arraycopy(this.data, index, dataCopy, index, this.data.length - index);
        }

        dataCopy[index] = value;
        this.data = dataCopy;
        this.length++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.length) return;

        int[] dataCopy = new int[this.capacity];

        System.arraycopy(this.data, 0, dataCopy, 0, index);
        System.arraycopy(this.data, index + 1, dataCopy, index, this.capacity - index - 1);

        this.data = dataCopy;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= this.capacity) {
            return -1;
        }
        return this.data[index];
    }

    @Override
    public void length() {
        System.out.printf("current length: %d\n", this.length);
    }

    private boolean isFull() {
        return this.length == this.capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}
