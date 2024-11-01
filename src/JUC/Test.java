package JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public volatile static Integer inc = 0;

    public void increase() {
        inc++;
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Test volatileAtomicityDemo = new Test();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
