package legacy.brute;

import java.util.HashMap;
import java.util.Map;

public class Mbti_69 {

    public static void main(String[] args) {
        Mbti_69 s = new Mbti_69();
    }

    public String solution(String[] servey, int[] choices) {
        Map<Character, Integer> indicatorMap = new HashMap<>(Map.ofEntries(
                Map.entry('R', 0),
                Map.entry('T', 0),
                Map.entry('C', 0),
                Map.entry('F', 0),
                Map.entry('J', 0),
                Map.entry('M', 0),
                Map.entry('A', 0),
                Map.entry('N', 0)
        ));

        int MIDDLE = 4;
        for (int i = 0; i < servey.length; i++) {
            if (choices[i] == MIDDLE) {
                continue;
            }
            if (choices[i] < MIDDLE) {
                indicatorMap.merge(servey[i].charAt(0), MIDDLE - choices[i], Integer::sum);
            } else {
                indicatorMap.merge(servey[i].charAt(1), choices[i] - MIDDLE, Integer::sum);
            }
        }
        return getPersonalityType(indicatorMap);
    }

    private String getPersonalityType(Map<Character, Integer> indicatorMap) {
        StringBuilder sb = new StringBuilder();
        sb.append(indicatorMap.get('R') >= indicatorMap.get('T') ? 'R' : 'T');
        sb.append(indicatorMap.get('C') >= indicatorMap.get('F') ? 'C' : 'F');
        sb.append(indicatorMap.get('J') >= indicatorMap.get('M') ? 'J' : 'M');
        sb.append(indicatorMap.get('A') >= indicatorMap.get('N') ? 'A' : 'N');
        return sb.toString();
    }
}
