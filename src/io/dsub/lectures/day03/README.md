# day 3

### Short Circuit Gotcha
As (x++ > 0) is false, the (y++) will not be operated; hence 1, 0.

Mean of Short Circuit: Reduce the Process; may lead to wrong direction.
```java
public class Main {
    public static void main(String[] args){
        int x = 0;
        int y = 0;
        System.out.println(x++ > 0 & y++ > 0);
        System.out.println(x + ", " + y); // 1, 1 

        // Short Circuit
        int x = 0;
        int y = 0;
        System.out.println(x++ > 0 && y++ > 0);
        System.out.println(x + ", " + y); // 1, 0
    }
}
```

### Switch Statement Gotcha
default runs from the last no matter where you put it!
```java
public class Main {
    public static void main(String[] args){
        int x = 10;
        switch (x) { // will print "hello world"
            default:
                System.out.println("World");
            case 10:
                System.out.print("Hello ");
        }
    }
}
```

### About Do While Iteration
do{}while() operates once at least, even if the condition is not met.
```java
public class Main {
    public static void main(String[] args){
        do {
            System.out.println("hello world"); // will print
        } while(false);
    }
}
```

### Labeling on a loop
You can specify which loop to skip or break from INNER loop.

```java
public class Main {
    public static void main(String[] args){
        outer: //labeled as outer loop
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == i && j == 3) {
                    continue outer; // will skip from outer loop
                }
            }
        }
    }
}
```

