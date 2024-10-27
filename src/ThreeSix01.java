import java.util.*;

public class ThreeSix01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] orders = new int[n][2];
        HashMap<Integer, Integer> drinkCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            orders[i][0] = in.nextInt();
            drinkCount.put(orders[i][0], drinkCount.getOrDefault(orders[i][0], 0) + 1);
            orders[i][1] = in.nextInt();
            drinkCount.put(orders[i][1], drinkCount.getOrDefault(orders[i][1], 0) + 1);

        }

        Arrays.sort(orders, (a, b) -> {
            int popularityA = drinkCount.get(a[0]) + drinkCount.get(a[1]);
            int popularityB = drinkCount.get(b[0]) + drinkCount.get(b[1]);
            return popularityA - popularityB;
        });

        Set<Integer> usedDrinks = new HashSet<>();
        int satisfied = 0;

        for (int[] order:orders) {
            if (!usedDrinks.contains(order[0]) && !usedDrinks.contains(order[1])){
                usedDrinks.add(order[0]);
                usedDrinks.add(order[1]);
                satisfied++;
            }
        }
        System.out.println(satisfied);
    }
}
