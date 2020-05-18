package base.JavaThread.chapter2.Stamped_Lock;

import java.util.concurrent.locks.StampedLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  19:58
 * Author:wuxinrui
 */

public class SL_Case {
    public static void main(String[] args) {
        Position position = new Position();
        StampedLock stampedLock = new StampedLock();

        Thread writerT = new Thread(new SL_Writer(position,stampedLock));
        Thread readerT = new Thread(new SL_Reader(position,stampedLock));
        Thread optimisticReaderT = new Thread(new SL_OptimisticReader(position,stampedLock));

        writerT.start();
        readerT.start();
        optimisticReaderT.start();

        try {
            writerT.join();
            readerT.join();
            optimisticReaderT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
