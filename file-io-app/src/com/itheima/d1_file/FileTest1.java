package com.itheima.d1_file;

import java.io.File;

public class FileTest1 {
    public static void main(String[] args) {
        //File f1 = new File("D:/JavaProjects/Exercise/morse.txt");
        File f1 = new File("D:"+ File.separator + "JavaProjects" + File.separator +
                "Exercise" + File.separator + "morse.txt");
        File f2 = new File("D:/");
        File[] list = f2.listFiles();
        for (File file : list) {
            System.out.println(file.getAbsoluteFile());
        }

    }
}
