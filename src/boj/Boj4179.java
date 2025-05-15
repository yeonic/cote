package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Boj4179 {
    static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] size = br.readLine().split(" ");
            int nRow = Integer.parseInt(size[0]), nCol = Integer.parseInt(size[1]);

            char[][] maze = new char[nRow][nCol];
            int[][] distFire = new int[nRow][nCol];
            int[][] distJi = new int[nRow][nCol];
            for (int i = 0; i < nRow; i++) {
                maze[i] = br.readLine().toCharArray();
                Arrays.fill(distFire[i], -1);
                Arrays.fill(distJi[i], -1);
            }

            Queue<int[]> fireQ = new ArrayDeque<>();
            Queue<int[]> jiQ = new ArrayDeque<>();

            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    if (maze[i][j] == 'F') {
                        fireQ.add(new int[]{i, j});
                        distFire[i][j] = 0;
                    }
                    if (maze[i][j] == 'J') {
                        jiQ.add(new int[]{i, j});
                        distJi[i][j] = 0;
                    }
                }
            }

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            while (!fireQ.isEmpty()) {
                int[] curr = fireQ.poll();
                int cx = curr[0], cy = curr[1];
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || nx >= nRow | ny < 0 || ny >= nCol) continue;
                    if (maze[nx][ny] == '#' || distFire[nx][ny] != -1) continue;
                    distFire[nx][ny] = distFire[cx][cy] + 1;
                    fireQ.add(new int[]{nx, ny});
                }
            }

            while (!jiQ.isEmpty()) {
                int[] curr = jiQ.poll();
                int cx = curr[0], cy = curr[1];
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || nx >= nRow | ny < 0 || ny >= nCol) {
                        System.out.println(distJi[cx][cy] + 1);
                        return;
                    }
                    if (maze[nx][ny] == '#' || distJi[nx][ny] > -1) continue;
                    if (distFire[nx][ny] != -1 && distFire[nx][ny] <= distJi[cx][cy] + 1) continue;

                    distJi[nx][ny] = distJi[cx][cy] + 1;
                    jiQ.add(new int[]{nx, ny});
                }
            }
            System.out.println("IMPOSSIBLE");
        }
    }
}

/*
4 4
####
#JF#
#.F#
#..#

1. 불이 붙을 시각을 계산해둔다(불은 여러 개일 수도 있다)
2. J는 벽인지, 현재 이미 불이 붙은 곳인지 파악하고 피한다
3. 만약 while loop을 나왔는데 지훈이가 가생이에 있지 않으면 IMPOSSIBLE 출력
 */