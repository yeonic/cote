package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9663 {
    private static int N;
    private static int count = 0;

    private static boolean[] isUsed1;
    private static boolean[] isUsed2;
    private static boolean[] isUsed3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isUsed1 = new boolean[N];
        isUsed2 = new boolean[2 * N - 1];
        isUsed3 = new boolean[2 * N - 1];
        recur(0);
        System.out.println(count);
    }

    private static void recur(int x) {
        if (x == N) {
            count++;
            return;
        }

        for (int y = 0; y < N; y++) {
            if (!isUsed1[y] && !isUsed2[x + y] && !isUsed3[x - y + N - 1]) {
                isUsed1[y] = true;
                isUsed2[x + y] = true;
                isUsed3[x - y + N - 1] = true;
                recur(x + 1);
                isUsed1[y] = false;
                isUsed2[x + y] = false;
                isUsed3[x - y + N - 1] = false;
            }
        }
    }
}

// [0][-1][-2][-3]
// [1][0][-1][-2]
// [2][1][0][-1]
// [3][2][1][0]
