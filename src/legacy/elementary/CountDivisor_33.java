package legacy.elementary;

public class CountDivisor_33 {

  public static void main(String[] args) {
    System.out.println(solution(13, 17));
  }

  public static int solution(int left, int right) {
    int result = 0;
    for (int i = left; i <= right; i++) {
      int divisor = countDivisor(i);
      System.out.println(divisor);
      if (divisor % 2 == 0) {
        result += i;
      } else {
        result -= i;
      }
    }
    return result;
  }

  public static int countDivisor(int n) {
    int count = 0;
    int i;
    double sqrt = Math.sqrt(n);

    for (i = 1; i < sqrt; i++) {
      if (n % i == 0) {
        count++;
      }
    }

    count *= 2;

    if (i == sqrt) {
      count++;
    }
    return count;
  }
}
