package base.JavaThread.Javier_Fernández_González.chapter2.lockCase;

/**
 * Description: 提现 lock 锁策略的特点- 等待时间最长的线程将获得锁-
 * GET-version:
 * Date:2020-05-15  12:08
 * Author:wuxinrui
 */

public class lockCase {
    public static void main(String[] args) {
        System.out.println("running example with fair-mode= false");
        testPrintQueue(false);
        System.out.println("running example with fair-mode= true");
        testPrintQueue(true);

    }

    private static void testPrintQueue(boolean fairMode){
        PrintQueue printQueue = new PrintQueue(fairMode);
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue));
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
