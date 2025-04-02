package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Process_92 {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();

        // {priority, 시작 index}의 형태로 queue에 추가
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
        }

        int count = 0;
        while (!q.isEmpty()) {
            int[] head = q.poll();
            boolean hasLargerPriority = q.stream().anyMatch(arr -> arr[0] > head[0]);
            if (hasLargerPriority) {
                q.add(head);
            } else {
                count++;
                if (head[1] == location) {
                    return count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Process_92 process92 = new Process_92();
        System.out.println(process92.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
