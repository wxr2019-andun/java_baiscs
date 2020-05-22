package base.JavaThread.chapter4.Executor_RejectedExecutionHandler;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-21  18:12
 * Author:wuxinrui
 */

public class E1_Task implements Runnable {
    private Date intiDate;
    private String name;

    public E1_Task(String name) {
        intiDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s ： 任务创建时间 ：%s \n" , Thread.currentThread().getName(),intiDate);
        System.out.printf("%s ： 任务指向时间 ：%s \n" , Thread.currentThread().getName(),new Date());

        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s ： 随机执行时间 : %d \n",Thread.currentThread().getName(),duration);
//            Thread.currentThread().sleep(1000);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s ： 任务结束时间 ：%s \n" , Thread.currentThread().getName(),new Date());
    }

}
