package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < round; i++) {
            int curr = Integer.parseInt(br.readLine());

            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                maxHeap.offer(curr);
                System.out.println(curr);
                continue;
            }

            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(curr);
            } else {
                maxHeap.offer(curr);
            }

            if (maxHeap.peek() > minHeap.peek()) {
                Integer minOfLargerHalf = minHeap.poll();
                Integer maxOfSmallerHalf = maxHeap.poll();
                minHeap.offer(maxOfSmallerHalf);
                maxHeap.offer(minOfLargerHalf);
            }
            System.out.println(maxHeap.peek());
        }
    }
}