package base.JavaThread.Javier_Fernández_González.chapter4.Executor_RejectedExecutionHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * GET-version:
 * Date:2020-05-21  18:40
 * Author:wuxinrui
 */

public class E1_Server {
    private final ThreadPoolExecutor threadPoolExecutor;

    //用Executors类来初始化ThreadPoolExecutor对象，并创建一个拒绝策略：
    public E1_Server( ) {
        //池大小
        threadPoolExecutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //创建拒绝策略-实例
        RejectedTaskController rejectedTaskController = new RejectedTaskController();
        //线程池执行器-设置拒绝策略
        threadPoolExecutor.setRejectedExecutionHandler(rejectedTaskController);
    }
    // 处理线程代码块
    public void executeTask(E1_Task e1_task){
        System.out.println("服务器： 当前任务已抵达");
        //调用执行器的execute()方法来提交任务：?
        threadPoolExecutor.execute(e1_task);//？在将来某个时候执行给定的任务。
        System.out.printf("服务器: 池大小: %d\n",threadPoolExecutor.getPoolSize());
        System.out.printf("服务器: 活跃数量: %d\n",threadPoolExecutor.getActiveCount());
        System.out.printf("服务器: 任务数量: %d\n", threadPoolExecutor.getTaskCount());
        System.out.printf("服务器: 已完成数量: %d\n",threadPoolExecutor.getCompletedTaskCount());
    }
    public void endServer(){
        threadPoolExecutor.shutdown();
    }



}
