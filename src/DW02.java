import java.util.*;

public class DW02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<ArrayList> allNum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j = 0; j < 4; j++){
                nums.add(in.nextInt());
            }
            allNum.add(nums);

        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> nums = allNum.get(i);
            nums.sort((o1, o2) -> o1 - o2);
            if (nums.get(0) < 2) {
                result[i] = -1;
                continue;
            }
            for (int j = 2; j <= nums.get(0); j++){
                for (int k = 0; k < 4; k++){
                    if (nums.get(k) % j != 0) {
                        result[i] = -1;
                        break;
                    }
                    if (k == 3) {
                        result[i] = j;
                    }
                }
                if (result[i] != -1) {
                    break;
                }
            }
        }
        for(int x : result){
            System.out.println(x);
        }
    }
}
