package io.dsub.lectures.day05;

/**
 * Class - Blueprint for an object instantiation
 * Object - instance of a Class, an instance of a Class
 */

class Car {         //  use Pascal Case in general
    int speed = 0;  //  Member variable, Attribute, Field -> dictated by context

    void move() {   //  Method (a member func)
        speed = 10; //  Implementation of an action that affects attribute(s)
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Car carOne = new Car(); // An instantiation with new keyword; used auto-generated constructor
        System.out.printf("carOne.speed: %d\n", carOne.speed); // Access an attribute by dot notation
        carOne.move(); // Method call
        System.out.printf("carOne.move();\ncarOne.speed: %d\n", carOne.speed);

        Car carTwo = new Car(); // Another instantiation of a class Car
        System.out.printf("carTwo.speed: %d\n", carTwo.speed); //

        Car carThree = carOne; // variable carThree references same instance from carOne
        System.out.printf("Car carThree = carOne;\ncarThree.speed:%d\n", carThree.speed);
        carThree.speed = 5;
        System.out.printf("carThree.speed = 5\ncarOne.speed: %d\n", carOne.speed);
    }
}
