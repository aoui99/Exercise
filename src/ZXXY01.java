import java.util.*;
public class ZXXY01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                map.put(c, map.get(c) + 1);
            }else {
                map.putIfAbsent(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                System.out.print(entry.getKey());
            }
        }
    }
}
