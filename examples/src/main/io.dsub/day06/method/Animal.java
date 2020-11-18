package io.dsub.day06.method;

/**
 * Example for getter and setter, access modifier (private)
 *
 * isHungry can only be modified by eat method
 * (but not eat() as it refers to the return value of the method)
 *
 * Hence, isHungry field is somewhat protected.
 */
public class Animal {
    private boolean isHungry;

    public Animal() {
        this.isHungry = true;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void eat() {
        this.isHungry = false;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("is animal hungry? " + animal.isHungry);
        animal.eat();
        System.out.println("is animal hungry? " + animal.isHungry);
    }
}

