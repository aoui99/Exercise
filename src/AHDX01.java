import java.util.*;

public class AHDX01 {
    public static void main(String[] args) {

    }
    public int attendmeetings (ArrayList<ArrayList<Integer>> meetings) {
        // write code here
        int res = 0;

        HashSet<Integer> visited = new HashSet<>();
        for (ArrayList<Integer> item : meetings) {
            int start = item.get(0);
            int end = item.get(1);
            if (!visited.contains(start) || !visited.contains(end)) {
                res++;
            }
        }
        Comparator<ArrayList<Integer>> c = (o1, o2) -> o1.get(0) - o2.get(0);
        Collections.sort(meetings, c);
        return res;
    }
}
