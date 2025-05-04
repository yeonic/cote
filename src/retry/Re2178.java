package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Re2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mazeSize = br.readLine().split(" ");
        int N = Integer.parseInt(mazeSize[0]), M = Integer.parseInt(mazeSize[1]);

        char[][] maze = new char[N][M];
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], -1);
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Integer> toVisit = new ArrayDeque<>();
        toVisit.add(0);
        dist[0][0] = 0;

        while (!toVisit.isEmpty()) {
            Integer curr = toVisit.poll();
            int cx = curr / M, cy = curr % M;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (maze[nx][ny] != '1' || dist[nx][ny] > -1) continue;
                dist[nx][ny] = dist[cx][cy] + 1;
                toVisit.add(nx * M + ny);
            }
        }

        System.out.println(dist[N - 1][M - 1] + 1);
    }
}
