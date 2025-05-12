package legacy.brute;

import java.util.ArrayList;
import java.util.List;

public class JustTwoOfUs_67 {

    public static void main(String[] args) {
        JustTwoOfUs_67 s = new JustTwoOfUs_67();
        System.out.println(s.solution("klmnopqrstuvzyx", "abcdefghij", 20));
    }

    public String solution(String s, String skip, int index) {
        int INT_A = 97, INT_Z = 122;

        String DELIM = "";
        String[] splits = s.split(DELIM);

        List<String> alphaList = new ArrayList<>() {{
            for (int i = INT_A; i < INT_Z + 1; i++) {
                String temp = String.valueOf((char) i);
                if (!skip.contains(temp)) {
                    add(temp);
                }
            }
        }};

        for (int i = 0; i < splits.length; i++) {
            int currStrIdx = alphaList.indexOf(splits[i]);
            splits[i] = alphaList.get((currStrIdx + index) % alphaList.size());
        }

        return String.join("", splits);
    }
}
