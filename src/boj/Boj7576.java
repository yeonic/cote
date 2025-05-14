package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Boj7576 {
    static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] firstLine = br.readLine().split(" ");
            int nRow = Integer.parseInt(firstLine[1]), nCol = Integer.parseInt(firstLine[0]);

            int[][] pomoBox = new int[nRow][nCol];
            int[][] dist = new int[nRow][nCol];

            for (int i = 0; i < nRow; i++) {
                Arrays.fill(dist[i], -1);
                pomoBox[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            Queue<int[]> toVisit = new ArrayDeque<>();
            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    if (pomoBox[i][j] != 1) continue;
                    toVisit.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            int dayMature = 0;
            while (!toVisit.isEmpty()) {
                int[] curr = toVisit.poll();
                int currX = curr[0];
                int currY = curr[1];
                for (int i = 0; i < 4; i++) {
                    int nx = currX + dx[i];
                    int ny = currY + dy[i];
                    if (nx < 0 || nx >= nRow || ny < 0 || ny >= nCol) continue;
                    if (pomoBox[nx][ny] == -1 || dist[nx][ny] > -1) continue;
                    toVisit.add(new int[]{nx, ny});
                    dist[nx][ny] = dist[currX][currY] + 1;
                    dayMature = Math.max(dayMature, dist[nx][ny]);
                }
            }

            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    if (pomoBox[i][j] != -1 && dist[i][j] < 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }

            System.out.println(dayMature);
        }
    }
}
