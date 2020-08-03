# day 4

### Array

> Size of the array won't change

> Values are stored in sequential manner

#### ZERO VALUES FOR ARRAY

Type  |Value|Comment                    |
------|-----|---------------------------|
byte  |0    |                           |
int   |0    |                           |
short |0    |                           |
long  |0    |                           |                   
bool  |false|                           |
chars |0    |Prints Nothing or ([])     |
float |0.0  |                           |
double|0.0  |                           |



#### Instance

> There are three distinct methods to instantiate an array
```java

public class Demo {
    // This will create new array with zero values (for integer = 0)
    int[] arr1 = new int[10];
   
    // This instantiates new array with length 3 w/ given values
    int[] arr2 = new int[]{1,2,3};
    
    // This also instantiates the same, length 3 w/ given values
    int[] arr3 = {1,2,3};
};
```

#### Clone

```java
public class Demo {   
    public static void main(String[] args){
        
        int[] src = new int[10];
        int[] dst = new int[15];
        
        System.arraycopy(src, 0, dst, 0, src.length);
        
        // OR
        // THIS WILL COPY NEW ARRAY
        int[] dst2 = src.clone();
    }
}
```

#### Example of append method
```java
public class Demo {
    private int[] append (int[] src, int item) {
        int[] dst = new int[src.length + 1];
        System.arraycopy(src, 0, dst, 0, src.length);
        dst[dst.length - 1] = item;
        return dst;
    }
}
```

### N-D Arrays

> Syntax is almost identical to any arrays

> Child arrays will not be restricted to have certain length unless specified

> Child arrays will also be instantiated with same zero values


```java
public class Demo {
    public static void main(String[] args){
        
        // this will have 3 of int[5]
        int[][] matrix = new int[3][5];
        
        // we do not need to specify child array size
        matrix = new int[3][];
        
        // we may do this as well
        matrix = new int[][]{};

        // we CANNOT do this
        // matrix = new int[][];
    }
}
```
