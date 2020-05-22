package base.JavaThread.chapter3.SemaphoreCase;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  10:54
 * Author:wuxinrui
 */

public class PrintQueue {
    private final Semaphore semaphore;
    private final boolean freePrintrs[];
    private final Lock lock;

    public PrintQueue() {
        semaphore = new Semaphore(5);//许可证-数量
        freePrintrs = new boolean[]{true, true, true};
        lock = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire(); //从该信号量获取许可证，阻止直到可用，或线程为 interrupted 。
            int assignedPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s - %s: 打印队列:在打印机中打印作业 %d 持续： %d 秒\n",
                    new Date(), Thread.currentThread().getName(), assignedPrinter, duration);

            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); //释放许可证，将其返回到信号量。
        }
    }

    public int getPrinter() {
        int ret = -1;
        try {
            lock.lock();
            for (int i = 0; i < freePrintrs.length; i++) {
                if (freePrintrs[i]) {
                    ret = i;
                    freePrintrs[i] = false;
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
        return ret;
    }

}
