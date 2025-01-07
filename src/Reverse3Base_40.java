public class Reverse3Base_40 {

  public static void main(String[] args) {
    System.out.println(solution(125));
  }

  public static int solution(int n) {
    return Integer.parseInt(toFlippedBase3(n, ""), 3);
  }

  public static String toFlippedBase3(int n, String res) {
    if (n / 3 == 0) {
      return res + n % 3;
    }
    return toFlippedBase3(n / 3, res + n % 3);
  }


}
