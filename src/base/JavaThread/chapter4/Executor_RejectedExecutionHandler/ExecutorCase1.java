package base.JavaThread.chapter4.Executor_RejectedExecutionHandler;

/**
 * Description:
 *
 * 创建一个 线程执行器  并 实现 其 拒绝策略
 *
 * 当创建完一个执行器后，可以向其提交待执行的Runnable或是Callable实例对象。
 *
 * 可以调用shutdown()方法来终止一个执行器。调用后，
 * 执行器会等待运行中和待执行的任务执行完成后，结束自身的运行。
 *
 * 如果调用了shutdown()方法且执行器还未停止运行时，又向执行器提交一个任务，那么执行器将会拒
 * 绝该任务，因为当前执行器已经不再接受新任务。
 *
 * 何使用Executors类创建一个新的ThreadPoolExecutor对象、如何将任务提交给Executor，以及如何在Executor类中拒绝任务提交。
 *
 * GET-version:
 * Date:2020-05-21  18:08
 * Author:wuxinrui
 */

public class ExecutorCase1 {

   /*
   主线程main-
   线程执行器-ThreadPoolExecutor
   线程-task

   的确将创建和执行分离了

    */
    
    public static void main(String[] args) {
//        实例线程池执行者-
        E1_Server e1_service = new E1_Server();
        System.out.println("主程序-启动");
        for (int i = 0; i < 100; i++) {
            E1_Task e1_task = new E1_Task("task"+i);
            e1_service.executeTask(e1_task);
        }
        System.out.printf("主程序: 关闭执行器.\n");
        e1_service.endServer();

        System.out.printf("主程序: 启动新的工作.\n");
        E1_Task task=new E1_Task("Rejected task");

        e1_service.executeTask(task);
        System.out.printf("主程序: 结束.\n");

    }
}
