package day07;

public class Release extends BaseModel {
    public Release(String prodName) {
        super(prodName);
    }

    @Override
    public void printUUID() {
        System.out.println("Release hates to print UUID!");
    }
}
