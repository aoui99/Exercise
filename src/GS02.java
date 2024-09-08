import java.util.*;
import java.util.Scanner;

public class GS02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            numbers.add(scanner.nextInt());
        }
        scanner.close();

        int[] bins = new int[3];  // 用于存放每个箱子的元素个数
        for (int num : numbers) {
            if (num >= 0 && num < 33) {
                bins[0]++;
            } else if (num >= 33 && num < 66) {
                bins[1]++;
            } else if (num >= 66 && num <= 100) {
                bins[2]++;
            }
        }

        // 输出每个箱子的元素个数
        System.out.println("箱子1：" + bins[0] + "个元素");
        System.out.println("箱子2：" + bins[1] + "个元素");
        System.out.println("箱子3：" + bins[2] + "个元素");

        // 找出元素最多的箱子编号
        int maxCount = Integer.MIN_VALUE;
        int maxBin = -1;
        for (int i = 0; i < 3; i++) {
            if (bins[i] > maxCount) {
                maxCount = bins[i];
                maxBin = i + 1;  // 箱子编号从1开始
            }
        }
        System.out.println("含有元素最多的箱子编号为：" + maxBin);
    }
}
