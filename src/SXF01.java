import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SXF01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int[] nums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.println(lengthOfLongestSubstring(nums));
    }

    public static int lengthOfLongestSubstring(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
