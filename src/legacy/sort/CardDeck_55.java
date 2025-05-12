package legacy.sort;

public class CardDeck_55 {

  public static void main(String[] args) {
    CardDeck_55 s = new CardDeck_55();
  }

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    int cards1Idx = 0, cards2Idx = 0;
    for (String s : goal) {
      if (s.equals(cards1[cards1Idx])) {
        cards1Idx++;
        cards1Idx = cards1Idx < cards1.length ? cards1Idx : cards1.length - 1;
      } else if (s.equals(cards2[cards2Idx])) {
        cards2Idx++;
        cards2Idx = cards2Idx < cards2.length ? cards2Idx : cards2.length - 1;
      } else {
        return "No";
      }
    }
    return "Yes";
  }


}
