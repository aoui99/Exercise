import java.time.LocalDate;
import java.util.Scanner;

public class OJ1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String day1 = in.nextLine();
            String day2 = in.nextLine();
            int[] dayList1 = new int[3];
            int[] dayList2 = new int[3];
            dayList1[0] = Integer.valueOf(day1.substring(0, 4));
            dayList2[0] = Integer.valueOf(day2.substring(0, 4));
            dayList1[1] = Integer.valueOf(day1.substring(4, 6));
            dayList2[1] = Integer.valueOf(day2.substring(4, 6));
            dayList1[2] = Integer.valueOf(day1.substring(6));
            dayList2[2] = Integer.valueOf(day2.substring(6));
            LocalDate start = LocalDate.of(dayList1[0], dayList1[1], dayList1[2]);
            LocalDate end = LocalDate.of(dayList2[0], dayList2[1], dayList2[2]);
            long days = Math.abs(start.toEpochDay() - end.toEpochDay()) + 1;
            System.out.println(days);
        }
        in.close();
    }
}
