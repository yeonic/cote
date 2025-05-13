package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj12865 {
    private static int[] parseLine(String[] line) {
        int[] result = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            result[i] = Integer.parseInt(line[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] problemCond = parseLine(br.readLine().split(" "));

        int nObject = problemCond[0];
        int maxWeight = problemCond[1];
        int[] dp = new int[maxWeight + 1];

        for (int i = 0; i < nObject; i++) {
            int[] object = parseLine(br.readLine().split(" "));
            int weight = object[0];
            int value = object[1];

            for (int w = maxWeight; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }
        System.out.println(dp[maxWeight]);
    }
}
