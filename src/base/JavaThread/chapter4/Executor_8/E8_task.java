package base.JavaThread.chapter4.Executor_8;

import java.util.concurrent.*;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  16:31
 * Author:wuxinrui
 */

public class E8_task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true){
            System.out.println("delay-");
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        E8_task e8_task = new E8_task();
        System.out.println("main Executing task");
        Future<String> stringFuture = null;
        try {
           stringFuture= threadPoolExecutor.submit(e8_task);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main- Executing task");
        stringFuture.cancel(true);

        System.out.printf("Main: Canceled: %s\n",stringFuture.isCancelled());
        System.out.printf("Main: Done: %s\n",stringFuture.isDone());

        threadPoolExecutor.shutdown();
        System.out.printf("Main: The executor has finished\n");

    }
}
