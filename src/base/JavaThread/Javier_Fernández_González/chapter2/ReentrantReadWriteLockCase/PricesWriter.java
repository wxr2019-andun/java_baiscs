package base.JavaThread.Javier_Fernández_González.chapter2.ReentrantReadWriteLockCase;

import java.util.Date;

/**
 * Description:
 * GET-version:
 * Date:2020-05-18  18:24
 * Author:wuxinrui
 */

public class PricesWriter implements Runnable {
    private PricesInfo pricesInfo;

    public PricesWriter(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s: Writer: Attempt to modify the prices.\n", new Date());
            pricesInfo.setPrice(Math.random() * 10, Math.random() * 8);
            System.out.printf("%s: Writer: Prices have been modified.\n", new Date());
        }
    }
}
