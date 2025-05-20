package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1182 {
    private static int N, S;
    private static int[] seq;
    private static int count = 0;
    private static int noSelection = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = br.readLine().split(" ");
        N = Integer.parseInt(ns[0]);
        S = Integer.parseInt(ns[1]);

        String[] s = br.readLine().split(" ");
        seq = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        recur(0, 0);
        if (S == 0) count--;
        System.out.println(count);
    }

    private static void recur(int i, int sum) {
        if (i == N) {
            count += sum == S ? 1 : 0;
            return;
        }
        recur(i + 1, sum);
        recur(i + 1, sum + seq[i]);
    }
}
