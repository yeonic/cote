package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Re1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]), K = Integer.parseInt(nk[1]);

        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        Queue<Integer> toVisit = new ArrayDeque<>();
        toVisit.add(N);
        dist[N] = 0;

        while (dist[K] < 0) {
            Integer curr = toVisit.poll();
            for (int i : new int[]{curr + 1, curr - 1, curr * 2}) {
                if (i < 0 || i > 100_000) continue;
                if (dist[i] > -1) continue;
                dist[i] = dist[curr] + 1;
                toVisit.add(i);
            }
        }

        System.out.println(dist[K]);
    }
}
