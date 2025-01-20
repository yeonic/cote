package sort;

import java.util.Arrays;

public class MakePrime_58 {

  public static void main(String[] args) {
    MakePrime_58 s = new MakePrime_58();
    System.out.println(s.solution(new int[]{1, 2, 7, 6, 4}));
  }

  public int solution(int[] nums) {
    boolean[] isPrimeArray = getIsPrimeArray(3000);
    int count = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (isPrimeArray[nums[i] + nums[j] + nums[k]]) {
            count++;
          }
        }
      }
    }
    return count;
  }

  private boolean[] getIsPrimeArray(int maxNum) {
    int maxInspectionNum = (int) Math.sqrt(maxNum);
    boolean[] isPrimeArray = new boolean[maxNum + 1];
    Arrays.fill(isPrimeArray, true);
    isPrimeArray[0] = isPrimeArray[1] = false;

    for (int i = 2; i < maxInspectionNum; i++) {
      if (!isPrimeArray[i]) {
        continue;
      }
      for (int j = i + 1; j < isPrimeArray.length; j++) {
        if (j % i == 0) {
          isPrimeArray[j] = false;
        }
      }
    }

    return isPrimeArray;
  }

}
