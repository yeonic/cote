package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17478 {
    private static StringBuilder sb = new StringBuilder(
            "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

    public static String WHAT_IS_RECUR = "\"재귀함수가 뭔가요?\"\n";
    public static String LISTEN_1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    public static String LISTEN_2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    public static String LISTEN_3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    public static String FINALLY = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    public static String HE_SAID = "라고 답변하였지.\n";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());
        func(depth, 0);
        System.out.println(sb.toString());
    }

    private static void func(int depth, int curr) {
        String indent = "_".repeat(4 * curr);
        if (curr == depth) {
            sb.append(indent).append(WHAT_IS_RECUR)
                    .append(indent).append(FINALLY)
                    .append(indent).append(HE_SAID);
            return;
        }
        sb.append(indent).append(WHAT_IS_RECUR)
                .append(indent).append(LISTEN_1)
                .append(indent).append(LISTEN_2)
                .append(indent).append(LISTEN_3);
        func(depth, curr + 1);
        sb.append(indent).append(HE_SAID);
    }
}
