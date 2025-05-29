package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj15686 {
    private static int N, M;
    private static List<int[]> chicken = new ArrayList<>();
    private static List<int[]> selected = new ArrayList<>();
    private static List<int[]> house = new ArrayList<>();
    private static boolean[] isSelected = new boolean[15];
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int curr = Integer.parseInt(line[j]);
                if (curr == 1) house.add(new int[]{i, j});
                if (curr == 2) chicken.add(new int[]{i, j});
            }
        }
        recur(0, 0);
        System.out.println(min);
    }

    private static void recur(int i, int start) {
        if (i == M) {
            int distance = 0;
            for (int[] h : house) {
                int temp = Integer.MAX_VALUE;
                for (int[] s : selected) {
                    int local = Math.abs(s[0] - h[0]) + Math.abs(s[1] - h[1]);
                    temp = Math.min(local, temp);
                }
                distance += temp;
            }
            min = Math.min(min, distance);
            return;
        }

        for (int k = start; k < chicken.size(); k++) {
            if (!isSelected[k]) {
                isSelected[k] = true;
                int[] selectedChicken = chicken.get(k);
                selected.add(selectedChicken);
                recur(i + 1, k + 1);
                isSelected[k] = false;
                selected.remove(selectedChicken);
            }
        }
    }
}
