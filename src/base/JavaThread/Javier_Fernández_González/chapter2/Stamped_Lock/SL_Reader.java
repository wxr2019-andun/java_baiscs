package base.JavaThread.Javier_Fernández_González.chapter2.Stamped_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  19:43
 * Author:wuxinrui
 */

public class SL_Reader implements Runnable {
    private final Position position;
    private final StampedLock stampedLock;

    public SL_Reader(Position position, StampedLock stampedLock) {
        this.position = position;
        this.stampedLock = stampedLock;
    }

    @Override
    public void run() {
        long stamp = stampedLock.readLock();
        try {
            for (int i = 0; i < 50; i++) {
                System.out.printf("reader : %d -(%d,%d) \n",stamp,position.getX(),position.getY());
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockRead(stamp);
            System.out.println("reader %d lock released \n");
        }
    }
}
