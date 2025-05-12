package legacy.sort;

public class CokeProblem_52 {

  public static void main(String[] args) {
    CokeProblem_52 s = new CokeProblem_52();
    System.out.println(s.solution(3, 2, 20));
  }

  public int solution(int a, int b, int n) {
    return collectCoke(a, b, n, 0, 0);
  }

  public int collectCoke(int a, int b, int n, int r, int coke) {
    if (n < a) {
      return n + r >= a ? collectCoke(a, b, n + r, 0, coke) : coke;
    }

    return collectCoke(a, b, (n / a) * b, r + n % a, coke + (n / a) * b);
  }

}
