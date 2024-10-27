import java.util.Scanner;

public class SF02 {
    public static final int MOD = 998244353;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] types = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            types[i] = in.nextInt();
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (types[i] == 1) {
                for(int j = Math.max(1, i - k); j < i; j++) {
                    dp[i] = dp[i] + dp[j];
                }
            } else if (types[i] == 2) {
                for(int j = 1; j < i; j++) {
                    if (((i - j) & 1) != 1) {
                        dp[i] = dp[i] + dp[j];
                    }
                }
            } else if (types[i] == 3) {
                for(int j = 1; j < i; j++) {
                    if (((i - j) & 1) == 1) {
                        dp[i] = dp[i] + dp[j];
                    }
                }
            }
        }
        System.out.println(dp[n] % MOD);
    }
}
