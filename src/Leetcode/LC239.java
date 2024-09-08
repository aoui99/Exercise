package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC239 {
    public static void main(String[] args) {
        int[] test = new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
        int[] ans = maxSlidingWindow(test, 7);
        for(int i : ans){
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList();
        int max = nums[0];
        int index = 0;
        for(int i = 0; i < k; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
            deque.offer(nums[i]);
        }
        res[0] = max;
        for(int i = k; i < nums.length; i++){
            deque.poll();
            deque.offer(nums[i]);
            if(index > 0){
                if(max > nums[i]){
                    res[i - k + 1] = max;
                    index--;
                }else {
                    index = k - 1;
                    max = nums[i];
                    res[i - k + 1] = max;
                }
            }else if(index == 0){
                max = deque.peek();
                int count = -1;
                for(int item:deque){
                    count++;
                    if(item > max){
                        max = item;
                        index = count;
                    }
                }
                res[i - k + 1] = max;
            }
        }
        return res;
    }
}
