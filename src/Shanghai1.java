import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shanghai1 {
    public static void main(String[] args) {
        String mainstr = "12323454556767";
        String substr = "23?45?67";

        int count = countMatches(mainstr, substr);
        System.out.println("匹配次数: " + count);
    }

    public static int countMatches(String mainStr, String subStr) {
        // 分解子字符串，将通配符分开
        String[] parts = subStr.split("\\?");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

        int count = 0;

        // 遍历主字符串，寻找匹配的子字符串
        for (int i = 0; i <= mainStr.length() - part1.length(); i++) {
            if (mainStr.startsWith(part1, i)) {
                for (int j = i + part1.length(); j <= mainStr.length() - part2.length(); j++) {
                    if (mainStr.startsWith(part2, j)) {
                        for (int k = j + part2.length(); k <= mainStr.length() - part3.length(); k++) {
                            if (mainStr.startsWith(part3, k)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
