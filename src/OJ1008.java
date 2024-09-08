import java.util.Scanner;

public class OJ1008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        int k = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                matrix[j][i] = k;
                k++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if(j!=N-1){
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
