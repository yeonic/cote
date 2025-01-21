package brute;

import java.util.Arrays;

public class TrainingPants_64 {

  public static void main(String[] args) {
    TrainingPants_64 s = new TrainingPants_64();
    System.out.println(s.solution(3, new int[]{3}, new int[]{3}));
  }

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n;
    int[] borrowables = new int[n + 1];
    Arrays.fill(borrowables, 0);
    Arrays.sort(lost);

    for (int r : reserve) {
      borrowables[r] = 1;
    }
    for (int l : lost) {
      borrowables[l] -= 1;
    }

    for (int l : lost) {
      if (borrowables[l] == -1) {
        if (l > 0 && borrowables[l - 1] > 0) {
          borrowables[l - 1]--;
        } else if (l < borrowables.length - 1 && borrowables[l + 1] > 0) {
          borrowables[l + 1]--;
        } else {
          answer--;
        }
      }
    }

    return answer;
  }

  //  reserve
}