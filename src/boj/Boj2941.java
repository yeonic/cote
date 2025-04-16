package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        System.out.println(countCroatia(word));
    }

    private static int countCroatia(String literal) {
        char[] words = literal.toCharArray();
        int count = 0;
        int index = 0;

        while (index < words.length) {
            if (words[index] == '=' || words[index] == '-') {
                if (words[index - 1] == 'z' && (index > 1 && words[index - 2] == 'd')) {
                    count -= 1;
                }
                index++;
                continue;
            }
            if (words[index] == 'j') {
                if (index > 0 && (words[index - 1] == 'l' || words[index - 1] == 'n')) {
                    index++;
                    continue;
                }
            }
            count += 1;
            index++;
        }

        return count;
    }
    // z = - j
}
