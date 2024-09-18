import java.util.Scanner;
public class MTQZ03 {
    private static int[] Next;
    private static int[] values;
    private static long[] coins;
    private static boolean[] visited;
    private static int x, y;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        Next = new int[n + 1];
        values = new int[n + 1];
        coins = new long[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            Next[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            values[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        for (int i = 0; i < q; i++) {
            int u = in.nextInt();
            int k = in.nextInt();
            System.out.println(getMaxCoins(u, k));
        }
        in.close();
    }

    private static long getMaxCoins(int u, int k) {
        long maxCoins = 0;
        while (k-- > 0 && coins[u] >= 0) {
            maxCoins += coins[u];
            u = Next[u];
        }
        return maxCoins;
    }

    private static void dfs(int node) {
        visited[node] = true;
        int nextNode = Next[node];
        int coinValue = (values[nextNode] > values[node]) ? x : y;
        if(!visited[nextNode]) {
            dfs(nextNode);
        }
        coins[node] = coinValue + (coins[nextNode] < 0 ? 0 : coins[nextNode]);
    }


}
