package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj15663 {
    private static int N, M;
    private static int[] arr = new int[8];
    private static int[] cand;
    private static boolean[] isUsed;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        String[] cands = br.readLine().split(" ");

        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        isUsed = new boolean[N];
        cand = Arrays.stream(cands).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cand);

        recur(0);
        System.out.print(sb.toString());
    }

    private static void recur(int i) {
        // 4 2
        // 4 4 4 4
        // 그 레벨에서 선택했던 것은 선택하지 않도록.
        if (i == M) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
            return;
        }

        List<Integer> blacklist = new ArrayList<>();
        for (int k = 0; k < N; k++) {
            if (!isUsed[k] && !blacklist.contains(cand[k])) {
                arr[i] = cand[k];
                blacklist.add(cand[k]);
                isUsed[k] = true;
                recur(i + 1);
                isUsed[k] = false;
            }
        }
    }
}
