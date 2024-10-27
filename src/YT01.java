import java.util.*;
public class YT01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        String[] list = s1.split("");
        int res = 0;
        while(in.hasNext()) {
            int a = in.nextInt();
            list[a-1] = "";
            String temp = "";
            for (String s : list) {
                temp += s;
            }
            if (!check(temp, s2)) {
                break;
            } else {
                res++;
            }
        }
        System.out.println(res);
    }
    private static boolean check(String s1, String s2){
        for (char c : s2.toCharArray()) {
            int index = s1.indexOf(c);
            if (index == -1) {
                return false;
            }
            StringBuilder sb = new StringBuilder(s1);
            sb.replace(0, index + 1, "");
            s1 = sb.toString();
        }
        return true;
    }
}
