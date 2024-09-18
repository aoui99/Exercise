import java.util.ArrayList;
import java.util.Scanner;

public class MTQZ01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        int[] results = findMinimumTimeToWin(t);
        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                System.out.println(results[i] + " ");
            }else {
                System.out.println(results[i]);
            }

        }
    }
    public static int[] findMinimumTimeToWin(String s) {
        int[] positions = new int[3];
        int[] results = new int[3];
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)) {
                case 'R':
                    positions[0] = i;
                    results[0] = -1;
                    break;
                case 'B':
                    positions[1] = i;
                    results[1] = -1;
                    break;
                case 'G':
                    positions[2] = i;
                    results[2] = -1;
                    break;
            }
        }

        for (int i = 0; i < 3; i++) {
            int seekPos = positions[i];
            int minTime = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int time = calculateTime(s, seekPos, positions[j]);
                    if (time!=-1){
                        minTime = Math.min(minTime, time);
                    }
                }
            }
            results[i] = (minTime == Integer.MAX_VALUE) ? -1 : minTime;
        }
        return results;
    }

    private static int calculateTime(String s, int seekPos, int hiderPos) {
        int time = 0;
        int direction = (seekPos < hiderPos) ? 1 : -1;
        while (seekPos != hiderPos) {
            seekPos += direction;
            if (seekPos >= 0 && seekPos < s.length() && s.charAt(seekPos) != '#') {
                time++;
            }else {
                return -1;
            }
        }
        return time;
    }
}
