package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2630 {
    private static int[][] paper;
    private static final int[] cCount = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        count(0, 0, N);
        for (int i : cCount) {
            System.out.println(i);
        }
    }

    private static boolean check(int ix, int iy, int unit) {
        int start = paper[ix][iy];
        for (int n = ix; n < ix + unit; n++) {
            for (int m = iy; m < iy + unit; m++) {
                if (paper[n][m] != start) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void count(int ix, int iy, int unit) {
        if (check(ix, iy, unit)) {
            cCount[paper[ix][iy]]++;
            return;
        }

        int size = unit / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                count(ix + i * size, iy + j * size, size);
            }
        }
    }

}
