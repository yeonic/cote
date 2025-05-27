package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15649 {

    private static boolean[] isUsed = new boolean[9];
    private static int[] arr = new int[9];
    private static int N, M;

    public static void main(String[] args) throws IOException {
        // 자연수 n과 m이 주어졌을 때, 길이가 m인 수열
        // 1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        backtrack(0);
    }

    // [][][]
    private static void backtrack(int k) {
        if (k == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            System.out.print(sb.toString());
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                backtrack(k + 1);
                isUsed[i] = false;
            }
        }
    }
}
