import java.util.HashMap;
import java.util.Scanner;

public class ZXXY02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();

        HashMap<Character, Character> map = new HashMap<>();

        map.put('A', 'a');
        map.put('E', 'e');
        map.put('I', 'i');
        map.put('O', 'o');
        map.put('U', 'u');
        map.put('a', 'a');
        map.put('e', 'e');
        map.put('i', 'i');
        map.put('o', 'o');
        map.put('u', 'u');

        for (char c : text.toCharArray()){
            if (map.keySet().contains(c)) {
                System.out.print(map.get(c));
            } else {
                if (!Character.isUpperCase(c)) {
                    System.out.print(Character.toUpperCase(c));
                }else {
                    System.out.print(c);
                }


            }
        }
    }
}
