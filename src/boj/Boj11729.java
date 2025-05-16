package boj;

import java.io.*;

public class Boj11729 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, k) - 1)).append("\n");
        hanoi(1, 3, k);
        bw.append(sb.toString());
        bw.flush();
    }

    private static void hanoi(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        hanoi(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(6 - a - b, b, n - 1);
    }
}
