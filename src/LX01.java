import java.util.*;

public class LX01 {
    static int xFlag;
    static int yFlag;
    static int xSt, ySt, xEd, yEd;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] position = new int[n][2];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            position[i][0] = in.nextInt();
            position[i][1] = in.nextInt();
        }
        in.nextLine();
        xSt = in.nextInt();
        ySt = in.nextInt();
        xEd = in.nextInt();
        yEd = in.nextInt();

        xFlag = xSt - xEd == 0 ? 0 : (xSt - xEd > 0 ? 1 : -1);
        yFlag = ySt - yEd == 0 ? 0 : (ySt - yEd > 0 ? 1 : -1);
        for (int i = 0; i < n; i++) {
            int x, y;
            x = position[i][0];
            y = position[i][1];

        }
    }

    private static boolean isOnline(int x, int y) {
        int a1 = xEd - xSt;
        int b1 = yEd - ySt;
        int a2 = x - xSt;
        int b2 = y - y;


        return false;
    }
}
