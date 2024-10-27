import java.util.*;
public class XC03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arrays = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arrays[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int op = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int res;
            if (op == 1){
                boolean flag = true;
                res = arrays[l];
                for (int j = l + 1; j <= r; j++) {
                    if (flag) {
                        res = res & arrays[j];
                        flag = ! flag;
                    } else {
                        res = res | arrays[j];
                        flag = ! flag;
                    }
                }
            } else {
                boolean flag = false;
                res = arrays[l];
                for (int j = l + 1; j <= r; j++) {
                    if (flag) {
                        res = res & arrays[j];
                        flag = ! flag;
                    } else {
                        res = res | arrays[j];
                        flag = ! flag;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
