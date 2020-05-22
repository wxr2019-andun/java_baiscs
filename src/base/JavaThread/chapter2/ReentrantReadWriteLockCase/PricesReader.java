package base.JavaThread.chapter2.ReentrantReadWriteLockCase;

import java.util.Date;

/**
 * Description:
 * GET-version:
 * Date:2020-05-18  18:18
 * Author:wuxinrui
 */

public class PricesReader implements Runnable{
    private PricesInfo pricesInfo;

    public PricesReader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i <20; i++) {
            System.out.printf("times: %s threadName: %s  -Prices1:  %f \n",new Date(),Thread.currentThread().getName(),pricesInfo.getPrice1());
            System.out.printf("times: %s threadName: %s  -Prices2:  %f \n",new Date(),Thread.currentThread().getName(),pricesInfo.getPrice2());
        }
    }
}
