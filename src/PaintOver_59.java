public class PaintOver_59 {

  public static void main(String[] args) {
    PaintOver_59 s = new PaintOver_59();
    System.out.println(s.solution(5, 2, new int[]{1, 4, 5}));
  }

  public int solution(int n, int m, int[] section) {
    // section [1, 4, 5]
    int reach = section[0] + m - 1;
    int brushNum = 1;

    for (int i = 0; i < section.length; i++) {
      if (section[i] > reach) {
        reach = section[i] + m - 1;
        brushNum++;
      }
    }
    return brushNum;
  }
}
