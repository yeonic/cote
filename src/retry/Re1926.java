package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Re1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);

        int[][] canvas = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            canvas[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSize = 0;
        int numPic = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 0 || visited[i][j] == 1) continue;
                Queue<Integer> toVisit = new ArrayDeque<>();
                visited[i][j] = 1;
                toVisit.add(i * m + j);
                numPic++;

                int temp = 1;
                while (!toVisit.isEmpty()) {
                    Integer curr = toVisit.poll();
                    int cx = curr / m, cy = curr % m;
                    for (int k = 0; k < 4; k++) {
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (canvas[nx][ny] == 0 || visited[nx][ny] == 1) continue;
                        visited[nx][ny] = 1;
                        toVisit.add(nx * m + ny);
                        temp++;
                    }
                }
                maxSize = Math.max(maxSize, temp);
            }
        }
        System.out.println(numPic + "\n" + maxSize);
    }
}
