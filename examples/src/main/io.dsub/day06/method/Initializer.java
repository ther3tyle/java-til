package io.dsub.day06.method;

public class Initializer {

    // works as...
    // TOP -> BOTTOM
    // STATIC -> INSTANCE

    static {
        System.out.println("first static initializr called");
    }

    {
        System.out.println("first instance initializer called");
    }

    static {
        System.out.println("second static initializer called");
    }

    {
        System.out.println("second instance initializer called");
    }

    public static void main(String[] args) {

        System.out.print("=".repeat(24));
        System.out.println("> class init");

        Initializer init1 = new Initializer();
        Initializer init2 = new Initializer();

        System.out.print("=".repeat(24));
        System.out.println("> instance init");

    }
}
