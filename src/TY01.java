import java.util.HashMap;
import java.util.Scanner;

public class TY01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('H', 1);
        map.put('S', 2);
        map.put('D', 3);
        map.put('C', 4);
        int head = 0;
        int end = s.length() - 1;
        int n = in.nextInt();
        int res = 0;
        while (n > 0 && head < end) {
            if (map.get(s.charAt(head)) > map.get(s.charAt(end))){
                res += map.get(s.charAt(head));
                head++;
            } else if (map.get(s.charAt(head)) < map.get(s.charAt(end))) {
                res += map.get(s.charAt(end));
                end--;
            } else {
                if (map.get(s.charAt(head + 1)) >= map.get(s.charAt(end - 1))) {
                    res += map.get(s.charAt(head));
                    head++;
                } else if (map.get(s.charAt(head + 1)) < map.get(s.charAt(end - 1))) {
                    res += map.get(s.charAt(end));
                    end--;
                }
            }
            n--;
        }
        System.out.println(res);
    }
}
