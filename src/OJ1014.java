import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class OJ1014 {
    private static HashMap<Integer, BigInteger> c = new HashMap<>();

    static {
        c.put(0, BigInteger.ONE);
        c.put(1, BigInteger.ONE);
        c.put(2, BigInteger.ONE);
    }
    private static BigInteger fibonacci(int x) {
        if (!c.containsKey(x)) {
            if ((x & 1) == 0) {
                //f(n+1)=f(n)+f(n-1)
                c.put((x >> 1) + 1, fibonacci((x >> 1) - 1).add(fibonacci(x >> 1)));
                c.put(x, fibonacci(x >> 1).multiply(fibonacci((x >> 1) + 1).add(fibonacci((x >> 1) - 1))));
            } else {
                c.put(x, fibonacci(x >> 1).multiply(fibonacci(x >> 1)).add(fibonacci((x >> 1) + 1).multiply(fibonacci((x >> 1) + 1))));
            }
        }
        return c.get(x).mod(BigInteger.valueOf(10007));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(fibonacci(in.nextInt()));
    }
}
