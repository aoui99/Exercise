import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SXF03 {
    private static final int[] DIRECTIONS = {0, 1, 0, -1, 0}; // 方向数组，用于简化上下左右的移动

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> inputLines = new ArrayList<>();
        while (in.hasNextLine() && inputLines.size() < 100) {
            String line = in.nextLine().trim();
            // 如果输入为空行，认为输入结束
            if (line.isEmpty()) {
                break;
            }
            inputLines.add(line);
        }
        in.close();
        in.close();
        int[][] grid = convertToGrid(inputLines);
        System.out.println(maxGold(grid)); // 输出结果
    }

    private static int[][] convertToGrid(List<String> inputLines) {
        int[][] grid = new int[inputLines.size()][];
        for (int i = 0; i < inputLines.size(); i++) {
            String line = inputLines.get(i).replaceAll("[\\[\\]]", ""); // 移除方括号
            String[] numbers = line.split(",\\s*"); // 根据逗号分割字符串
            grid[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                grid[i][j] = Integer.parseInt(numbers[j]); // 转换为整数
            }
        }
        return grid;
    }

    public static int maxGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return dfs(grid, 0, 0, m, n, false); // 从(0,0)开始搜索，初始时没有使用特殊技能
    }

    private static int dfs(int[][] grid, int i, int j, int m, int n, boolean usedSkill) {
        // 如果超出边界或者遇到已经访问过的单元格，直接返回0
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        // 如果遇到不可到达区域，检查是否使用过特殊技能
        if (grid[i][j] == -1) {
            if (usedSkill) { // 如果已经使用过技能，则不能再次通过
                return 0;
            } else { // 尝试使用技能
                usedSkill = true;
                grid[i][j] = 0; // 将不可到达区域变为可达
            }
        }

        int gold = grid[i][j]; // 收集当前单元格的金币
        grid[i][j] = 0; // 标记当前单元格已访问

        int maxGold = 0;
        // 深度优先搜索四个方向
        for (int k = 0; k < 4; k++) {
            int nextI = i + DIRECTIONS[k];
            int nextJ = j + DIRECTIONS[k + 1];
            maxGold = Math.max(maxGold, dfs(grid, nextI, nextJ, m, n, usedSkill));
        }

        grid[i][j] = gold; // 恢复当前单元格的金币数量，以便回溯
        return gold + maxGold; // 返回当前单元格的金币加上四个方向上能收集到的最大金币数
    }
}
