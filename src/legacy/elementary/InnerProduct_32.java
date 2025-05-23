package legacy.elementary;

public class InnerProduct_32 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};

        System.out.println(solution(a, b));
    }

    static int solution(int[] a, int[] b) {
        int inner = 0;

        for (int i = 0; i < a.length; i++) {
            inner += a[i] * b[i];
        }

        return inner;
    }
}
