package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Re1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] abc = br.readLine().split(" ");
        BigInteger A = BigInteger.valueOf(Integer.parseInt(abc[0]));
        BigInteger B = BigInteger.valueOf(Integer.parseInt(abc[1]));
        BigInteger C = BigInteger.valueOf(Integer.parseInt(abc[2]));

        System.out.println(func(A, B, C));
    }

    private static BigInteger func(BigInteger a, BigInteger b, BigInteger c) {
        if (b.equals(BigInteger.ONE)) return a.mod(c);
        BigInteger val = func(a, b.divide(BigInteger.TWO), c);
        if (b.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return val.multiply(val).mod(c);
        return val.multiply(val).multiply(a).mod(c);
    }
}
