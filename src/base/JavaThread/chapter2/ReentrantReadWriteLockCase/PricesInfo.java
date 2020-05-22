package base.JavaThread.chapter2.ReentrantReadWriteLockCase;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-18  18:02
 * Author:wuxinrui
 */

public class PricesInfo {
    private double price1;
    private double price2;

    private ReadWriteLock lock;

    public PricesInfo() {
        price1 = 0;
        price2 = 0;
       lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }
    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }
    public void setPrice(double price1,double price2){
        lock.writeLock().lock();
        System.out.printf("%s 商品- 写锁- 获取 \n",new Date());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.price1=price1;
        this.price2=price2;
        System.out.printf("%s 商品 写锁- 释放 \n",new Date());
        lock.writeLock().unlock();
    }


}
