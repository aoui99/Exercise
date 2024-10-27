import interfaces.A;

import java.util.*;

public class SF01 {
    static String indist = "indistinct";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str;
        for (int i = 0; i < n; i++) {
            str = in.next();
            System.out.println(modifyLineName(str));
        }
        in.close();
    }

    private static String modifyLineName(String str) {
        if (hasUpperCase(str) && !str.contains("_")) {
            StringBuilder newStr = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    newStr.append("_").append(Character.toLowerCase(c));
                } else {
                    newStr.append(c);
                }
            }
            String res = newStr.toString();
            return res.startsWith("_") ? indist : res;
        } else if (isUnderLineStyle(str)) {
            return str;
        } else {
            return indist;
        }

    }

    private static boolean isUnderLineStyle(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLowerCase(chars[i]) && chars[i] != '_') {
                return false;
            } else if (chars[i] == '_') {
                if (i == 0 || i == chars.length - 1) {
                    return false;
                }
                if (i >= 1 && i < chars.length - 1) {
                    if (!Character.isLowerCase(chars[i - 1]) || !Character.isLowerCase(chars[i + 1])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean hasUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}
