import java.util.Scanner;

public class OJ1017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            System.out.print(n + "=");
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0){
                    while(n % i == 0){
                        int t = n / i;
                        if(t == 1){
                            System.out.println(i);
                        }else{
                            System.out.print(i + "*");
                        }
                        n /= i;
                    }
                }
            }
            if(n != 1){
                System.out.println(n);
            }
        }
    }
}