package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Boj1926 {
    static class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] paperSize = parseLine(br.readLine());
            int nRow = paperSize[0];
            int nCol = paperSize[1];

            int[][] paper = new int[nRow][nCol];
            for (int i = 0; i < nRow; i++) {
                paper[i] = parseLine(br.readLine());
            }
            int[] result = bfsPics(paper, nRow, nCol);
            System.out.printf("%d\n%d", result[0], result[1]);
        }

        /**
         * @return int[0]: num of pics | int[1]: size of largest pic
         */
        private static int[] bfsPics(int[][] paper, int nRow, int nCol) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            int[] result = {0, 0};
            int[][] visited = new int[nRow][nCol];

            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    if (paper[i][j] != 1 || visited[i][j] != 0) continue;
                    Queue<int[]> toVisit = new ArrayDeque<>();
                    result[0]++;
                    toVisit.add(new int[]{i, j});
                    visited[i][j] = 1;

                    int tempPicSize = 1;
                    while (!toVisit.isEmpty()) {
                        int[] curr = toVisit.poll();
                        for (int k = 0; k < 4; k++) {
                            int iterX = curr[0] + dx[k];
                            int iterY = curr[1] + dy[k];
                            if (iterX < 0 || iterY < 0 || iterX >= nRow || iterY >= nCol) continue;
                            if (paper[iterX][iterY] != 1 || visited[iterX][iterY] != 0) continue;
                            visited[iterX][iterY] = 1;
                            toVisit.add(new int[]{iterX, iterY});
                            tempPicSize++;
                        }
                    }
                    result[1] = Math.max(result[1], tempPicSize);
                }
            }
            return result;
        }

        private static int[] parseLine(String line) {
            return Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
