import java.util.HashSet;
import java.util.Scanner;

public class DD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        System.out.println(minModify(s));
    }

    private static int minModify(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (s.charAt(i) == s.charAt(i - 1) ){
                count++;
                i++;
            }
        }
        return count;
    }

}
