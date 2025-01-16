import java.util.stream.IntStream;

public class WeaponOfKnights_60 {

  public static void main(String[] args) {
    WeaponOfKnights_60 s = new WeaponOfKnights_60();
    System.out.println(s.solution(10, 3, 2));
  }

  public int solution(int number, int limit, int power) {
    return IntStream.rangeClosed(1, number)
        .map(i -> countSteelUsage(i, limit, power))
        .sum();
  }

  private int countSteelUsage(int knightNum, int limit, int power) {
    int numDivisor = countNumOfDivisor(knightNum);
    return numDivisor <= limit ? numDivisor : power;
  }

  private int countNumOfDivisor(int knightNum) {
    if (knightNum == 1) {
      return 1;
    }
    double root = Math.sqrt(knightNum);
    int count = 0;
    for (int i = 1; i <= (int) root; i++) {
      if (knightNum % i == 0) {
        count++;
      }
    }
    return root % 1.0 == 0 ? (count - 1) * 2 + 1 : count * 2;
  }
}
