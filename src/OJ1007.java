import java.util.Scanner;

public class OJ1007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] circle = new int[N];
        for (int i = 0; i < N; i++) {
            circle[i] = i + 1;
        }
        //设置起始下标
        int k = 0;
        while (N > 1) {
            k = (k + M - 1) % N;
            for (int j = k + 1; j < N; j++) {
                circle[j - 1] = circle[j];
            }
            N--;
            if (k == N) {
                k = 0;
            }
        }
        System.out.println(circle[k]);
    }
}
