import java.math.BigDecimal;
import java.util.Scanner;

public class OJ1035 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] dList = new String[t];
        int[] nList = new int[t];
        for (int i = 0; i < t; i++) {
            dList[i] = in.next();
            nList[i] = in.nextInt();
        }
        for (int j = 0; j < t; j++) {
            String str = dList[j];
            if (str.charAt(str.length() - 1) == '.') {
                str += "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            bigDecimal = bigDecimal.setScale(10, BigDecimal.ROUND_UP);
            bigDecimal = bigDecimal.remainder(BigDecimal.ONE);
            String out = bigDecimal.toPlainString();
            System.out.println(out.charAt(nList[j]+1));
        }
    }
}
