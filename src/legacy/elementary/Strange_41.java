package legacy.elementary;

public class Strange_41 {

  public static void main(String[] args) {
    System.out.println(solution("try hello world "));
  }

  public static String solution(String s) {
    String[] splited = s.toUpperCase().split("");
    int iter = 0;

    for (int i = 0; i < splited.length; i++) {
      if (splited[i].equals(" ")) {
        iter = 0;
        continue;
      }
      if (iter % 2 == 0) {
        iter++;
        continue;
      }

      splited[i] = splited[i].toLowerCase();
      iter++;
    }
    return String.join("", splited);
  }
}
