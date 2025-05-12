package legacy.elementary;

public class DescentStr_34 {

  public static void main(String[] args) {
    System.out.println(sort("Zbcdefg"));
  }

  public static String sort(String s) {
    char[] strArr = s.toCharArray();
    for (int j = strArr.length; j > 0; j--) {
      for (int i = 0; i < j - 1; i++) {
        if (strArr[i] < strArr[i + 1]) {
          char temp = strArr[i];
          strArr[i] = strArr[i + 1];
          strArr[i + 1] = temp;
        }
      }
    }
    return new String(strArr);
  }

  // 4 1 2 3 5 6 7
  // 4 2 3 5 6 7 1
}
