package sort;

public class FoodFight_51 {

  public static void main(String[] args) {
    FoodFight_51 s = new FoodFight_51();
    System.out.println(s.solution(new int[]{1, 7, 1, 2}));
  }

  public String solution(int[] food) {
    int numFood = food.length;
    StringBuilder sb = new StringBuilder("0");
    for (int i = numFood - 1; i > 0; i--) {
      int temp = food[i] / 2;
      if (temp == 0) {
        continue;
      }

      String repeat = String.format("%d", i).repeat(temp);
      sb.insert(0, repeat);
      sb.append(repeat);
    }
    return sb.toString();
  }
}
