package legacy.stack_queue;

import java.util.Map;
import java.util.Stack;

public class RotatingParen {
    public int solution(String s) {
        Map<Character, Character> parenMap = Map.of('(', ')', '[', ']', '{', '}');
        Stack<Character> stack = new Stack<>();

        int i = 0, count = 0;
        String temp = s;
        while (i < s.length()) {
            // setup phase
            char[] charArray = temp.toCharArray();

            for (char c : charArray) {
                if (stack.isEmpty()) {
                    stack.add(c);
                    continue;
                }
                if (parenMap.get(stack.peek()) != null && c == parenMap.get(stack.peek())) {
                    stack.pop();
                    continue;
                }
                stack.add(c);
            }

            if (stack.isEmpty()) {
                count++;
            }

            // end phase
            stack.clear();
            temp = temp.substring(1) + temp.charAt(0);
            i++;
        }
        // ([]){}
        // ({])[
        return count;
    }

    public static void main(String[] args) {
        RotatingParen r = new RotatingParen();

        String[] tests = new String[]{"[](){}", "}]()[{", "[)(]", "}}}"};
        for (String test : tests) {
            System.out.println(r.solution(test));
        }
    }
}
