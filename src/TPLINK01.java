import java.util.*;
public class TPLINK01 {
    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // If no duplicate is found
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 0, 3, 2};
        int result = findDuplicate(nums);
        System.out.println(result); // Should print 3 or 2
    }

}
