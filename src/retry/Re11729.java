package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re11729 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((1 << N) - 1).append("\n");
        hanoi(1, 3, N);
        System.out.println(sb.toString());
    }

    // N=1 -> 1 3
    // N=K -> func(1, 2, K-1), 1 3, func(2, 3, K-1)
    private static void hanoi(int from, int to, int n) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(from, 6 - from - to, n - 1);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(6 - from - to, to, n - 1);
    }
}
