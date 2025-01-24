package brute;

import java.util.HashMap;
import java.util.Map;

public class StrangeKey_66 {

  public static void main(String[] args) {
    StrangeKey_66 s = new StrangeKey_66();
    System.out.println(s.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"GA"})[0]);
  }

  public int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];
    Map<Character, Integer> minKeyIndexMap = new HashMap<>();
    for (String key : keymap) {
      char[] temp = key.toCharArray();
      for (int i = 0; i < temp.length; i++) {
        Integer count = minKeyIndexMap.get(temp[i]);
        if (count == null || i < count) {
          minKeyIndexMap.put(temp[i], i);
        }
      }
    }

    for (int i = 0; i < targets.length; i++) {
      for (char c : targets[i].toCharArray()) {
        Integer temp = minKeyIndexMap.get(c);
        answer[i] = temp == null ? -1 : answer[i] + temp + 1;
      }
    }
    return answer;
  }

}
