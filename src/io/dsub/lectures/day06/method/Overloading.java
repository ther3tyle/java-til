package io.dsub.lectures.day06.method;

/**
 * RULES FOR OVERLOADING METHODS
 *
 * 1. Same Name
 * 2. Different Parameter Type
 * 3. Different Parameter Count
 *
 * WHAT YOU CAN DO
 *
 * 1. Distinct operations for each cases
 * 2. Different return type
 * 3. They all have the same name
 *
 * CONCLUSION
 * Overloading gives ...
 * - User-friendly feature (intuition-wise)
 * - Versatility
 *
 * IMPORTANT
 * >> Overloaded functions are all considered as a SAME function
 *
 */
public class Overloading {
    StringBuilder sb = new StringBuilder();
    // May assume a function takes series of string....
    public String makeString(String... strings) { // somewhat original but NOT!
        for (int i = 0; i < strings.length; i++) {
            if (i != strings.length -1)
                sb.append(String.format("%s -> ", strings[i]));
            else
                sb.append(String.format("%s\n", strings[i]));
        }
        return pruneStrBuildr();
    }

    // May also assume THAT function ALSO takes a series of integers
    public String makeString(int... ints) { // overloaded
        for (int i = 0; i < ints.length; i++) {
            if (i != ints.length - 1)
                sb.append(String.format("%d -> ", ints[i]));
            else
                sb.append(String.format("%d\n", ints[i]));
        }
        return pruneStrBuildr();
    }

    // You may even have different return type
    public void makeString(float... floats) {
        for (int i = 0; i < floats.length; i++ ) {
            if (i != floats.length - 1)
                sb.append(String.format("%.3f -> ", floats[i]));
            else
                sb.append(String.format("%.3f\n", floats[i]));
        }
        System.out.println(pruneStrBuildr());
    }

    // a helper method
    private String pruneStrBuildr() {
        String s = sb.toString();
        sb.delete(0, sb.length());
        return s;
    }

    // example
    public static void main(String[] args) {
        // instantiate as the function is member function
        Overloading o = new Overloading();
        String s;

        s = o.makeString(15, 323, 34);
        System.out.print(s);
        s = o.makeString("love", "to", "code");
        System.out.print(s);
        o.makeString(332.34f, 4345.323f, 5.34f);
        System.out.print(s);
    }
}
