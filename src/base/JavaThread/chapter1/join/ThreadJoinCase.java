package base.JavaThread.chapter1.join;

import util.DateUtil;

/**
 * Description: 撤掉join后 main方法与线程通知执行   加join后顺序执行-适用于资源初始化.
 * join(1000)milli 等待时间-超过后正常执行.
 * GET-version:
 * Date:2020-05-13  15:18
 * Author:wuxinrui
 */

public class ThreadJoinCase {
    public static void main(String[] args) {
        VirtualDataSourcesLoader virtualDataSourcesLoader = new VirtualDataSourcesLoader();
        VirtualNetWorkConnectionsLoader virtualNetWorkConnectionsLoader = new VirtualNetWorkConnectionsLoader();
        Thread t1  = new Thread(virtualDataSourcesLoader,"virtualDataSourcesLoader");
        Thread t2 = new Thread(virtualNetWorkConnectionsLoader, "virtualNetWorkConnectionsLoader");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.printf("main configuration has been loaded: %s\n", DateUtil.CalendarNowTimeString(2));
    }

}
