package JUC;

public class MyThread extends Thread{
    static int count = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (count < 1000) {
                    try {
                        Thread.sleep(300);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "正在售卖第" + count + "张票");
                    count++;
                } else {
                    break;
                }
            }
        }
    }
}
