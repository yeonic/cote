package legacy.brute;

import java.util.Arrays;

public class Rottery_61 {

    public static void main(String[] args) {
        Rottery_61 s = new Rottery_61();
        int[] sol = s.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
        System.out.println("[" + sol[0] + ", " + sol[1] + "]");
    }

    public int[] solution(int[] lottos, int[] win_num) {
        int zeroCount = 0, matchCount = 0;
        Arrays.sort(win_num);

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            for (int i : win_num) {
                if (lotto == i) {
                    matchCount++;
                    break;
                }
            }
        }
        return new int[]{matchNumToRank(matchCount + zeroCount), matchNumToRank(matchCount)};
    }

    private int matchNumToRank(int matchNum) {
        return matchNum > 1 ? 7 - matchNum : 6;
    }
}
