import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam_57 {

  public static void main(String[] args) {
    MockExam_57 s = new MockExam_57();
  }

  public int[] solution(int[] answers) {
    int[] supoMan1 = new int[]{1, 2, 3, 4, 5};
    int[] supoMan2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] supoMan3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[] result = new int[]{0, 0, 0};

    for (int i = 0; i < answers.length; i++) {
      if (supoMan1[i % 5] == answers[i]) {
        result[0]++;
      }
      if (supoMan2[i % 8] == answers[i]) {
        result[1]++;
      }
      if (supoMan3[i % 10] == answers[i]) {
        result[2]++;
      }
    }
    int max = Arrays.stream(result).max().getAsInt();
    List<Integer> answer = new ArrayList<>();
    for (int j = 0; j < result.length; j++) {
      if (result[j] == max) {
        answer.add(j + 1);
      }
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

}
