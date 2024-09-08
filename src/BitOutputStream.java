import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BitOutputStream extends FilterOutputStream {

    private int currentByte;
    //比特数
    private int numBitsFilled;

    public BitOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.currentByte = 0;
        this.numBitsFilled = 0;
    }

    public void writeBit(char bit) throws IOException {
        if (bit != '0' && bit != '1') {
            throw new IllegalArgumentException("Invalid bit: " + bit);
        }

        currentByte = (currentByte << 1) | (bit - '0');
        numBitsFilled++;

        if (numBitsFilled == 8) {
            write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
    }

    public void writeBit(String bits) throws IOException {
        for (int i = 0; i < bits.length(); i++) {
            writeBit(bits.charAt(i));
        }
    }

    @Override
    public void close() throws IOException {
        while (numBitsFilled != 0) {
            writeBit('0');
        }

        super.close();
    }
}



