import java.util.Scanner;

public class BD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        for (int i = 0; i < length; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(maxScore(n, k));
        }
    }

    public static int maxScore(int n, int k) {
        int[][] dp = new int[n + 2][k + 1];
        for (int i = 0; i <= n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i- 1][j - 1];
                if (i == n || (i < n && j < k)) {
                    dp[i][j]++;
                }

                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        return dp[n][k];
    }
}
