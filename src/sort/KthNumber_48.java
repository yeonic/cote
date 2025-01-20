package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthNumber_48 {

  public static void main(String[] args) {
    KthNumber_48 s = new KthNumber_48();
  }

  public int[] solution(int[] array, int[][] commands) {
    List<Integer> answer = new ArrayList<>();
    for (int[] cmd : commands) {
      int[] temp = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
      Arrays.sort(temp);
      answer.add(temp[cmd[2] - 1]);
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

}
