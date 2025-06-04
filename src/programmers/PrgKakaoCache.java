package programmers;

import java.util.LinkedList;

public class PrgKakaoCache {
    private static LinkedList<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        for (String city : cities) {
            String name = city.toUpperCase();
            int index = cache.indexOf(name);
            if (index < 0) {
                if (cache.size() < cacheSize) {
                    cache.add(name);
                } else if (cacheSize != 0) {
                    cache.removeFirst();
                    cache.add(name);
                }
                answer += 5;
                continue;
            }
            String item = cache.remove(index);
            cache.add(name);
            answer += 1;
        }

        return answer;
    }
}
