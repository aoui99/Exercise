import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DW01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> triangle = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            triangle.add(in.nextInt());
        }
        int q = in.nextInt();
        List<ArrayList> allTrg = new ArrayList<>();
        for (int i = 0; i < q; i++){
            ArrayList<Integer> trg = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                trg.add(in.nextInt());
            }
            allTrg.add(trg);
        }
        for(int i = 0; i < q; i++){
            checkSimilar(triangle, allTrg.get(i));
        }
    }

    public static void checkSimilar(List<Integer> sourceList, List<Integer> targetList){
        boolean isTrg = checkTriangle(targetList);
        if (!isTrg) {
            System.out.println("Cannot form a triangle");
            return;
        }
        sourceList.sort((o1, o2) -> o1 -o2);
        targetList.sort(((o1, o2) -> o1 -o2));
        ArrayList<BigDecimal> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BigDecimal x = new BigDecimal(sourceList.get(i));
            BigDecimal y = new BigDecimal(targetList.get(i));
            list.add(x.divide(y, 20, RoundingMode.CEILING));
        }
        if (list.get(0).equals(list.get(1)) && list.get(1).equals(list.get(2))) {
            System.out.println("similar");
        } else {
            System.out.println("Can form a triangle but not similar");
        }
    }

    public static boolean checkTriangle(List<Integer> trg){
        if (trg.get(0) >= trg.get(1) + trg.get(2)) {
            return false;
        }
        if (trg.get(1) >= trg.get(0) + trg.get(2)) {
            return false;
        }
        if (trg.get(2) >= trg.get(0) + trg.get(1)) {
            return false;
        }
        return true;
    }
}
