package legacy.sort;

import java.util.ArrayList;
import java.util.List;

public class GetTwoAndAdd_49 {

  public static void main(String[] args) {
    GetTwoAndAdd_49 s = new GetTwoAndAdd_49();
  }

  public int[] solution(int[] numbers) {
    List<Integer> temp = new ArrayList<>();

    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        temp.add(numbers[i] + numbers[j]);
      }
    }

    return temp.stream().distinct()
        .sorted(Integer::compare).mapToInt(Integer::intValue).toArray();
  }
}
