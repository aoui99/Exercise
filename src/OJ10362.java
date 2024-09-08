import java.util.Scanner;

public class OJ10362 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String t = in.nextLine();
            int n = 0;
            int len = t.length();

            // 单字符作为回文中心
            for (int i = 0; i < len; i++) {
                n++;
                int left = i - 1;
                int right = i + 1;

                // 扩展回文中心
                while (left >= 0 && right < len && t.charAt(left) == t.charAt(right)) {
                    n++;
                    left--;
                    right++;
                }
            }

            // 双字符作为回文中心
            for (int i = 0; i < len - 1; i++) {
                if (t.charAt(i) == t.charAt(i + 1)) {
                    n++;
                    int left = i - 1;
                    int right = i + 2;

                    // 扩展回文中心
                    while (left >= 0 && right < len && t.charAt(left) == t.charAt(right)) {
                        n++;
                        left--;
                        right++;
                    }
                }
            }
            System.out.println(n);
        }
    }
}
