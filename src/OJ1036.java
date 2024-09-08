import java.util.Scanner;

public class OJ1036 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String t = in.nextLine();
            String palin = "";
            int n = 0;
            for (int i = 0; i < t.length(); i++) {
                label1:
                for (int j = 0; j < t.length() - i && j <= i; j++) {
                    int l;
                    if (j < t.length() - i - 1) {
                        palin = t.substring(i - j, i + j + 2);
                        l = palin.length();
                        for (int k = 0; 2 * k < l - 1; k++) {
                            if (!palin.substring(k, k + 1).equals(palin.substring(l - k - 1, l - k))) {
                                break label1;
                            }
                        }
                        n += 1;
                    }
                }
            }
            for (int i = 0; i < t.length(); i++) {
                label2:
                for (int j = 0; j < t.length() - i && j <= i; j++) {
                    int l;
                    if (j > 0) {
                        palin = t.substring(i - j, i + j + 1);
                        l = palin.length();
                        for (int k = 0; 2 * k < l - 1; k++) {
                            if (!palin.substring(k, k + 1).equals(palin.substring(l - k - 1, l - k))) {
                                break label2;
                            }
                        }
                        n += 1;
                    }
                }
            }
            System.out.println(n + t.length());
        }
    }
}
