package base.JavaThread.Javier_Fernández_González.chapter2.lockCase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  11:45
 * Author:wuxinrui
 */

public class PrintQueue {
    private Lock queueLock;

    public PrintQueue(boolean fairMode) {
        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object obj) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);

            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds");
            System.out.println("线程：第一次使用锁："+Thread.currentThread().getName());
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),(duration / 1000));
            System.out.println("线程：第二次使用锁："+Thread.currentThread().getName());
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

    }
}
