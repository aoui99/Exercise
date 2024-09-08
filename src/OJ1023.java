import java.math.BigInteger;
import java.util.Scanner;

public class OJ1023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        BigInteger bigInteger = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i + 1));
        }
        System.out.println(bigInteger.toString());
    }
}
