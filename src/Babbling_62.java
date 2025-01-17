public class Babbling_62 {

  public static void main(String[] args) {
    Babbling_62 s = new Babbling_62();
    s.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
  }

  public int solution(String[] babbling) {
    String regex = "^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$";
    int sol = 0;
    for (String word : babbling) {
      if (word.matches(regex)) {
        System.out.println(word);
        sol++;
      }
    }
    return sol;
  }
}
