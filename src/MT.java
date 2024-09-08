import java.util.concurrent.*;

public class MT {
    public static int minOperations(int[] nums1, int[] nums2, int k) {
        if (nums1.length != nums2.length) {
            return -1; // 长度不等，无法相等
        }

        int sum1 = 0, sum2 = 0;
        int count = 0; // 记录差值能够被k整除的位置数量

        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff % k == 0) {
                count++; // 差值能被k整除，记录位置
            }
        }
        if (sum1 != sum2) {
            return -1; // 总和不等，无法通过操作相等
        }
        return (count + 1) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 7, 1};
        int[] nums2 = {2, 3, 1, 4};
        int k = 3;
        System.out.println(minOperations(nums1, nums2, k)); // 输出应为1
    }
}
