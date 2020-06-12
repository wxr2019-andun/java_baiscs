package base.JavaThread.Javier_Fernández_González.chapter2.Stamped_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  19:32
 * Author:wuxinrui
 */

public class SL_Writer implements Runnable{
    private final Position position;
    private final StampedLock stampedLock;

    public SL_Writer(Position position, StampedLock stampedLock) {
        this.position = position;
        this.stampedLock = stampedLock;
    }

    @Override
    public void run() {



        //【以上所有方法都会返回一个在锁中使用称为票据（stamp）的long型返回值。如果方法返回0，则表示当前线程获取锁失败。】


        for (int i = 0; i < 10; i++) {
            long  stamp = stampedLock.writeLock();
            try {
                System.out.println("writer lock acquired: "+stamp);
                position.setX(position.getX()+1);
                position.setY(position.getY()+1);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                stampedLock.unlockWrite(stamp);
                System.out.printf("writer %d : lock released \n ",stamp);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
