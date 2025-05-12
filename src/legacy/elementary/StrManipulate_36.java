package legacy.elementary;

public class StrManipulate_36 {

  public static void main(String[] args) {
    System.out.println(solution("-1234"));
  }

  public static boolean solution(String s) {
    int length = s.length();
    return (length == 4 || length == 6) && s.matches("[0-9]*");
  }
}
