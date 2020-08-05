package io.dsub.homework.day06;

/**
 * A Class pretends to be something genuine; NOT So!
 * @author ther3tyle
 * @since 2020.08
 */
public class MyMath {

    /**
     * PI
     */
    public static final float PI = 3.1415927f;

    /**
     * Euler's Number
     */
    public static final float E = 2.718281f;

    /**
     * This class does not have public constructor.
     */
    private MyMath(){};

    /**
     * Finds minimum real number among parameters.
     * @param params are values to be examined.
     * @return smallest real number.
     */
    public static double min(double... params) {
        double min = params[0];
        for (double i : params) {
            if (min > i) min = i;
        }
        return min;
    }

    /**
     * Finds maximum real number among parameters.
     * @param params are values to be examined.
     * @return largest real number.
     */
    public static double max(double... params) {
        double max = params[0];
        for (double i : params) {
            if (max < i) max = i;
        }
        return max;
    }

    /**
     * Converts real number into absolute value.
     * If the parameter is positive; will directly return the parameter.
     * @param param is value to be examined.
     * @return absolute value of param.
     */
    public static double abs(double param) {
        if (param < 0) return -param;
        return param;
    }

    /**
     * Get floor value of param.
     * @param param is value to be examined.
     * @return converted floor of parameter.
     */
    public static double floor(double param) {
        if (param < 0)
            return (int)param  - 1;
        return (int) param;
    }

    /**
     * Get ceiling value of param
     * @param param is value to be examined.
     * @return converted ceiling of parameter.
     */

    public static int ceil(double param) {
        if (param < 0)
            return (int) param;
        return (int) param + 1;
    }
}

class MyMathTest {
    public static void main(String[] args) {
//        System.out.println(MyMath()); // should fail
        System.out.println(MyMath.PI);
        System.out.println(MyMath.E);
        System.out.println(MyMath.min(2, 3, -4, 6));
        System.out.println(MyMath.max(7, 0, 6, 16, -4));
        System.out.println(MyMath.abs(5));
        System.out.println(MyMath.abs(-2.3));
        System.out.println(MyMath.floor(-1.5232));
        System.out.println(MyMath.ceil(4.6452));
    }
}
