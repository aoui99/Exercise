import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TestSimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);
        System.out.println(sdf.format(time));
        time += 2 * 1000;
        Date d2 = new Date();
        d2.setTime(time);
        System.out.println(d2);


        System.out.println("---------------------------");

        Date d3 = new Date();
        System.out.println(sdf.format(time));
        System.out.println("---------------------------");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dStr = "2022-12-12 12:12:11";
        Date d4 = sdf2.parse(dStr);
        System.out.println(d4);

    }
}
