package boj;

import java.util.Scanner;

public class Boj1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long c = Long.parseLong(input[2]);

        System.out.println(pow(a, b, c));
    }

    private static long pow(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = pow(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) return val;
        return val * 2 % c;
    }
}
