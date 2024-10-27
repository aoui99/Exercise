import java.util.*;

public class XC01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int res = 0;
        while (n > 0L) {
            if (isPrime(n)) {
                n -= (long) Math.floor(n/3);
                n -= 1;
                res++;
            }else {
                n -= (long) Math.floor(n/2);
                n -= 1;
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean isPrime(long num) {
        if (num < 2L) {
            return false;
        }
        for (long i = 2L; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
