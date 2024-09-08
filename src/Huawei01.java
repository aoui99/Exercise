import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Huawei01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 卡牌数量
        scanner.nextLine();  // 读取换行符

        String[] cards = scanner.nextLine().split(" ");  // 输入的卡牌序列
        List<String> cardList = new ArrayList<>(Arrays.asList(cards));

        while (true) {
            boolean found = false;
            for (int i = 0; i < cardList.size() - 2; i++) {
                String card1 = cardList.get(i);
                String card2 = cardList.get(i + 1);
                String card3 = cardList.get(i + 2);
                if (card1.equals(card2) && card2.equals(card3)) {
                    found = true;
                    cardList.remove(i);
                    cardList.remove(i);
                    cardList.remove(i);
                    break;
                }
            }
            if (!found) {
                break;  // 没有连续三张相同牌号的卡牌，退出循环
            }
        }

        if (cardList.isEmpty()) {
            System.out.println("0");  // 没有剩余卡牌
        } else {
            StringBuilder result = new StringBuilder();
            for (String card : cardList) {
                result.append(card).append(" ");
            }
            System.out.println(result.toString().trim());  // 输出剩余的卡牌序列
        }
    }
}
