package Time;

import javax.xml.stream.events.DTD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        String start = "2023年11月11日 0:0:0";
        String end = "2023年11月11日 0:10:0";
        String t1 = "2023年11月11日 0:01:18";
        String t2 = "2023年11月11日 0:10:57";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date startDt = sdf.parse(start);
        Date endDt = sdf.parse(end);
        Date xjDt = sdf.parse(t1);
        Date xpDt = sdf.parse(t1);

        long startTime = startDt.getTime();



    }
}
