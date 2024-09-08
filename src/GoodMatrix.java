import java.util.Scanner;

public class GoodMatrix {
    public static boolean isGoodMatrix(int[][] matrix, int i, int j) {
        // 检查一个2*2的子矩阵是否是好矩阵
        int target = matrix[i][j];
        return matrix[i][j+1] == target && matrix[i+1][j] == target && matrix[i+1][j+1] == target;
    }

//    public static int countGoodMatrices(int[][] matrix, int n, int m) {
//        int count = 0;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < m - 1; j++) {
//                if (isGoodMatrix(matrix, i, j)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 行数
        int m = scanner.nextInt(); // 列数

        // 读取矩阵
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (isGoodMatrix(matrix, i, j)) {
                    count++;
                }
            }
        }
        // 计算好矩阵的数量
        //int result = countGoodMatrices(matrix, n, m);
        System.out.println(count);
    }
}
