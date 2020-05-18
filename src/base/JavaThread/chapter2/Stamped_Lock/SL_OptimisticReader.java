package base.JavaThread.chapter2.Stamped_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  19:50
 * Author:wuxinrui
 */

public class SL_OptimisticReader implements Runnable {
    private final Position position;
    private final StampedLock stampedLock;

    public SL_OptimisticReader(Position position, StampedLock stampedLock) {
        this.position = position;
        this.stampedLock = stampedLock;
    }

    @Override
    public void run() {
        long stamp;
        for (int i = 0; i < 100; i++) {
            try {
                stamp = stampedLock.tryOptimisticRead();
                int x = position.getX();
                int y = position.getY();
//            验证锁
                if (stampedLock.validate(stamp)) {
                    System.out.printf("OptimisticRead : %d lock (%d,%d) \n", stamp, x, y);
                } else {
                    System.out.printf("OptimisticRead %d  not free \n", stamp);
                }
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
