package elementary;

import java.util.HashMap;
import java.util.Map;

public class NumberString_46 {

  public static void main(String[] args) {
    NumberString_46 s = new NumberString_46();
    System.out.println(s.solution("123"));
  }

  public int solution(String s) {
    Map<String, String> strToNum = new HashMap<>(10) {{
      put("zero", "0");
      put("one", "1");
      put("two", "2");
      put("three", "3");
      put("four", "4");
      put("five", "5");
      put("six", "6");
      put("seven", "7");
      put("eight", "8");
      put("nine", "9");
    }};

    for (String key : strToNum.keySet()) {
      s = s.replaceAll(key, strToNum.get(key));
    }

    return Integer.parseInt(s);
  }
}
