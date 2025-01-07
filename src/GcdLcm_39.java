public class GcdLcm_39 {

  public static void main(String[] args) {
    System.out.println(gcd(12, 8));
  }

  public static int[] solution(int n, int m) {
    int[] answer = {gcd(n, m), lcm(n, m)};
    return answer;
  }

  public static int gcd(int n, int m) {
    while (n % m != 0) {
      int temp = n % m;
      n = m;
      m = temp;
    }
    return m;
  }

  public static int lcm(int n, int m) {
    return n * m / gcd(n, m);
  }
}
