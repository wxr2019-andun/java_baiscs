package base.JavaThread.chapter4.Executor_6;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * [在执行器内延迟运行任务]
 * 有可能你不需要尽快执行提交的任务，而是想要在一段时间后执行任务或是周期性地执行任务。基于以上需求
 *
 * Executor框架
 * [ScheduledExecutorService接口和 它的实现类ScheduledThreadPool- Executor类。]
 *
 * schedule
 * awaitTermination
 *
 * GET-version:
 * Date:2020-05-22  14:57
 * Author:wuxinrui
 */

public class E6_Case {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        System.out.println("主线程-启动时间："+new Date());
        for (int i = 0; i < 5; i++) {
            E6_Task e6_task = new E6_Task("e6t:"+i);
            scheduledExecutorService.schedule(e6_task,i+1, TimeUnit.SECONDS);
        }
        scheduledExecutorService.shutdown();
        try {
            scheduledExecutorService.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程-结束时间："+new Date());
    }
}
