package base.JavaThread.chapter2.ReentrantReadWriteLockCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-18  18:23
 * Author:wuxinrui
 */

public class ReentrantReadWriteLockCase {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();


//        Thread[] threads = new Thread[5];
//        Thread WriterT = new Thread(new PricesWriter(pricesInfo));
//        for (int i = 0; i < 5; i++) {
//            threads[i] = new Thread(new PricesReader(pricesInfo));
//        }
//        for (int i = 0; i < 5; i++) {
//            threads[i].start();
//        }
//        WriterT.start();



        PricesReader readers[]=new PricesReader[2];
        Thread threadsReader[]=new Thread[2];
        PricesWriter pricesWriter = new PricesWriter(pricesInfo);
        Thread threadWriter = new Thread(pricesWriter);
        for (int i=0; i<2; i++){
            readers[i]=new PricesReader(pricesInfo);
            threadsReader[i]=new Thread(readers[i]);
        }



        for (int i=0; i<2; i++){
            threadsReader[i].start();
        }
        threadWriter.start();

    }
}
