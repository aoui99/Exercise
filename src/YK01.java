import java.util.Scanner;

public class YK01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] A = new int[n];

        // 读取序列
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // 计算初始的交替和
        int initialSum = calculateSum(A);

        int maxSum = initialSum;

        // 尝试每一对元素的交换
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 计算交换后的交替和
                int newSum = initialSum;

                if (i % 2 == 0) { // i是奇数位置
                    newSum -= A[i];
                    newSum += A[j];
                } else { // i是偶数位置
                    newSum += A[i];
                    newSum -= A[j];
                }

                if (j % 2 == 0) { // j是奇数位置
                    newSum -= A[j];
                    newSum += A[i];
                } else { // j是偶数位置
                    newSum += A[j];
                    newSum -= A[i];
                }

                // 更新最大和
                maxSum = Math.max(maxSum, newSum);
            }
        }

        // 输出结果
        System.out.println(maxSum);

        scanner.close();
    }

    // 计算初始的交替和
    private static int calculateSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                sum += A[i];
            } else {
                sum -= A[i];
            }
        }
        return sum;
    }
}

