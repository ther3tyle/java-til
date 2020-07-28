package io.dsub.util;

public class BaseShifter {

    public static void main(String[] args) {
        String bin = "0b101";
        System.out.println(BaseShifter.shift(2, 10, bin));
    }

    private BaseShifter(){}
    private static String shift(int base, int target, String data) {
        final char[] baseDict = "0123456789ABCDEF".toCharArray();
        boolean shift = false;

        StringBuilder sb = new StringBuilder();

        int decimalSum = 0, multiplier = 1;

        if (base == 2 && data.charAt(1) == 'b')
            data = data.substring(2);

        for (int i = data.length() - 1; i >= 0; i--) {
            decimalSum += (data.charAt(i) - 48) * multiplier;
            multiplier *= base;
        }

        multiplier = target;

        while (decimalSum > 0 ) {
            sb.append(baseDict[decimalSum % multiplier]);
            decimalSum /= multiplier;
        }

        return sb.reverse().toString();
    }
}
