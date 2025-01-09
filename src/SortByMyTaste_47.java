import java.util.Arrays;
import java.util.Comparator;

public class SortByMyTaste_47 {

  public static void main(String[] args) {
    SortByMyTaste_47 s = new SortByMyTaste_47();
    System.out.println(Arrays.toString(s.solution(new String[]{"abce", "abcd", "cdx"}, 2)));
  }

  public String[] solution(String[] strings, int n) {
    return Arrays.stream(strings).sorted(
            Comparator.comparingInt((String s) -> s.charAt(n)).thenComparing(s -> s))
        .toArray(String[]::new);
  }
}
