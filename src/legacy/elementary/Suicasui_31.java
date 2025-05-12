package legacy.elementary;

public class Suicasui_31 {

  public static void main(String[] args) {
    System.out.println(solution(7));
  }

  static String solution(int n) {
    StringBuilder result = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        result.append("박");
      } else {
        result.append("수");
      }
    }
    return result.toString();
  }
}
