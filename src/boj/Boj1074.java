package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
        System.out.println(zSearch(N, r, c));
    }

    private static int zSearch(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        if (r < half && c < half) return zSearch(n - 1, r, c);
        if (r < half && c >= half) return half * half + zSearch(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + zSearch(n - 1, r - half, c);
        return 3 * half * half + zSearch(n - 1, r - half, c - half);
    }

    /**
     * 0,0  0,1  0,2  0,3
     * 1,0  1,1  1,2  1,3
     * 2,0  2,1  2,2  2,3
     * 3,0  3,1  3,2  3,3
     */
}

