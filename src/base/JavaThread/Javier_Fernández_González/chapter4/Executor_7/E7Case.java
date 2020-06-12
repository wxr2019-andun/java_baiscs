package base.JavaThread.Javier_Fernández_González.chapter4.Executor_7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 *当提交一个任务给执行器后，它就会根据本身配置去执行任务。任务执行结束后，它就会从执行器中删除。如果想再次执行这个任务，则需要再次提交它。
 *Executor框架提供了ScheduledThreadPoolExecutor类，用于执行周期性任务
 *
 *
 * GET-version:
 * Date:2020-05-22  15:27
 * Author:wuxinrui
 */

public class E7Case {
    public static void main(String[] args) {


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        System.out.println("主线程-启动时间："+new Date());
        E7_task e7t = new E7_task("e7t");
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(e7t, 1,2, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.println("主程序-延迟  :"+scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scheduledExecutorService.shutdown();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程-结束时间："+new Date());

    }
}
