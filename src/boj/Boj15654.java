package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15654 {
    private static int N, M;
    private static int[] arr = new int[8];
    private static int[] cand;
    private static boolean[] isUsed;
    private static StringBuilder sb = new StringBuilder();

    // 1 2 3 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipt = br.readLine().split(" ");
        N = Integer.parseInt(ipt[0]);
        M = Integer.parseInt(ipt[1]);

        String[] ipt2 = br.readLine().split(" ");

        cand = Arrays.stream(ipt2).mapToInt(Integer::parseInt).toArray();
        isUsed = new boolean[N];
        Arrays.sort(cand);

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

        for (int k = 0; k < N; k++) {
            if (!isUsed[k]) {
                arr[i] = cand[k];
                isUsed[k] = true;
                recur(i + 1);
                isUsed[k] = false;
            }
        }
    }
}
