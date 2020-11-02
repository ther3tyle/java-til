package main.io.dsub.day06.method;

public class Method {
    int value;

    public Method(int value) {
        this.value = value;
    }

    // This will not work as the parameter is "copied" into method block.
    public void passByValue(int param) {
        param = 10;
    }

    // This will work as the parameter maintains the reference of the instance.
    public void passByReference(Method m) {
        m.value = 10;
    }

    public static void classMethod() {
        System.out.println("classMethod called");
    }

    public static void main(String[] args) {
        Method method = new Method(100);
        method.passByValue(10);
        System.out.println(method.value);
        method.passByReference(method);
        System.out.println(method.value);

        method.classMethod(); // can be called from an instance, but is BAD
        Method.classMethod(); // this is safer approach
    }
}
