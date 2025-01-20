package elementary;

import java.util.Arrays;

public class Three_Musketeers_42 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{0, 0, 0, 0, 0, 0}));

  }

  public static int solution(int[] number) {
    int cnt = 0;

    Arrays.sort(number);
    for (int i = 0; i < number.length - 2; i++) {
      if (number[i] > 0) {
        break;
      }

      for (int j = i + 1; j < number.length - 1; j++) {
        for (int k = j + 1; k < number.length; k++) {
          if (number[i] + number[j] + number[k] == 0) {
            cnt++;
          }
        }
      }
    }

    return cnt;
  }
}

// [-2, 3, 0, 2, -5] -> [-5, -2, 0, 2, 3]
// [-3, -2, -1, 0, 1, 2, 3]
// [-1, 1, -1, 1]