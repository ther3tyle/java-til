package main.io.dsub.day10;

public class WrapperClass {
    // AUTOBOXING
    Integer autoboxing = 10;

    // UNBOXING
    Integer add(Integer x, Integer y) {
        return x + y; // you cannot do this in normal classes
    }

    // THIS WILL ALSO WORK WITH WRAPPER CLASSES
    <T> void bypass(T t) {
        System.out.println(">> BYPASS " + t);

    }

    public static void main(String[] args) {
        int a = Integer.parseInt("1"); // ANOTHER UNBOXING EXAMPLE
    }
}
