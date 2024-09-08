public class LC367 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,6,8,};

        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length-1;
        while(left < right){
            if(nums[left]==val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
