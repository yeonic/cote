package brute;

import java.util.Map;

public class NumberPeer_63 {

  public static void main(String[] args) {
    NumberPeer_63 s = new NumberPeer_63();
    System.out.println(s.solution("22222200", "300"));
  }

  public String solution(String X, String Y) {
    String[] orders = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
    StringBuilder sb = new StringBuilder();
    Map<String, int[]> countMap = Map.ofEntries(
        Map.entry("0", new int[]{0, 0}),
        Map.entry("1", new int[]{0, 0}),
        Map.entry("2", new int[]{0, 0}),
        Map.entry("3", new int[]{0, 0}),
        Map.entry("4", new int[]{0, 0}),
        Map.entry("5", new int[]{0, 0}),
        Map.entry("6", new int[]{0, 0}),
        Map.entry("7", new int[]{0, 0}),
        Map.entry("8", new int[]{0, 0}),
        Map.entry("9", new int[]{0, 0})
    );

    for (String x : X.split("")) {
      countMap.get(x)[0]++;
    }
    for (String y : Y.split("")) {
      countMap.get(y)[1]++;
    }

    for (String order : orders) {
      int[] count = countMap.get(order);
      sb.append(order.repeat(Integer.min(count[0], count[1])));
    }
    return sb.isEmpty() ?
        "-1" : sb.substring(0, 1).equals("0") ?
        "0" : sb.toString();
  }
}
