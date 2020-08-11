package day05;

/**
 * Variables
 *
 * Variables used in class
 *      - Class member variables (aka. Static variables, Class variables)
 *      - Instance member variable (aka. Member variable, Attribute ...)
 *      - Local variable
 *      - Local parameter variable (arguments)
 */
public class Variables {
    static int classVar; // class member variable; static variable
    int instanceVar; // class instance variable, field, attribute

    public void method(int paramVar) { // local parameter variable
        System.out.printf("paramVar: %d\n", paramVar);
        int localVar; // local variable
        // System.out.println(localVar) -> throws exception as it is NOT initialized!
        localVar = 10;
        System.out.printf("localVar: %d\n", localVar);
        {
            localVar = 30; // child block can access to a variable from an upper level
            int localVar2 = 20; // local variable
        }
        // System.out.println(localVar) =
        // localVar2  = 40; // cannot access; life cycle is done for localVar2 (in block)
    }
}

class VariableTest {
    public static void main(String[] args) {
        System.out.println("Class Variable");
        System.out.println(Variables.classVar); // zero value: 0
        Variables.classVar = 10; // class variable can be accessed via class name
        System.out.println(Variables.classVar);
        System.out.println();

        System.out.println("Instance Member Variable");
        Variables var = new Variables();
        System.out.println(var.instanceVar); // instanceVar can only be accessed via instance of THAT class.
        var.instanceVar = 20;
        System.out.println(var.instanceVar);

        Variables var2 = new Variables();
        System.out.printf("var2.instanceVar = %d\n", var2.instanceVar);
        System.out.printf("var2.classVar = %d\n", var2.classVar); // possible but not recommended

        System.out.println("\nLocal Variables");
        var.method(9);
    }
}
