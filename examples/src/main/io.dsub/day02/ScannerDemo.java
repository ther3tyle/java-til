package io.dsub.day02;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        System.out.println("Input Methods.");
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[3];
        int i = 0;
        while (i < 3) {
            data[i++] = scanner.nextInt(); // next awaits next input -> blocking...
        }
        System.out.printf("Done! [%d, %d, %d]\n", data[0], data[1], data[2]);
        System.out.printf("%s\ncount 1\n",scanner.nextLine());
        System.out.printf("%s\ncount 2\n",scanner.nextLine());
        System.out.printf("%s\ncount 3\n",scanner.nextLine());
    }
}
