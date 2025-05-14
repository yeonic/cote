package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// 2178: 미로 탐색
public class Boj2178 {
    static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int nRow = Integer.parseInt(input[0]);
            int nCol = Integer.parseInt(input[1]);
            char[][] maze = new char[nRow][nCol];
            for (int i = 0; i < nRow; i++) {
                maze[i] = br.readLine().toCharArray();
            }
            System.out.println(bfsShortestPath(maze, nRow, nCol));
        }

        private static int bfsShortestPath(char[][] maze, int nRow, int nCol) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            int[][] paths = new int[nRow][nCol];
            for (int i = 0; i < nRow; i++) {
                Arrays.fill(paths[i], -1);
            }

            Queue<int[]> toVisit = new ArrayDeque<>();
            paths[0][0] = 0;
            toVisit.add(new int[]{0, 0});

            while (!toVisit.isEmpty()) {
                int[] curr = toVisit.poll();
                int cX = curr[0], cY = curr[1];
                for (int i = 0; i < 4; i++) {
                    int iterX = curr[0] + dx[i];
                    int iterY = curr[1] + dy[i];
                    if (iterX < 0 || iterX >= nRow || iterY < 0 || iterY >= nCol) continue;
                    if (maze[iterX][iterY] != '1' || paths[iterX][iterY] > -1) continue;
                    paths[iterX][iterY] = paths[cX][cY] + 1;
                    toVisit.add(new int[]{iterX, iterY});
                }
            }
            return paths[nRow - 1][nCol - 1] + 1;
        }
    }
}
