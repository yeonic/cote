package sort;

import java.util.Arrays;

public class Hindex {
    public int solution(int[] citations) {
        // 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용
        // 3, 0, 6, 1, 5
        // 0 1 3 5 6
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        Hindex h = new Hindex();
        System.out.println(h.solution(new int[]{3, 0, 6, 1, 5}));
    }
}
