import java.time.LocalDateTime;

public class Qax1 {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int doubleNumber = DoubleNumber(100000000L);
        Long end = System.currentTimeMillis();
        System.out.println(doubleNumber);
        System.out.println(end - start);
    }

    public static int DoubleNumber (long n) {
        int count = 0;
        long i = 1;

//        int leng = 1;
        // write code here
        while (i < n) {
            String numStr = String.valueOf(i);
            int len = numStr.length();
//            if(len > leng ){
//                leng++;
//            }
            long a = 1;
            for(int j = 0; j < len / 2 ; j ++){
                a *= 10L;
            }
            long b = 1;
            for(int j = 0; j < len ; j ++){
                b *= 10L;
            }
            if (len % 2 != 0) {
                i = b;
                continue;
            }
            long former = i / a;
            if (former == i - former * a) {
                count++;
                i += a;
            }else{
                i++;
            }

        }
        return count;
    }
}
