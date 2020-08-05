package io.dsub.lectures.day06;

public class InitializerDemo {
    static int classVar;
    static int instanceCount;
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
        classVar = 50; // 추천되지 않는다
        instanceCount++;
    }

    static {
        System.out.println("static initializer block 2");
        classVar = 5;
    }

    {
        System.out.println("initializer block 2");
        instanceVar = 5;
    }
}

class MainTest {
    public static void main(String[] args) {
        System.out.println(InitializerDemo.classVar);
        InitializerDemo init = new InitializerDemo();
        System.out.printf("instanceCount: %d\n", InitializerDemo.instanceCount);
        System.out.println(init.instanceVar);
        System.out.println(InitializerDemo.classVar);
        InitializerDemo[] initArr = new InitializerDemo[10];
        for (InitializerDemo d : initArr)
            d = new InitializerDemo();
        System.out.printf("instanceCount: %d\n", InitializerDemo.instanceCount);
    }
}

