package base.JavaThread.Javier_Fernández_González.chapter2.production_shopping;

/**
 * Description:  生产消费模式-完成线程同步 synchronized修饰方法
 * GET-version:
 * Date:2020-05-15  10:59
 * Author:wuxinrui
 */

public class psCase {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Comsumer comsumer = new Comsumer(eventStorage);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(comsumer);
        t1.start();t2.start();


    }
}
