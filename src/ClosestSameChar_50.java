import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestSameChar_50 {

  public static void main(String[] args) {
    ClosestSameChar_50 s = new ClosestSameChar_50();
    for (int i : s.solution("foobar")) {
      System.out.println(i);
    }
  }

  public int[] solution(String s) {
    Map<Character, Integer> closeCharMap = new HashMap<>();

    char[] charArr = s.toCharArray();
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < charArr.length; i++) {
      int temp = closeCharMap.getOrDefault(charArr[i], -1);
      closeCharMap.put(charArr[i], i);

      if (temp == -1) {
        answer.add(temp);
        continue;
      }
      answer.add(i - temp);
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }
}
