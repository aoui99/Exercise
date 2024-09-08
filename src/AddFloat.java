import java.math.BigDecimal;
import java.util.Scanner;

public class AddFloat {
    public static void main(String[] args) {
        double a;
        double b;
        Scanner scanner = new Scanner(System.in);
        int sum_num = scanner.nextInt();
        for(int i=0; i<sum_num; i++){
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            System.out.println(add(a,b).stripTrailingZeros().toPlainString());
        }
    }

    public static BigDecimal add(double a, double b){
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        return b1.add(b2);
    }
}
