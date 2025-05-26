package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15651 {
    private static int N, M;
    private static int[] arr = new int[7];
    private static StringBuilder sb = new StringBuilder();

    // 1 2 3 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipt = br.readLine().split(" ");
        N = Integer.parseInt(ipt[0]);
        M = Integer.parseInt(ipt[1]);

        recur(0);
        System.out.print(sb.toString());
    }

    private static void recur(int i) throws IOException {
        if (i == M) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int k = 1; k <= N; k++) {
            arr[i] = k;
            recur(i + 1);
        }
    }
}
