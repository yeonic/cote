package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Re4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");

        int R = Integer.parseInt(rc[0]), C = Integer.parseInt(rc[1]);
        char[][] maze = new char[R][C];
        int[][] distF = new int[R][C];
        int[][] distJ = new int[R][C];

        Queue<Integer> toVisitF = new ArrayDeque<>();
        Queue<Integer> toVisitJ = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            maze[i] = br.readLine().toCharArray();
            Arrays.fill(distF[i], -1);
            Arrays.fill(distJ[i], -1);
            for (int j = 0; j < C; j++) {
                if (maze[i][j] == 'F') {
                    toVisitF.add(i * C + j);
                    distF[i][j] = 0;
                }
                if (maze[i][j] == 'J') {
                    toVisitJ.add(i * C + j);
                    distJ[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!toVisitF.isEmpty()) {
            Integer curr = toVisitF.poll();
            int cx = curr / C, cy = curr % C;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (maze[nx][ny] == '#' || distF[nx][ny] > -1) continue;
                distF[nx][ny] = distF[cx][cy] + 1;
                toVisitF.add(nx * C + ny);
            }
        }

        while (!toVisitJ.isEmpty()) {
            Integer curr = toVisitJ.poll();
            int cx = curr / C, cy = curr % C;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(distJ[cx][cy] + 1);
                    return;
                }
                if (maze[nx][ny] == '#' || distJ[nx][ny] > -1) continue;
                if (distF[nx][ny] != -1 && distJ[cx][cy] + 1 >= distF[nx][ny]) continue;
                distJ[nx][ny] = distJ[cx][cy] + 1;
                toVisitJ.add(nx * C + ny);
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
