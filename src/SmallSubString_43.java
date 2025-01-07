public class SmallSubString_43 {

  public static void main(String[] args) {
    System.out.println(solution("10123123123123123123203", "15"));
  }

  public static int solution(String t, String p) {
    int answer = 0;
    int sublen = p.length();
    StringBuilder sb = new StringBuilder(t);

    for (int i = 0; i < t.length() - sublen + 1; i++) {
      if (Long.parseLong(sb.substring(i, i + sublen)) <= Long.parseLong(p)) {
        answer++;
      }
    }

    return answer;
  }
}
