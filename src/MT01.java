import java.util.Scanner;

public class MT01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        long sum = in.nextLong();
        long[] nums = new long[n];
        in.nextLine();
        int index = 0;
        for(int i = 0; i < n; i++){
            long temp = in.nextLong();
            if(temp != -1){
                nums[i] = temp;
                sum -= temp;
            }else{
                index = i;
            }
        }
        nums[index] = sum;
        int count = 0;
        for(long num : nums){
            if(count == n - 1){
                System.out.print(num);
            }else{
                System.out.print(num + " ");
            }
            count++;
        }
    }
}
