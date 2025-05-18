package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1780 {
    private static int[][] paper;
    private static final int[] count = new int[3]; // -1, 0, 1 각각의 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        func(0, 0, N);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    private static boolean check(int row, int col, int size) {
        int start = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (start != paper[i][j]) return false;
            }
        }
        return true;
    }

    private static void func(int row, int col, int size) {
        if (check(row, col, size)) {
            count[1 + paper[row][col]]++;
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }
}
