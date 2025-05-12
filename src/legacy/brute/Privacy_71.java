package legacy.brute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Privacy_71 {

    public static void main(String[] args) {
        Privacy_71 s = new Privacy_71();
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (String term : terms) {
            String[] temp = term.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            int duration = termsMap.get(temp[1]);

            String expiredDate = fetchExpireDate(temp[0], duration);
            if (isExpired(today, expiredDate)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private String fetchExpireDate(String startDate, int duration) {
        int MONTHS_OF_YEAR = 12;
        int DAYS_OF_MONTH = 28;

        String[] yyddmm = startDate.split("\\.");

        int month = Integer.parseInt(yyddmm[1]) + duration;
        int day = Integer.parseInt(yyddmm[2]) - 1;

        if (day < 1) {
            month -= 1;
            day += DAYS_OF_MONTH;
        }

        if (month > MONTHS_OF_YEAR) {
            yyddmm[0] = String.valueOf(Integer.parseInt(yyddmm[0]) + 1);
            yyddmm[1] = String.format("%2d", month);
        }
        yyddmm[2] = String.format("%2d", day);

        return String.join(".", yyddmm);
    }

    private boolean isExpired(String today, String startDate) {
        String[] splitToday = today.split("\\.");
        String[] splitStartDate = startDate.split("\\.");

        if (Integer.parseInt(splitToday[0]) > Integer.parseInt(splitStartDate[0])) {
            return false;
        }

        if (Integer.parseInt(splitToday[1]) > Integer.parseInt(splitStartDate[1])) {
            return false;
        }

        if (Integer.parseInt(splitToday[2]) > Integer.parseInt(splitStartDate[2])) {
            return false;
        }

        return true;
    }
}
