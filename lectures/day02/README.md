#### day 2

- Type Casting

    - Up Casting
        - Automatic, Preserves its value
    - Down Casting
        - Manual, Careful with the sign bit ( usage of >>> )

- Precision in Floating Number
```java
(6 - 5.9) * 10; 
// the precision matters, as for double it is natural NOT to resulting 1.0
// for monetary calculation or if you need extra precision, use BigDecimal.class
```

- PrintFormat
    - System.out.printf();
    - Check TypePrinter.print();
