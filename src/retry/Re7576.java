package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Re7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[1]), M = Integer.parseInt(size[0]);

        int[][] pomoBox = new int[N][M];
        int[][] dist = new int[N][M];

        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            pomoBox[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < M; j++) {
                if (pomoBox[i][j] == 1) {
                    toVisit.add(i * M + j);
                    dist[i][j] = 0;
                }
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!toVisit.isEmpty()) {
            Integer curr = toVisit.poll();
            int cx = curr / M, cy = curr % M;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (pomoBox[nx][ny] == -1 || dist[nx][ny] > -1) continue;
                dist[nx][ny] = dist[cx][cy] + 1;
                toVisit.add(nx * M + ny);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pomoBox[i][j] != -1 && dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][j]);
            }
        }
        System.out.println(max);
    }
}
