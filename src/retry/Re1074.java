package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nrc = br.readLine().split(" ");
        int N = Integer.parseInt(nrc[0]), r = Integer.parseInt(nrc[1]), c = Integer.parseInt(nrc[2]);
        System.out.println(func(N, r, c));
    }

    private static int func(int N, int r, int c) {
        if (N == 0) return 0;
        int half = 1 << (N - 1);
        if (r < half && c < half) return func(N - 1, r, c);
        if (r < half && c >= half) return half * half + func(N - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + func(N - 1, r - half, c);
        return 3 * half * half + func(N - 1, r - half, c - half);
    }
}
