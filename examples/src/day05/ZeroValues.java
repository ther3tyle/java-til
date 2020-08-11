package day05;

public class ZeroValues {

    byte zeroByte;
    short zeroShort;
    int zeroInt;
    long zeroLong;

    float zeroFloat;
    double zeroDouble;

    String zeroString;
    char zeroChar;

    public static void main(String[] args) {
        ZeroValues values = new ZeroValues();
        System.out.println("zeroByte: " + values.zeroByte);
        System.out.println("zeroShort: " + values.zeroShort);
        System.out.println("zeroInt: " + values.zeroInt);
        System.out.println("zeroLong: " + values.zeroLong);
        System.out.println("zeroFloat: " + values.zeroFloat);
        System.out.println("zeroDouble: " + values.zeroDouble);
        System.out.println("zeroString: " + values.zeroString);
        System.out.println("zeroChar: " + (int) values.zeroChar); // '\u0000'
    }
}
