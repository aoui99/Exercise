import java.util.HashSet;

public class LC202 {
    public static void main(String[] args) {
        boolean happy = isHappy(19);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int temp = calculate(n);
        while(!set.contains(calculate(temp))){
            temp = calculate(temp);
            if(temp == 1){
                return true;
            }
            set.add(temp);
        }
        return false;
    }
    public static int calculate(int n){
        String t = String.valueOf(n);
        int res = 0, m;
        for(int i = 0; i < t.length(); i++){
            m = Integer.valueOf(t.charAt(i) - 48);
            res += Math.pow(m, 2);
        }
        return res;
    }
}
