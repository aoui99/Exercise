import java.util.*;
public class XC02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arrays = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arrays[i] = in.nextInt();
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 0;
                int currentGCD = arrays[i];
                for (int k = i; k > 0; k--) {
                    currentGCD = gcd(currentGCD, arrays[k]);
                    if (j > 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[k - 1][j - 1] + currentGCD);
                    } else if (k == 1){
                        dp[i][j] = Math.max(dp[i][j], currentGCD);
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    public static int gcd (int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
//
//    public static int gcdOfSubArray(int[] subarray) {
//        int gcdValue = subarray[0];
//        for (int i = 1; i < subarray.length; i++) {
//            gcdValue = gcd(gcdValue, subarray[i]);
//        }
//        return gcdValue;
//    }
//
//    public static int findMaxGCDSum(int[] array, int m) {
//        int maxSum = 0;
//        for (int start = 0; start < array.length; start++) {
//            int currentSum = 0;
//            int subarrayCount = 0;
//            int i = start;
//            while (i < array.length) {
//                int[] subarray = Arrays.copyOfRange(array, start, i + 1);
//                currentSum += gcdOfSubArray(subarray);
//                subarrayCount++;
//                if (subarrayCount == m) {
//                    maxSum = Math.max(maxSum, currentSum);
//                    break;
//                }
//                i++;
//            }
//        }
//        return maxSum;
//    }
}
