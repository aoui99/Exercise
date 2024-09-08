import java.io.FileOutputStream;
import java.io.IOException;

public class TestBit {
    public static void main(String[] args) {
        try {
            BitOutputStream bos = new BitOutputStream(new FileOutputStream("output.txt"));

            //bitOutputStream.writeBit('0');
            //bitOutputStream.writeBit('1');
            //bitOutputStream.writeBit("0101");
            for(int i=0; i < 10; i ++) { //01010101 01010101 01010000也即'UUP'
                bos.writeBit('0');
                bos.writeBit('1');
            }
            //bos.writeBit("01010101010101011"); // 追加在UUP后面，输出应为 'UUUUX'

            //bitOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

