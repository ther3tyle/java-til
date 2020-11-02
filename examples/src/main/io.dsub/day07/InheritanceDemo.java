package main.io.dsub.day07;

public class InheritanceDemo {
    public static void main(String[] args) {
        BaseModel model = new Release("OrangeBeam"); // Can be used as BaseModel.class as it is child class!
        doSomeThing(model); // Can also be used as method parameter since the class inherited from parent class.
                            // This adaptive fashion also applies to use case of abstract class and interface.
    }

    /**
     * Demo Method!
     * @param baseModel any model that extended BaseModel.class will be sufficient
     */
    private static void doSomeThing(BaseModel baseModel){
        baseModel.printUUID(); // will show overridden result of Release.class
    }
}
