package legacy.brute;

public class ClearDesktop_70 {

    public int[] solution(String[] wallpaper) {
        int[] answer = {-1, -1, 0, 0};

        for (int i = 0; i < wallpaper.length; i++) {
            char[] temp = wallpaper[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == '#') {
                    answer[0] = answer[0] < 0 ? i : Math.min(answer[0], i);
                    answer[1] = answer[1] < 0 ? j : Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i + 1);
                    answer[3] = Math.max(answer[3], j + 1);
                }
            }
        }

        return answer;
    }
}
