import java.util.*;
public class MT02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> eleCounts = new HashMap<>();
        for(int i = 0; i < n; i++){
            int ele = in.nextInt();
            eleCounts.put(ele, eleCounts.getOrDefault(ele, 0) + 1);
        }
        int order = isPerfectSet(eleCounts, n);
        System.out.println(order);

    }
    public static int isPerfectSet(Map<Integer, Integer> eleCounts, int n){
        int[] countOcc = new int[eleCounts.size() + 1];
        for(int count : eleCounts.values()){
            if(count > eleCounts.size()){
                return -1;
            }
            countOcc[count]++;
        }
        for(int i = 1; i< countOcc.length; i++){
            if(countOcc[i] != 1){
                return -1;
            }
        }

        int k = 1;
        while(k*(k+1)/2 < n){
            k++;
        }
        return k*(k+1)/2 == n ? k : -1;
    }
}
