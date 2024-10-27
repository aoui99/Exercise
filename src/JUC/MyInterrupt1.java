package JUC;

import java.sql.Time;

public class MyInterrupt1 extends Thread{
    volatile boolean flag = false;

    @Override
    public void run(){
        while (!flag) {
            System.out.println("MyThread...run...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
//        MyInterrupt1 t1 = new MyInterrupt1();
//        t1.start();
//
//        Thread.sleep(6000);
//
//        t1.flag = true;

        String s1 = "akkkk";
        String s2 = new String("akkkk");
        String s3 = "akkkk";

        Integer a1 = 1000;
        Integer a2 = Integer.valueOf(1000);
        System.out.println(a1 == a2);
    }

}
