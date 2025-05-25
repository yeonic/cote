package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15650 {
    private static int N, M;
    private static int[] arr = new int[9];
    private static boolean[] isUsed = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        recur(0, 0);
    }

    private static void recur(int i, int bef) {
        StringBuilder sb = new StringBuilder();
        if (i == M) {
            for (int k = 0; k < M; k++) {
                sb.append(arr[k]).append(" ");
            }
            sb.append("\n");
            System.out.print(sb.toString());
            return;
        }

        for (int k = 1; k <= N; k++) {
            // !isUsed && i==0
            // isUsed && i!=0 && arr[i-1] <= k
            if (!isUsed[k] && k >= bef) {
                arr[i] = k;
                isUsed[k] = true;
                recur(i + 1, k);
                isUsed[k] = false;
            }
        }
    }
}
