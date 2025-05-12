package legacy.brute;

public class MakeBurger_68 {

    public static void main(String[] args) {
        MakeBurger_68 s = new MakeBurger_68();
        System.out.println(s.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int i : ingredient) {
            sb.append(i);
            int currentLen = sb.length();
            if (currentLen >= 4 && sb.substring(currentLen - 4, currentLen).equals("1231")) {
                answer++;
                sb.delete(currentLen - 4, currentLen);
            }
        }
        return answer;
    }
}
