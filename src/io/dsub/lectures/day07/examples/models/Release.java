package io.dsub.lectures.day07.examples.models;

public class Release extends BaseModel {
    public Release(String prodName) {
        super(prodName);
    }

    @Override
    public void printUUID() {
        System.out.println("Release hates to print UUID!");
    }
}
