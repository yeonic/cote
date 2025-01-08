public class MinimumRect_44 {

  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
  }

  public static int solution(int[][] sizes) {
    int width = 0, height = 0;
    for (int[] size : sizes) {
      width = Math.max(width, Math.max(size[0], size[1]));
      height = Math.max(height, Math.min(size[0], size[1]));
    }
    return width * height;
  }
}
