package brute;

import java.util.Arrays;

public class FatigueSystem {
    public static int solution(int k, int[][] dungeons) {
        int visitCount = 0;
        int currentFatigue = k;
        int[][] sDungeons = Arrays.stream(dungeons)
                .sorted((o1, o2) ->
                        o1[0] - o1[1] == o2[0] - o2[1] ?
                                o2[0] - o1[0] :
                                ((o2[0] - o2[1]) - (o1[0] - o1[1])))
                .toArray(int[][]::new);

        for (int[] dungeon : sDungeons) {
            if (dungeon[0] > currentFatigue) {
                continue;
            }
            currentFatigue -= dungeon[1];
            visitCount++;
        }

        return visitCount;
    }

    public static void main(String[] args) {
        System.out.println(solution(78, new int[][]{{78, 18}, {70, 11}, {67, 9}, {60, 8}, {59, 2}, {57, 54}}));
        // 78, 18 | 70, 11 | 67, 9 | 59, 2 | 60, 8 | 57, 54
    }
}
