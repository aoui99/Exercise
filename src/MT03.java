import java.util.*;

public class MT03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Set<String> simple = findSymple(s);
        System.out.println(simple.size());
    }

    public static Set<String> findSymple(String s){
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] isVowel = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            isVowel[i] = "aeiou".indexOf(s.charAt(i)) >= 0;
        }
        for(int i=0; i < s.length(); i++){
            if(!isVowel[i]){
                for(int j = i + 1; j < s.length(); j++){
                    if(!isVowel[j]){
                        sb.setLength(0);
                        sb.append(s.charAt(i)).append(s.charAt(j));
                        result.add(sb.toString());
                        for(int k = j + 1; k < s.length(); k++){
                            if(!isVowel[k]){
                                sb.setLength(2);
                                sb.append(s.charAt(k));
                                result.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
