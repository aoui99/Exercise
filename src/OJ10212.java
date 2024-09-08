import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OJ10212 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        ArrayList<Integer> index = new ArrayList<>();
        String upper = "";
        String regex = "[a-zA-Z0-9]";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(text);
        while (m.find()) {
            upper += m.group().toUpperCase(Locale.ROOT);
            index.add(m.start());
        }
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < upper.length(); i++) {
            int j = 1;
            while (i - j >= 0 && i + j < upper.length() && upper.charAt(i - j) == upper.charAt(i + j)) {
                j++;
            }
            int length = 2 * j - 1;
            if (length > maxLength) {
                maxLength = length;
                start = i - j + 1;
                end = i + j - 1;
            }

            j = 0;
            while (i - j >= 0 && i + j + 1 < upper.length() && upper.charAt(i - j) == upper.charAt(i + j + 1)) {
                j++;
            }
            length = 2 * j;
            if (length > maxLength) {
                maxLength = length;
                start = i - j + 1;
                end = i + j;
            }
        }
        System.out.println(text.substring(index.get(start), index.get(end) + 1));
    }
}

