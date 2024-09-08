import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OJ1016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> primes = eulerSieve(n);
        int size = primes.size();
        int a = 0;
        int b = 0;
        int c = 0;
        label: for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (n == primes.get(i) + primes.get(j) + primes.get(k)) {
                        a = primes.get(i);
                        b = primes.get(j);
                        c = primes.get(k);
                        break label;
                    }
                }
            }
        }
        System.out.printf("%d %d %d", a, b, c);
    }

    public static List<Integer> eulerSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) <= n; j++) {
                isPrime[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes;
    }
}
