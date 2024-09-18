import java.util.Scanner;

public class MTQZ02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long[] results = new long[T];
        for (int i = 0; i < T; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long sets = maxBirckSets(a, b, c, x, y);
            results[i] = sets;
        }
        for (int i = 0; i < T; i++) {
            System.out.println(results[i]);
        }
        scanner.close();
    }

    private static long maxBirckSets(long a, long b, long c, long x, long y) {
        long sets = Math.min(a, Math.min(b, c));
        long remainA = a - sets;
        long remainB = b - sets;

        long additionalB = remainA / x;
        remainB += additionalB;
        long additionalC = remainB / y;
        long finalC = c - sets + additionalC;
        sets += Math.min(finalC, additionalC);
        return  sets;
    }
}
