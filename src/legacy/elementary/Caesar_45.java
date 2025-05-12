package legacy.elementary;

public class Caesar_45 {

    public static void main(String[] args) {
        Caesar_45 c = new Caesar_45();
        System.out.println(c.solution("A B", 2));
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();

        for (char c : cs) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            int cNum;
            if (c >= 'a' && c <= 'z') {
                cNum = (c + n - 'a') % 26 + 'a';
            } else {
                cNum = (c + n - 'A') % 26 + 'A';
            }
            sb.append((char) cNum);
        }
        return sb.toString();
    }
}
