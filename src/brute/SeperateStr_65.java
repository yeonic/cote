package brute;

import java.util.ArrayList;

public class SeperateStr_65 {

  public static void main(String[] args) {
    SeperateStr_65 s = new SeperateStr_65();
    System.out.println(s.solution("abracadabra"));
  }

  public int solution(String s) {
    String[] strSplit = s.split("");
    int startIdx = 0, currentIdx = 1;
    int startCount = 1, otherCount = 0;
    int result = 0;

    ArrayList<Integer> integers = new ArrayList<>();

    while (startIdx < strSplit.length) {
      if (currentIdx == strSplit.length && startCount != otherCount) {
        result++;
        break;
      }

      if (strSplit[startIdx].equals(strSplit[currentIdx])) {
        startCount++;
      } else {
        otherCount++;
      }

      if (startCount == otherCount) {
        result++;
        startIdx = currentIdx + 1;
        currentIdx = startIdx + 1;
        startCount = 1;
        otherCount = 0;
        continue;
      }

      currentIdx++;
    }
    return result;
  }
}
