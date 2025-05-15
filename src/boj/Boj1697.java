package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Boj1697 {
    // X-1 X+1 X*2가 Queue에 들어갈 대상이 된다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int subin = Integer.parseInt(input[0]);
        int sibling = Integer.parseInt(input[1]);

        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        Queue<Integer> subinQ = new ArrayDeque<>();
        subinQ.add(subin);
        dist[subin] = 0;

        while (dist[sibling] == -1) {
            Integer curr = subinQ.poll();
            for (int i : new int[]{curr + 1, curr - 1, curr * 2}) {
                if (i < 0 || i > 100_000) continue;
                if (dist[i] > -1) continue;
                dist[i] = dist[curr] + 1;
                subinQ.add(i);
            }
        }
        System.out.println(dist[sibling]);
    }
}
