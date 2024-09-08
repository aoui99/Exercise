package com.itheima.d4_byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamTest1 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("file-io-app\\src\\test1.txt");
        int a = is.read();
        System.out.println((char)a);
        is.close();

    }
}
