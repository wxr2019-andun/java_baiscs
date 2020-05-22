package base.JavaThread.chapter4.Executor_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:
 *
 * -运行多个任务并处理全部返回结果
 *
 * Future类，以获取提交到执行器中的任意任务的状态和返回结果。
 *
 *
 * -等待某个任务执行完毕
 *【ThreadPoolExecutor类提供了一个方法可以提交一个任务列表到执行器中，并等待列表内的全部任务执行完毕】
 *
 *
 *
 * GET-version:
 * Date:2020-05-22  14:21
 * Author:wuxinrui
 */

public class E5Case {
    public static void main(String[] args) {
        ExecutorService executorService = (ExecutorService) Executors.newCachedThreadPool();
        List<E5_Task> TaskArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            E5_Task e5_task = new E5_Task("et"+i);
            TaskArray.add(e5_task);
        }
        List<Future<E5_result>> farr = new ArrayList<>();
        try {
            farr= executorService.invokeAll(TaskArray);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        for (int i = 0; i < farr.size(); i++) {
            Future<E5_result> e5_resultFuture = farr.get(i);
            E5_result e5r = new E5_result();
            try {
                e5r=e5_resultFuture.get();
                System.out.println("result:"+e5r.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
