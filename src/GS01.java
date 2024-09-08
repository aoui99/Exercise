public class GS01 {
    public static String overlapTime(int hour) {
        // 计算时针和分针在 time 时刻的角度
        double hourAngle = (hour % 12) * 30 + 30.0 / 60;  // 时针每小时转动 30°，每分钟转动 0.5°
        double minuteAngle = (hour % 60) * 6 + 6.0 / 60;  // 分针每分钟转动 6°

        // 计算时针和分针在 time+1 时刻的角度
        double nextHourAngle = ((hour + 1) % 12) * 30 + 30.0 / 60;
        double nextMinuteAngle = ((hour + 1) % 60) * 6 + 6.0 / 60;

        // 线性插值计算重合时刻的角度
        double overlapAngle = hourAngle + (nextHourAngle - hourAngle) * (30 - hourAngle) / (nextHourAngle - hourAngle - nextMinuteAngle + minuteAngle);

        // 计算重合时刻的小时和分钟
        int overlapHour = (int) (overlapAngle / 30);
        int overlapMinute = (int) ((overlapAngle % 30) * 2);

        return String.format("%02d:%02d", overlapHour, overlapMinute);
    }

    public static void main(String[] args) {
        // 输入时刻 time（0-23）
        int time = 2;
        String overlap = overlapTime(time);
        System.out.println("时针和分针重合的时刻为 " + overlap);
    }
}
