import java.util.*;
public class YDHY {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String s = String.valueOf(n);
        int len = s.length();
        int index = 0;
        boolean isIncrease = true;
        for (int i = 0; i < len - 1; i++) {
            index = i;
            if (s.charAt(i) > s.charAt(i + 1)) {
                isIncrease = false;
                break;
            }
        }
        if (isIncrease) {
            System.out.println(n);
        }else {
            for (int i = index; i > 0; i--) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    index--;
                }else {
                    break;
                }
            }
            String increasePart = "";
            if (index > 0) {
                increasePart = s.substring(0, index);
                increasePart += s.charAt(index) - 1 - '0';
            } else {
                if (s.charAt(0) != '1') {
                    increasePart += s.charAt(index) - 1 - '0';
                }
            }
            for (int i = index + 1; i < len; i++) {
                increasePart = increasePart + "9";
            }
            System.out.println(increasePart);
        }
    }
}
