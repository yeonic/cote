public class TTST_54 {

  public static void main(String[] args) {
    TTST_54 s = new TTST_54();
    System.out.println(s.solution(10, 29));

  }

  // 1월 1일은 금요일
  // 2월은 29일까지
  public String solution(int a, int b) {
    String[] days = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    int[] daysOfMonths = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int daysFromFirstDay = 0;

    for (int i = 1; i < a; i++) {
      daysFromFirstDay += daysOfMonths[i];
    }
    daysFromFirstDay += b - 1;

    return days[daysFromFirstDay % 7];
  }


}
