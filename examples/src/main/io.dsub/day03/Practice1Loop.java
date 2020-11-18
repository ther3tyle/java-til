package io.dsub.day03;

public class Practice1Loop {
    public static void main(String[] args) {

        String s = "*";
        for (int i = 0; i <= 5; i++) {
            System.out.printf("%-5s\n", s.repeat(i));
        }
        s = "*";
        for (int i = 0; i < 5; i++) {
            System.out.printf("%5s\n", s);
            s += "*";
        }
        printStarTree(10);
        printNumberTree(10);
        printCentricNumTree(10);
        threeSixNine(8, 99, 1);
    }

    private static void printStarTree(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i += 2) {
            sb.append(" ".repeat((n - i) / 2 + 1));
            sb.append("*".repeat(i));
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private static void printNumberTree(int n) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < n; i += 2) {
            sb.append(" ".repeat((n - i) / 2 + 1));
            sb.append(String.valueOf(cnt).repeat(i));
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
            cnt++;
        }
    }

    private static void printCentricNumTree(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i += 2) {
            for (int hi = 1; hi <= i / 2 + 1; hi++) {
                sb.append(hi);
                if (hi > 1)
                    sb.insert(0, hi);
            }
            sb.insert(0, " ".repeat((n - i) / 2 + 1));
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private static void threeSixNine(int userCount, int gameLength, int myTurn) {
        for (int i = 0; i < gameLength; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println("만세!");
                continue;
            }
            if ((i - myTurn) % userCount == 0) {
                int cpNum = i;
                int numClap = 0;
                while (cpNum > 0) {
                    int t = cpNum % 10;
                    cpNum /= 10;
                    if (t % 3 == 0 && t != 0) {
                        numClap++;
                    }
                }
                if (numClap > 0) System.out.println("짝!".repeat(numClap));
                else System.out.printf("%d!\n", i);
            }
        }
    }
}
