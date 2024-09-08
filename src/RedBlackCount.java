import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedBlackCount {
    static class Node {
        int id;
        char color;
        List<Node> children;

        Node(int id, char color) {
            this.id = id;
            this.color = color;
            this.children = new ArrayList<>();
        }
    }

    static int redCount = 0;
    static int blackCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入节点数量和颜色字符串
        int n = scanner.nextInt();
        scanner.nextLine();
        String colors = scanner.nextLine().trim();

        // 创建节点数组并初始化节点颜色
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, colors.charAt(i - 1));
            if (colors.charAt(i - 1) == 'R') {
                redCount++;
            } else {
                blackCount++;
            }
        }

        // 构建树的边
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            nodes[u].children.add(nodes[v]);
        }

        scanner.close();

        dfs(nodes[1]);

        int result = redCount * blackCount - (n - 1);
        System.out.println(result);
    }

    static void dfs(Node node) {
        for (Node child : node.children) {
            if (child.color == 'R') {
                redCount++;
            } else {
                blackCount++;
            }
            dfs(child);
        }
    }
}
