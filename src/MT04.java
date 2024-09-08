import java.util.*;

public class MT04 {
    static List<List<Integer>> tree;
    static boolean[] isRed;
    static int[] redCount;
    static int[] f;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new ArrayList<>();
        isRed = new boolean[n];
        redCount = new int[n];
        f = new int[n];
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }
        String colors = in.next();
        for(int i = 0; i < n; i++){
            isRed[i] = colors.charAt(i) == 'R';

        }
        for(int i = 1; i < n; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dfs(0, -1);
        calF(0, -1, 0);
        for(int i = 0; i < n; i++){
            System.out.print(f[i]);
        }


    }

    private static void dfs(int node, int parent){
        redCount[node] = isRed[node] ? 1: 0;
        for(int child : tree.get(node)){
            if(child != parent){
                dfs(child, node);
                redCount[node] += redCount[child];
            }
        }
    }

    private static void calF(int node, int parent, int redAbove){
        int totalReds = redAbove + redCount[node];
        f[node] = totalReds;
        for(int child : tree.get(node)){
            if(child!= parent){
                calF(child, node, totalReds - redCount[child]);
            }
        }
    }
}
