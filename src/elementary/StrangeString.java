package elementary;

public class StrangeString {
    // try hello world
    // TrY HeLlO WoRlD

    public String solution(String s) {
        String[] stringArr = s.toLowerCase().split("");
        int modIndex = 0;
        for (int i = 0; i < stringArr.length; i++) {
            if (stringArr[i].equals(" ")) {
                modIndex = 0;
                continue;
            }

            if (modIndex % 2 == 0) {
                stringArr[i] = stringArr[i].toUpperCase();
            }
            modIndex++;
        }

        return String.join("", stringArr);
    }

    public static void main(String[] args) {
        StrangeString ss = new StrangeString();
        System.out.println(ss.solution("try  hello world"));
    }
}
