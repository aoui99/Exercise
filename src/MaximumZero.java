import java.util.Arrays;
import java.util.Scanner;

public class MaximumZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取n和k
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // 读取数组
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(scanner.nextInt());
        }

        // 对数组按照绝对值从小到大排序，如果绝对值相同，则按原值降序排序
        Arrays.sort(arr);

        // 调用函数并输出结果
        System.out.println(maxZeros(arr, k));

        scanner.close();
    }

    private static int maxZeros(int[] arr, int k) {
        int zeros = 0; // 记录0的数量
        int remainingOps = k; // 剩余的操作次数

        for (int i = 0; i < arr.length && remainingOps >= 0; i++) {
            // 如果当前元素变为0所需的操作次数小于等于剩余操作次数，则进行操作
            if (arr[i] <= remainingOps) {
                zeros++;
                remainingOps -= arr[i];
            } else {
                // 如果不能变为0，则剩余操作次数减为0，结束循环
                remainingOps = 0;
            }
        }

        return zeros;
    }
}
