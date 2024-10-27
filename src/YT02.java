import interfaces.A;

import java.util.*;
public class YT02 {
    private static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ArrayList<ArrayList<Integer>> cargos = new ArrayList<>();
        while (in.hasNext()){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(in.nextInt());
            list.add(in.nextInt());
            list.add(in.nextInt());
            cargos.add(list);
        }

        System.out.println(getMaxReward(cargos));
    }

    private static int getMaxReward(ArrayList<ArrayList<Integer>> cargos){
        int[] dp = new int[cargos.size() + 1];
        for (ArrayList<Integer> cargo : cargos){
            int start = cargo.get(0);
            int end = cargo.get(1);
            int extra = cargo.get(2);
            for(int j = start; j <= end; j++) {
                dp[j] = Math.max(dp[j], dp[start - 1] + end - start + extra);
            }
        }
        int maxReward = 0;
        for (int reward : dp){
            maxReward = Math.max(maxReward, reward);
        }

        return maxReward;
    }

}
