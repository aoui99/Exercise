import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DoubleColorBall {
    public static void main(String[] args) {
        int cost = 0;
        ArrayList<Integer> earnNumbers = new ArrayList<>();
        int earn = 0;
        int count = 0;
        while (true) {
            cost += 2;

            int[] userNumbers = userSelectNumber();
            System.out.println("您投注的号码：");
            printArray(userNumbers);

            int[] luckNumbers = createLuckNumber();
            System.out.println("中奖的号码：");
            printArray(luckNumbers);

            earn = judge(userNumbers, luckNumbers);
            if (earn!=0) {
                count++;
                earnNumbers.add(earn);
            }
            System.out.println("您已经花费：" + cost + "元");
            System.out.println("您已经中奖" + count + "次");
            System.out.println("您中奖金额分别为：" + earnNumbers.toString() + "元");
            System.out.println("---------------------------------");
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static int[] userSelectNumber() {
        int[] numbers = new int[7];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numbers.length - 1; i++) {
            //i = 0 1 2 3 4 5

            while (true) {
                System.out.println("请您输入第" + (i + 1) + "个红球号码（1-33之间，不能重复）：");
                int number = sc.nextInt();

                if (number < 1 || number > 33) {
                    System.out.println("对不起，您输入的红球号码不在1-33之间，请确认！");
                } else {
                    if (exist(numbers, number)) {
                        System.out.println("对不起，您当前输入的红球号码前面选择过，重复了，请确认！");
                    } else {
                        numbers[i] = number;
                        break;
                    }
                }
            }
        }

        while (true) {
            System.out.println("请您输入最后一个蓝球号码（1-16）：");
            int number = sc.nextInt();
            if (number < 1 || number > 16) {
                System.out.println("对不起，您输入的蓝球号码范围不对！");
            } else {
                numbers[6] = number;
                break;
            }
        }

        return numbers;
    }

    private static boolean exist(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static int[] createLuckNumber() {
        int[] numbers = new int[7];

        Random r = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                int number = r.nextInt(33) + 1;

                if (!exist(numbers, number)) {
                    numbers[i] = number;
                    break;
                }
            }
        }
        numbers[6] = r.nextInt(16) + 1;
        return numbers;
    }

    public static int judge(int[] userNumbers, int[] luckNumbers) {
        //userNumbers = [12,14,16,18,23,26,8]
        //luckNumbers = [16,17,18,19,26,32,8]

        int redCount = 0;
        int blueCount = 0;

        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < luckNumbers.length - 1; j++) {
                if (userNumbers[i] == luckNumbers[j]) {
                    redCount++;
                    break;
                }
            }
        }

        blueCount = userNumbers[6] == luckNumbers[6] ? 1 : 0;

        System.out.println("您命中的红球数量是：" + redCount);
        System.out.println("您命中的蓝球数量是：" + blueCount);

        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜你，中奖1000万，可以开始享受人生了~~~");
            return 10000000;
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("恭喜您，中奖500万，可以稍微开始享受人生了~~~");
            return 5000000;
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜您，中奖3000元，可以出去吃顿大餐了~");
            return 3000;
        } else if (redCount == 5 && blueCount == 0 || redCount == 4 && blueCount == 1) {
            System.out.println("恭喜您，中了小奖，200元~");
            return 200;
        } else if (redCount == 4 && blueCount == 0 || redCount == 3 && blueCount == 1) {
            System.out.println("中了10元~");
            return 10;
        } else if (redCount < 3 && blueCount == 1) {
            System.out.println("中了5元~");
            return 5;
        } else {
            System.out.println("感谢您对福利事业做出的巨大贡献~~~");
            return 0;
        }
    }
}
