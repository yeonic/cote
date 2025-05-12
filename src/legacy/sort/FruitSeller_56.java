package legacy.sort;

import java.util.Arrays;

public class FruitSeller_56 {

    public static void main(String[] args) {
        FruitSeller_56 s = new FruitSeller_56();
        System.out.println(s.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
    }

    public int solution(int k, int m, int[] score) {
        int[] sortedScore = Arrays.stream(score).sorted().toArray();
        int currMinValue = score.length - m;
        int result = 0;

        if (currMinValue < 0) {
            return 0;
        }

        while (currMinValue >= 0) {
            result += sortedScore[currMinValue] * m;
            currMinValue -= m;
        }

        return result;
    }
}
