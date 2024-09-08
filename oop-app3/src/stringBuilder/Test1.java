package stringBuilder;

import java.util.StringJoiner;

public class Test1 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("itheima");
        s.append(1313).append("黑马");
        System.out.println(s);
        StringJoiner s1 = new StringJoiner(", ","[","]");
        s1.add("safafafa");
        s1.add("afaf");
        s1.add("434676");
        System.out.println(s1);

    }
}
