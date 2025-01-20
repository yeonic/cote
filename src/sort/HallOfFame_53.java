package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HallOfFame_53 {

  public static void main(String[] args) {
    HallOfFame_53 s = new HallOfFame_53();
    int[] solution = s.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
    for (int a : solution) {
      System.out.println(a);
    }
  }

  public int[] solution(int k, int[] score) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    List<Integer> lowest = new ArrayList<>();

    for (int j : score) {
      if (heap.size() == k && j > heap.peek()) {
        heap.remove();
        heap.add(j);
      } else if (heap.size() < k) {
        heap.add(j);
      }
      lowest.add(heap.peek());
    }

    return lowest.stream().mapToInt(Integer::intValue).toArray();
  }

}
