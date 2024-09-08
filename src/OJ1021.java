import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OJ1021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        int start = 0;
        int end = 0;
        ArrayList<Integer> index = new ArrayList<>();
        String upper = "";
        String regex = "[a-zA-Z0-9]";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(text);
        while (m.find()) {
            upper += m.group().toUpperCase(Locale.ROOT);
            index.add(m.start());
        }
        int max = 0;
        String palin = "";
        for (int i = 0; i < upper.length(); i++) {
            for (int j = 0; j < upper.length() - i && j <= i; j++) {
                int ok = 1;
                int l = 0;
                if (j < upper.length() - i - 1){
                    palin = upper.substring(i - j, i + j + 2);
                    l = palin.length();
                    if(l >= max){
                        for (int k = 0; 2 * k < l - 1; k++) {
                            if ( !palin.substring(k, k + 1) .equals(palin.substring(l - k - 1, l - k)) ) {
                                ok = 0;
                            }
                        }
                        if (ok == 1) {
                            max = l;
                            start = i - j;
                            end = i + j + 1;
                        }
                    }
                }
                ok = 1;
                palin = upper.substring(i - j, i + j + 1);
                l = palin.length();
                if (l > max){
                    for (int k = 0; 2 * k < l - 1; k++) {
                        if ( !palin.substring(k, k + 1) .equals(palin.substring(l - k - 1, l - k)) ) {
                            ok = 0;
                        }
                    }
                    if (ok == 1) {
                        max = l;
                        start = i - j;
                        end = i + j ;
                    }
                }
            }
        }
        System.out.println(text.substring(index.get(start), index.get(end)+1));
    }
}
