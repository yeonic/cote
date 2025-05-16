package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        for (int r = 0; r < round; r++) {
            String[] info = br.readLine().split(" ");
            int m = Integer.parseInt(info[0]);
            int n = Integer.parseInt(info[1]);
            int k = Integer.parseInt(info[2]);

            // 밭에 배추 위치를 초기화 한다.
            int[][] field = new int[m][n];
            int[][] visited = new int[m][n];
            for (int i = 0; i < k; i++) {
                String[] worm = br.readLine().split(" ");
                int x = Integer.parseInt(worm[0]);
                int y = Integer.parseInt(worm[1]);
                field[x][y] = 1;
            }

            // 이중루프에서 BFS를 돌면서 배추 군집의 개수를 센다
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] != 1 || visited[i][j] == 1) continue;
                    Queue<Integer> toVisit = new ArrayDeque<>();
                    toVisit.add(i * n + j);
                    visited[i][j] = 1;

                    count++;
                    while (!toVisit.isEmpty()) {
                        Integer curr = toVisit.poll();
                        int cx = curr / n, cy = curr % n;
                        for (int s = 0; s < 4; s++) {
                            int nx = cx + dx[s];
                            int ny = cy + dy[s];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if (field[nx][ny] != 1 || visited[nx][ny] == 1) continue;

                            toVisit.add(nx * n + ny);
                            visited[nx][ny] = 1;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
