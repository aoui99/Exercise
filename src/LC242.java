import java.util.HashMap;

public class LC242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int count1=0, count2=0;
        for(int i = 0; i < s.length(); i++){
            String key1 = s.substring(i, i + 1);
            if(map1.containsKey(key1)){
                count1 = map1.get(key1) + 1;
                map1.replace(key1, count1);
            }else{
                map1.put(key1, 1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            String key2 = t.substring(i, i + 1);
            if(map2.containsKey(key2)){
                count2 = map2.get(key2) + 1;
                map2.replace(key2, count2);
            }else{
                map2.put(key2, 1);
            }
        }

        for(String i : map1.keySet()){
            if(!map2.containsKey(i)){
                return false;
            }
            int val1 = map1.get(i);
            int val2 = map2.get(i);
            if(val1 != val2){
                return false;
            }
        }
        for(String i : map2.keySet()){
            if(!map1.containsKey(i)){
                return false;
            }
            int val1 = map1.get(i);
            int val2 = map2.get(i);
            if(val1 != val2){
                return false;
            }
        }
        return true;
    }
}
