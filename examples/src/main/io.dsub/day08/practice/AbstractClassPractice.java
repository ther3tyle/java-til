package main.io.dsub.day08.practice;

/**
 * Abstract Stack
 * -> Stack
 * push() :
 * pop() :
 * peek() :
 * isEmpty() :
 */

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

public class AbstractClassPractice {
    public static void main(String[] args) {
        AbstractStack stack = new ArrayStack(10);
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        for (int i = 0; i < 20; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
