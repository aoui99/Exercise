package Leetcode;

public class LC56 {
    public static void main(String[] args) {
        int[][] input = new int[2][2];
        input[0] = new int[]{1, 4};
        input[1] = new int[]{4, 5};
        int[][] merge = merge(input);
        System.out.println(merge.toString());
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int endIndex = intervals.length;
        if(length == 1) return intervals;
        int[] pre = intervals[0];
        int[][] temp = new int[length][2];
        temp[0] = pre;
        for(int i = 1; i < length; i++){
            int[] cur = intervals[i];
            if(pre[1] >= cur[0]){
                int[] t = new int[2];
                t[0] = pre[0];
                t[1] = cur[1];
                temp[i-1] = t;
                temp[i] = new int[]{-1, -1};
                pre = t;
                endIndex--;
            }else{
                temp[i] = cur;
                pre = cur;
            }
        }
        int[][] res = new int[endIndex][2];
        for(int i = 0; i < endIndex; i++){
            if(temp[i][0] != -1){
                res[i] = temp[i];
            }
        }
        return res;
    }
}
