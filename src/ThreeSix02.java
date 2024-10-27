import java.util.Scanner;

public class ThreeSix02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int len = in.nextInt();
            int[] nums = new int[len];
            for (int j = 0; j < len; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(findMaxIncreaseSub(nums));
        }
    }

    public static int findMaxIncreaseSub(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxLength = 1;
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i] > nums[i - 1] ? left[i - 1] + 1 : 1;
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i] < nums[i + 1] ? right[i + 1] + 1 : 1;
        }
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, left[i]);
            if (i > 0) {
                maxLength = Math.max(maxLength, left[i - 1] + 1);
            }
            if (i < n - 1){
                maxLength = Math.max(maxLength, right[i + 1] + 1);
                if (i > 0 && nums[i - 1] < nums[i + 1] - 1) {
                    maxLength = Math.max(maxLength, left[i - 1] + right[i + 1] + 1);
                }
            }
        }
        return maxLength;
    }
}
