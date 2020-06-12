package base.JavaThread.Javier_Fernández_González.chapter3.SemaphoreCase;

/**
 * Description:  [控制对资源的一个或多个副本的并发访问]
 * GET-version:
 * Date:2020-05-19  11:17
 * Author:wuxinrui
 */

public class SemaphoreJob implements  Runnable{
    private PrintQueue printQueue;

    public SemaphoreJob(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: 打印任务-开始\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: 打印任务-结束\n", Thread.currentThread().getName());
    }


}
