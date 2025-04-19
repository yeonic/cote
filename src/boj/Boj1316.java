package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iterations = Integer.parseInt(br.readLine());
        int counts = 0;
        for (int i = 0; i < iterations; i++) {
            String input = br.readLine();
            counts += isGroupWord(input) ? 1 : 0;
        }
        System.out.println(counts);
    }

    private static boolean isGroupWord(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            Integer index = lastIndexMap.getOrDefault(c[i], -1);
            if (index == -1) {
                lastIndexMap.put(c[i], i);
                continue;
            }
            if (i - index > 1) return false;
            lastIndexMap.put(c[i], i);
        }
        return true;
    }
}
